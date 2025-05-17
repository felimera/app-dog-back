package com.project.app_dog_back.domain.service;

import com.project.app_dog_back.application.dto.NotificacionDto;

import java.util.List;

public interface INotificacionService {
    NotificacionDto create(NotificacionDto dto);

    NotificacionDto getById(Long id);

    List<NotificacionDto> getAll();
}
