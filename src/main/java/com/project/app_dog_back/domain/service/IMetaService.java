package com.project.app_dog_back.domain.service;

import com.project.app_dog_back.application.response.Meta;

public interface IMetaService {
    Meta buildMetaBody(String codMessage, String types);
}
