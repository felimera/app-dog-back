package com.project.app_dog_back.domain.service;

import com.project.app_dog_back.application.dto.PerroDto;

public interface IPerroService {
    PerroDto create(PerroDto perroDto);

    PerroDto getById(Long id);
}
