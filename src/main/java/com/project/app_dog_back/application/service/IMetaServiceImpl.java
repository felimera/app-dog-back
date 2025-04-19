package com.project.app_dog_back.application.service;

import com.project.app_dog_back.application.response.Meta;
import com.project.app_dog_back.domain.service.IMessageService;
import com.project.app_dog_back.domain.service.IMetaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
