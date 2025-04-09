package com.project.app_dog_back.domain.service;

import com.project.app_dog_back.application.dto.SalidaDto;

import java.util.List;

public interface ISalidaService {
    SalidaDto getById(Long id);

    List<SalidaDto> getAll();

    SalidaDto create(SalidaDto dto);
}
