package com.salon.salon.validations;


import java.util.regex.Pattern;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class WhatsAppNumberValidator implements ConstraintValidator<ValidWhatsAppNumber, String> {

    private static final String WHATSAPP_REGEX = "^\\+(?:[0-9] ?){6,14}[0-9]$"; // Aceita números com código do país

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null || value.isEmpty()) return false; // Evita valores nulos
        return Pattern.compile(WHATSAPP_REGEX).matcher(value).matches();
    }
}


