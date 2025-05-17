package com.project.app_dog_back.domain.service;

import com.project.app_dog_back.application.dto.SuministroAlimentoDto;
import com.project.app_dog_back.domain.model.entity.SuministroAlimento;

import java.util.List;

public interface ISuministroAlimentoService {
    SuministroAlimentoDto getById(Long id);

    List<SuministroAlimentoDto> getAll();

    SuministroAlimentoDto create(SuministroAlimentoDto dto);

    SuministroAlimento getSuministraAlimentoById(Long idSuministroAlimento);
}
