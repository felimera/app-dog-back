package com.project.app_dog_back.application.service;

import com.project.app_dog_back.application.dto.DosisMedicamentoDto;
import com.project.app_dog_back.application.mapper.IDosisMedicamentoMapper;
import com.project.app_dog_back.domain.model.entity.DosisMedicamento;
import com.project.app_dog_back.domain.repository.IDosisMedicamentoRepository;
import com.project.app_dog_back.domain.service.IDosisMedicamentoService;
import com.project.app_dog_back.domain.service.IMedicamentoService;
import com.project.app_dog_back.domain.service.IMessageService;
import com.project.app_dog_back.insfraestructure.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;

@Service
public class IDosisMedicamentoServiceImpl implements IDosisMedicamentoService {
    private IDosisMedicamentoRepository iDosisMedicamentoRepository;
    private IMessageService iMessageService;
    private IMedicamentoService iMedicamentoService;

    @Autowired
    public IDosisMedicamentoServiceImpl(IDosisMedicamentoRepository iDosisMedicamentoRepository, IMessageService iMessageService, IMedicamentoService iMedicamentoService) {
        this.iDosisMedicamentoRepository = iDosisMedicamentoRepository;
        this.iMessageService = iMessageService;
        this.iMedicamentoService = iMedicamentoService;
    }

    @Override
    public DosisMedicamentoDto getById(Long id) {
        Locale locale = LocaleContextHolder.getLocale();
        String message = iMessageService.getMensaje("infor.not_found", locale);
        DosisMedicamento entity = iDosisMedicamentoRepository.findById(id).orElseThrow(() -> new NotFoundException(message, String.valueOf(HttpStatus.NOT_FOUND.value()), HttpStatus.NOT_FOUND));
        return IDosisMedicamentoMapper.INSTANCE.toDto(entity);
    }

    @Override
    public List<DosisMedicamentoDto> getAll() {
        return iDosisMedicamentoRepository.findAll().stream().map(IDosisMedicamentoMapper.INSTANCE::toDto).toList();
    }

    @Override
    public DosisMedicamentoDto create(DosisMedicamentoDto dto) {
        DosisMedicamento entity = IDosisMedicamentoMapper.INSTANCE.toEntity(dto);
        entity.setMedicamento(iMedicamentoService.getMedicamentoById(dto.getIdMedicamento()));
        return IDosisMedicamentoMapper.INSTANCE.toDto(iDosisMedicamentoRepository.save(entity));
    }

    @Override
    public DosisMedicamento getDosisMedicamento(Long idDosisMedicamento) {
        Locale locale = LocaleContextHolder.getLocale();
        String message = iMessageService.getMensaje("infor.not_found", locale);
        return iDosisMedicamentoRepository.findById(idDosisMedicamento).orElseThrow(() -> new NotFoundException(message, String.valueOf(HttpStatus.NOT_FOUND.value()), HttpStatus.NOT_FOUND));
    }
}
