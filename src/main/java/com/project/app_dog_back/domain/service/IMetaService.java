package com.project.app_dog_back.domain.service;

import com.project.app_dog_back.application.response.Meta;
import com.project.app_dog_back.insfraestructure.exception.ResponseMessageException;

public interface IMetaService {
    Meta buildMetaBody(String codMessage, String types);

    Meta buildMetaBodyWithEx(String types, ResponseMessageException exception);
}
