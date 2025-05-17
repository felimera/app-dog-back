package com.project.app_dog_back.domain.service;

import com.project.app_dog_back.application.dto.catalog.IccDto;
import com.project.app_dog_back.domain.model.catalog.Icc;

import java.util.List;

public interface IIccService {
    List<IccDto> getAll();

    Icc getById(Long idIcc);
}
