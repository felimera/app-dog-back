package com.project.app_dog_back.application.service;

import com.project.app_dog_back.application.response.Meta;
import com.project.app_dog_back.application.response.error.KeyValueError;
import com.project.app_dog_back.domain.service.IMessageService;
import com.project.app_dog_back.domain.service.IMetaService;
import com.project.app_dog_back.insfraestructure.exception.ResponseMessageException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class IMetaServiceImpl implements IMetaService {
    private IMessageService iMessageService;

    @Autowired
    public IMetaServiceImpl(IMessageService iMessageService) {
        this.iMessageService = iMessageService;
    }

    @Override
    public Meta buildMetaBody(String codMessage, String types) {
        String message = iMessageService.getMessage(codMessage);
        return Meta
                .builder()
                .build()
                .toEditStatusAndMessage(
                        types,
                        message
                );
    }

    @Override
    public Meta buildMetaBodyWithEx(String types, ResponseMessageException exception) {
        String message = "";
        for (String value : exception.getKeyValueErrors().stream().map(KeyValueError::getAttributeValue).toList()) {
            message = message.concat(value).concat(" ");
        }

        return Meta
                .builder()
                .build()
                .toEditStatusAndMessage(
                        types,
                        message
                );
    }
}
