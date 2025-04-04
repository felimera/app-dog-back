package com.project.app_dog_back.domain.service;

import com.project.app_dog_back.application.dto.UnidadMasaDto;
import com.project.app_dog_back.domain.model.catalog.UnidadMasa;

import java.util.List;

public interface IUnidadMasaService {
    List<UnidadMasaDto> getAll();

    UnidadMasa getById(Long idUnidadMasa);
}
