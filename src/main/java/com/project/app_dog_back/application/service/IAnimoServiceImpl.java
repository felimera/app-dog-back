package com.project.app_dog_back.application.service;

import com.project.app_dog_back.application.dto.AnimoDto;
import com.project.app_dog_back.application.mapper.IAnimoMapper;
import com.project.app_dog_back.domain.repository.IAnimoRepository;
import com.project.app_dog_back.domain.service.IAnimoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IAnimoServiceImpl implements IAnimoService {

    private IAnimoRepository iAnimoRepository;

    @Autowired
    public IAnimoServiceImpl(IAnimoRepository iAnimoRepository) {
        this.iAnimoRepository = iAnimoRepository;
    }

    @Override
    public List<AnimoDto> getAll() {
        return iAnimoRepository.findAll().stream().map(IAnimoMapper.INSTANCE::toDto).toList();
    }
}
