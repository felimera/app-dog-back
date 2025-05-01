package com.project.app_dog_back.application.service;

import com.project.app_dog_back.application.dto.SuministroAlimentoDto;
import com.project.app_dog_back.application.mapper.ISuministroAlimentoMapper;
import com.project.app_dog_back.domain.model.entity.SuministroAlimento;
import com.project.app_dog_back.domain.repository.ISuministroAlimentoRepository;
import com.project.app_dog_back.domain.service.IAlimentoService;
import com.project.app_dog_back.domain.service.IMessageService;
import com.project.app_dog_back.domain.service.ISuministroAlimentoService;
import com.project.app_dog_back.insfraestructure.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;

@Service
public class ISuministroAlimentoServiceImpl implements ISuministroAlimentoService {
    private ISuministroAlimentoRepository iSuministroAlimentoRepository;
    private IMessageService iMessageService;
    private IAlimentoService iAlimentoService;

    @Autowired
    public ISuministroAlimentoServiceImpl(ISuministroAlimentoRepository iSuministroAlimentoRepository, IMessageService iMessageService, IAlimentoService iAlimentoService) {
        this.iSuministroAlimentoRepository = iSuministroAlimentoRepository;
        this.iMessageService = iMessageService;
        this.iAlimentoService = iAlimentoService;
    }

    @Override
    public SuministroAlimentoDto getById(Long id) {
        Locale locale = LocaleContextHolder.getLocale();
        String message = iMessageService.getMensaje("infor.not_found", locale);
        SuministroAlimento entity = iSuministroAlimentoRepository.findById(id).orElseThrow(() -> new NotFoundException(message, String.valueOf(HttpStatus.NOT_FOUND.value()), HttpStatus.NOT_FOUND));
        return ISuministroAlimentoMapper.INSTANCE.toDto(entity);
    }

    @Override
    public List<SuministroAlimentoDto> getAll() {
        return iSuministroAlimentoRepository.findAll().stream().map(ISuministroAlimentoMapper.INSTANCE::toDto).toList();
    }

    @Override
    public SuministroAlimentoDto create(SuministroAlimentoDto dto) {
        SuministroAlimento entity = ISuministroAlimentoMapper.INSTANCE.toEntity(dto);
        entity.setAlimento(iAlimentoService.getAlimentoById(dto.getIdAlimento()));
        return ISuministroAlimentoMapper.INSTANCE.toDto(iSuministroAlimentoRepository.save(entity));
    }
}
