package com.aleksandr0412.bookstore.appender;

import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.db.DBAppenderBase;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.time.Instant;

/**
 * Appender для логирования событий в базу данных
 */

@Component
public class DBAppender extends DBAppenderBase<ILoggingEvent> {

    private static final String TABLE_NAME = "audit_log";
    private static final String UUID = "uuid";
    private static final String AUDIT_CODE = "audit_code";
    private static final String LOG_EVENT_STATUS = "log_event_status";
    private static final String TIME_START = "time_start";
    private static final String TIME_END = "time_end";
    private static final String USERNAME = "username";
    private static final String PARAMS = "params";
    private static final String RETURN_VALUE = "return_value";

    private static final Method GET_GENERATED_KEYS_METHOD;

    static {
        Method getGeneratedKeysMethod;
        try {
            getGeneratedKeysMethod = PreparedStatement.class.getMethod("getGeneratedKeys", (Class[]) null);
        } catch (final Exception ex) {
            getGeneratedKeysMethod = null;
        }
        GET_GENERATED_KEYS_METHOD = getGeneratedKeysMethod;
    }

    private String insertSQL;

    static String buildInsertSQL() {
        final StringBuilder sqlBuilder = new StringBuilder("INSERT INTO ");
        sqlBuilder.append(TABLE_NAME).append(" (");
        sqlBuilder.append(UUID).append(", ");
        sqlBuilder.append(AUDIT_CODE).append(", ");
        sqlBuilder.append(LOG_EVENT_STATUS).append(", ");
        sqlBuilder.append(TIME_START).append(", ");
        sqlBuilder.append(TIME_END).append(", ");
        sqlBuilder.append(USERNAME).append(", ");
        sqlBuilder.append(PARAMS).append(", ");
        sqlBuilder.append(RETURN_VALUE).append(") ");
        sqlBuilder.append("VALUES (?, ?, ?, " +
                "TIMESTAMP WITH Time Zone 'epoch' + ? * INTERVAL '1 millisecond', " +
                "TIMESTAMP WITH Time Zone 'epoch' + ? * INTERVAL '1 millisecond', " +
                "?, ?, ?)");
        return sqlBuilder.toString();
    }

    @Override
    public void start() {
        insertSQL = buildInsertSQL();
        super.start();
    }

    @Override
    protected Method getGeneratedKeysMethod() {
        return GET_GENERATED_KEYS_METHOD;
    }

    @Override
    protected String getInsertSQL() {
        return insertSQL;
    }

    @Override
    protected void subAppend(final ILoggingEvent eventObject, final Connection connection, final PreparedStatement statement) throws Throwable {
        final String[] array = eventObject.getFormattedMessage().split(";");
        for (int i = 0; i < array.length; i++) {
            if ("null".equals(array[i])) {
                array[i] = null;
            }
        }

        statement.setObject(1, java.util.UUID.fromString(array[0]));
        statement.setString(2, array[1]);
        statement.setString(3, array[2]);
        statement.setLong(4, getInstantTime(array[3]));
        statement.setLong(5, getInstantTime(array[4]));
        statement.setString(6, array[5]);
        statement.setString(7, array[6]);
        statement.setString(8, array[7]);

        final int updateCount = statement.executeUpdate();
        if (updateCount != 1) {
            addWarn("Failed to insert loggingAspectEvent");
        }
    }

    private Long getInstantTime(@Nullable final String str) {
        if (str == null) {
            return Long.valueOf(-1);
        }
        return Instant.parse(str).toEpochMilli();
    }

    @Override
    protected void secondarySubAppend(final ILoggingEvent eventObject, final Connection connection, final long eventId) throws Throwable {
        final String timeEnd = eventObject.getFormattedMessage().split(";")[4];
        if ("null".equals(timeEnd)) {
            final StringBuilder sqlBuilder = new StringBuilder("UPDATE ");
            sqlBuilder.append(TABLE_NAME).append(" SET ");
            sqlBuilder.append(TIME_END).append(" = null ");
            sqlBuilder.append("WHERE event_id = ").append(eventId);
            connection.prepareStatement(sqlBuilder.toString()).executeUpdate();
        }
    }
}
