package com.salon.salon.validations;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Documented
@Constraint(validatedBy = WhatsAppNumberValidator.class) // Conecta ao validador
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidWhatsAppNumber {
    String message() default "Número de WhatsApp inválido";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}

