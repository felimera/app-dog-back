package com.project.app_dog_back.domain.service;

import com.project.app_dog_back.application.dto.AlimentoDto;
import com.project.app_dog_back.domain.model.entity.Alimento;

import java.util.List;

public interface IAlimentoService {
    List<AlimentoDto> getAll();

    AlimentoDto getById(Long idAlimento);

    Alimento getAlimentoById(Long idAlimento);

    AlimentoDto create(AlimentoDto dto);
}
