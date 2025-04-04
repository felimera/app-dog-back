package com.project.app_dog_back.application.service;

import com.project.app_dog_back.application.dto.UnidadMasaDto;
import com.project.app_dog_back.application.mapper.IUnidadMasaMapper;
import com.project.app_dog_back.domain.repository.IUnidadMasaRepository;
import com.project.app_dog_back.domain.service.IUnidadMasaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IUnidadMasaServiceImpl implements IUnidadMasaService {
    private IUnidadMasaRepository iUnidadMasaRepository;

    @Autowired
    public IUnidadMasaServiceImpl(IUnidadMasaRepository iUnidadMasaRepository) {
        this.iUnidadMasaRepository = iUnidadMasaRepository;
    }

    @Override
    public List<UnidadMasaDto> getAll() {
        return iUnidadMasaRepository.findAll().stream().map(IUnidadMasaMapper.INSTANCE::toDto).toList();
    }
}
