package com.project.app_dog_back.application.service;

import com.project.app_dog_back.application.dto.RevisionDto;
import com.project.app_dog_back.application.mapper.IRevisionMapper;
import com.project.app_dog_back.domain.model.entity.Revision;
import com.project.app_dog_back.domain.repository.IRevisionRepository;
import com.project.app_dog_back.domain.service.*;
import com.project.app_dog_back.insfraestructure.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;

@Service
public class IRevisionServiceImpl implements IRevisionService {
    private IRevisionRepository iRevisionRepository;
    private IMessageService iMessageService;
    private IMascotaService iMascotaService;
    private IMovilidadService iMovilidadService;
    private IAnimoService iAnimoService;
    private IIccService iIccService;
    private IUnidadMasaService iUnidadMasaService;

    @Autowired
    public IRevisionServiceImpl(IRevisionRepository iRevisionRepository, IMessageService iMessageService, IMascotaService iMascotaService, IMovilidadService iMovilidadService, IAnimoService iAnimoService, IIccService iIccService, IUnidadMasaService iUnidadMasaService) {
        this.iRevisionRepository = iRevisionRepository;
        this.iMessageService = iMessageService;
        this.iMascotaService = iMascotaService;
        this.iMovilidadService = iMovilidadService;
        this.iAnimoService = iAnimoService;
        this.iIccService = iIccService;
        this.iUnidadMasaService = iUnidadMasaService;
    }

    @Override
    public RevisionDto getById(Long id) {
        Locale locale = LocaleContextHolder.getLocale();
        String message = iMessageService.getMensaje("infor.not_found", locale);
        Revision entity = iRevisionRepository.findById(id).orElseThrow(() -> new NotFoundException(message, String.valueOf(HttpStatus.NOT_FOUND.value()), HttpStatus.NOT_FOUND));
        return IRevisionMapper.INSTANCE.toDto(entity);
    }

    @Override
    public List<RevisionDto> getAll() {
        return iRevisionRepository.findAll().stream().map(IRevisionMapper.INSTANCE::toDto).toList();
    }

    @Override
    public RevisionDto create(RevisionDto dto) {
        Revision entity = IRevisionMapper.INSTANCE.toEntity(dto);
        entity.setMascota(iMascotaService.getMascotaById(dto.getIdMascota()));
        entity.setIcc(iIccService.getById(dto.getIdIcc()));
        entity.setMovilidad(iMovilidadService.getById(dto.getIdMovilidad()));
        entity.setAnimo(iAnimoService.getById(dto.getIdAnimo()));
        entity.setUnidadMasa(iUnidadMasaService.getById(dto.getIdUnidadMasa()));

        return IRevisionMapper.INSTANCE.toDto(iRevisionRepository.save(entity));
    }
}
