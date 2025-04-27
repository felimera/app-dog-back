package com.project.app_dog_back.domain.service;

import com.project.app_dog_back.application.dto.catalog.RazaDto;
import com.project.app_dog_back.domain.model.catalog.Raza;

import java.util.List;

public interface IRazaService {
    List<RazaDto> getAll();

    Raza getById(Long idRaza);
}
