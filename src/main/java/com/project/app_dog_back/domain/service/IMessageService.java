package com.project.app_dog_back.domain.service;

import java.util.Locale;

public interface IMessageService {
    String getMensaje(String codigo, Locale locale);

    String getMessage(String codigo);
}
