package com.project.app_dog_back.application.service;

import com.project.app_dog_back.application.dto.SalidaDto;
import com.project.app_dog_back.application.mapper.ISalidaMapper;
import com.project.app_dog_back.domain.model.entity.Salida;
import com.project.app_dog_back.domain.repository.ISalidaRepository;
import com.project.app_dog_back.domain.service.IMascotaService;
import com.project.app_dog_back.domain.service.IMessageService;
import com.project.app_dog_back.domain.service.ISalidaService;
import com.project.app_dog_back.insfraestructure.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;

@Service
public class ISalidaServiceImpl implements ISalidaService {
    private ISalidaRepository iSalidaRepository;
    private IMessageService iMessageService;
    private IMascotaService iMascotaService;

    @Autowired
    public ISalidaServiceImpl(ISalidaRepository iSalidaRepository, IMessageService iMessageService, IMascotaService iMascotaService) {
        this.iSalidaRepository = iSalidaRepository;
        this.iMessageService = iMessageService;
        this.iMascotaService = iMascotaService;
    }

    @Override
    public SalidaDto getById(Long id) {
        Locale locale = LocaleContextHolder.getLocale();
        String message = iMessageService.getMensaje("infor.not_found", locale);
        Salida entity = iSalidaRepository.findById(id).orElseThrow(() -> new NotFoundException(message, String.valueOf(HttpStatus.NOT_FOUND.value()), HttpStatus.NOT_FOUND));
        return ISalidaMapper.INSTANCE.toDto(entity);
    }

    @Override
    public List<SalidaDto> getAll() {
        return iSalidaRepository.findAll().stream().map(ISalidaMapper.INSTANCE::toDto).toList();
    }

    @Override
    public SalidaDto create(SalidaDto dto) {

        Salida entity = ISalidaMapper.INSTANCE.toEntity(dto);
        entity.setMascota(iMascotaService.getMascotaById(dto.getIdPerro()));

        return ISalidaMapper.INSTANCE.toDto(iSalidaRepository.save(entity));
    }
}
