package com.project.app_dog_back.domain.service;

import com.project.app_dog_back.application.dto.RevisionDto;

import java.util.List;

public interface IRevisionService {
    RevisionDto getById(Long id);

    List<RevisionDto> getAll();

    RevisionDto create(RevisionDto dto);
}
