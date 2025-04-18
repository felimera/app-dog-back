package com.project.app_dog_back.application.service;

import com.project.app_dog_back.domain.service.IMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;

import java.util.Locale;

@Service
public class IMessageServiceImpl implements IMessageService {

    private MessageSource messageSource;

    @Autowired
    public IMessageServiceImpl(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @Override
    public String getMensaje(String codigo, Locale locale) {
        return messageSource.getMessage(codigo, null, locale);
    }

    @Override
    public String getMessage(String codigo) {
        Locale locale = LocaleContextHolder.getLocale();
        return messageSource.getMessage(codigo, null, locale);
    }
}
