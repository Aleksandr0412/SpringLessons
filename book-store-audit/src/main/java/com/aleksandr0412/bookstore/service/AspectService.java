package com.aleksandr0412.bookstore.service;

import com.aleksandr0412.bookstore.annotations.Audit;
import com.aleksandr0412.bookstore.constants.EventCode;
import com.aleksandr0412.bookstore.entity.EventLogEntity;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.web.util.UriComponentsBuilder;

import java.time.Instant;
import java.util.Arrays;

/**
 * Аспект для аудита события добавления, обновления, удаления
 */
@Component
@Aspect
public class AspectService {

    private static final Logger log = LoggerFactory.getLogger(AspectService.class.getName());

    /**
     * Срез события публичного метода с аннотацией Audit
     */
    @Pointcut("@annotation(com.aleksandr0412.bookstore.annotations.Audit) && execution(public * *(..))")
    public void publicAspectAudit() {
    }

    @Around(value = "publicAspectAudit()")
    public Object auditStart(final ProceedingJoinPoint joinPoint) throws Throwable {
        final EventLogEntity eventLogEntity = new EventLogEntity();
        auditBegin(joinPoint, eventLogEntity);
        final Object proceed;
        try {
            proceed = joinPoint.proceed();
        } catch (final Exception e) {
            eventLogEntity.setLogEventStatus(EventCode.FAILURE);
            eventLogEntity.setTimeEnd(Instant.now());
            log.info(eventLogEntity.toString());
            throw e;
        }
        auditEnd(proceed, eventLogEntity);
        return proceed;
    }

    private void auditBegin(ProceedingJoinPoint joinPoint, EventLogEntity eventLogEntity) throws JsonProcessingException {
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        Audit annotation = methodSignature.getMethod().getAnnotation(Audit.class);
        eventLogEntity.setAuditCode(annotation.value());
        eventLogEntity.setLogEventStatus(EventCode.START);
        eventLogEntity.setTimeStart(Instant.now());
        final Object[] params = Arrays.stream(joinPoint.getArgs())
                .filter(obj -> !(obj instanceof BindingResult))
                .filter(obj -> !(obj instanceof UriComponentsBuilder))
                .toArray();
        try {
            eventLogEntity.setParams(new ObjectMapper().writeValueAsString(params));
        } catch (final JsonProcessingException e) {
            log.info(eventLogEntity.toString());
            eventLogEntity.setLogEventStatus(EventCode.FAILURE);
            eventLogEntity.setTimeEnd(Instant.now());
            log.info(eventLogEntity.toString());
            throw e;
        }
        log.info(eventLogEntity.toString());
    }

    private void auditEnd(final Object obj, final EventLogEntity eventLogEntity) {
        try {
            eventLogEntity.setReturnValue(new ObjectMapper().writeValueAsString(obj));
        } catch (final JsonProcessingException e) {
            e.printStackTrace();
        }
        eventLogEntity.setLogEventStatus(EventCode.SUCCESS);
        eventLogEntity.setTimeEnd(Instant.now());
        log.info(eventLogEntity.toString());
    }
}
