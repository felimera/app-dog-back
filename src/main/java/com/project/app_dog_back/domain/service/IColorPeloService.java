package com.project.app_dog_back.domain.service;

import com.project.app_dog_back.application.dto.catalog.ColorPeloDto;
import com.project.app_dog_back.domain.model.catalog.ColorPelo;

import java.util.List;

public interface IColorPeloService {
    List<ColorPeloDto> getAll();

    ColorPelo getById(Long idColorPelo);
}
