package com.project.app_dog_back.insfraestructure.utils;

import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;

@Slf4j
public class DateUtil {
    private DateUtil() {
        throw new IllegalStateException(DateUtil.class.toString());
    }

    public static LocalDateTime getLocalDateTimeOfString(String fecha) {
        DateTimeFormatter formatter = DateTimeFormatter.ISO_OFFSET_DATE_TIME;
        try {
            OffsetDateTime offsetDateTime = OffsetDateTime.parse(fecha, formatter);
            return offsetDateTime.toLocalDateTime();
        } catch (Exception e) {
            log.error("Error al parsear la fecha: " + fecha);
            return null;
        }
    }
}
