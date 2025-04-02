package com.project.app_dog_back.application.service;

import com.project.app_dog_back.application.dto.IccDto;
import com.project.app_dog_back.application.mapper.IIccMapper;
import com.project.app_dog_back.domain.repository.IIccRepository;
import com.project.app_dog_back.domain.service.IIccService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IIccServiceImpl implements IIccService {

    private IIccRepository iIccRepository;

    @Autowired
    public IIccServiceImpl(IIccRepository iIccRepository) {
        this.iIccRepository = iIccRepository;
    }

    @Override
    public List<IccDto> getAll() {
        return iIccRepository.findAll().stream().map(IIccMapper.INSTANCE::toDto).toList();
    }
}
