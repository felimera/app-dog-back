package com.project.app_dog_back.domain.service;

import com.project.app_dog_back.application.dto.MascotaDto;
import com.project.app_dog_back.domain.model.entity.Mascota;

import java.util.List;

public interface IMascotaService {
    MascotaDto create(MascotaDto mascotaDto);

    MascotaDto getById(Long id);

    Mascota getMascotaById(Long idMascota);

    List<MascotaDto> getAll();
}
