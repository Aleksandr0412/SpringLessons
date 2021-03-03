package com.aleksandr0412.bookstore.service;

import com.aleksandr0412.bookstore.annotations.Audit;
import com.aleksandr0412.bookstore.constants.EventCode;
import com.aleksandr0412.bookstore.entity.AuditMessage;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.util.UriComponentsBuilder;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.UUID;

@Component
@Aspect
public class AspectService {
    private static final Logger log = LoggerFactory.getLogger(AspectService.class.getName());

    @Pointcut("@annotation(com.aleksandr0412.bookstore.annotations.Audit) && execution(public * *(..))")
    public void publicAspectAudit() {
    }

    @Around(value = "publicAspectAudit()")
    public Object aspect(ProceedingJoinPoint joinPoint) throws Throwable {
        ObjectMapper om = new ObjectMapper();
        AuditMessage auditMessage = new AuditMessage();
        UUID uuid = UUID.randomUUID();
        auditMessage.setUuid(uuid);
        auditMessage.setAuditCode(((MethodSignature) joinPoint.getSignature()).getMethod().getAnnotation(Audit.class).value());
        auditMessage.setEventCode(EventCode.START);
        auditMessage.setTimeStart(LocalDateTime.now());
        auditMessage.setUsername("");
        Object[] args = Arrays.stream(joinPoint.getArgs())
                .filter(arg -> !(arg instanceof UriComponentsBuilder)).toArray();
        auditMessage.setParams(om.writeValueAsString(args));

        log.info(auditMessage.toString());

        Object proceed;

        try {
            proceed = joinPoint.proceed();
            auditMessage.setEventCode(EventCode.SUCCESS);
            auditMessage.setTimeEnd(LocalDateTime.now());
            auditMessage.setReturnValue(om.writeValueAsString(proceed));
            log.info(auditMessage.toString());
        } catch (Exception e) {
            auditMessage.setEventCode(EventCode.FAILURE);
            auditMessage.setTimeEnd(LocalDateTime.now());
            auditMessage.setReturnValue(e.getMessage());
            log.info(auditMessage.toString());
            throw e;
        }
        return proceed;
    }
}
