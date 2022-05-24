package ru.kuznetsovka.rightStepTest.config;

import org.springframework.core.convert.converter.Converter;
import ru.kuznetsovka.rightStepTest.domain.Color;

public class StringToEnumConverter implements Converter<String, Color> {
    @Override
    public Color convert(String source) {
        try {
            return Color.valueOf(source.toUpperCase());
        } catch (IllegalArgumentException e) {
            return null;
        }
    }
}