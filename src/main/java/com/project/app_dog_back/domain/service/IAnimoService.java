package com.project.app_dog_back.domain.service;

import com.project.app_dog_back.application.dto.AnimoDto;

import java.util.List;

public interface IAnimoService {
    List<AnimoDto> getAll();
}
