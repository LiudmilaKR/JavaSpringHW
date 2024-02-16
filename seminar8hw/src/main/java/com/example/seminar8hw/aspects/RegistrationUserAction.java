package com.example.seminar8hw.aspects;

import lombok.extern.java.Log;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Log
public class RegistrationUserAction {

    @Around("@annotation(com.example.seminar8hw.aspects.TrackUserAction)")
    public Object logging(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("Вызван метод " + joinPoint.getStaticPart().getSignature().getName());
        log.info(joinPoint.getSignature().getName());
        Object proceed = joinPoint.proceed();
        System.out.println("Метод " + joinPoint.getStaticPart().getSignature().getName() + " завершен");
        log.info(joinPoint.getSignature().toString());
        return proceed;
    }
}
