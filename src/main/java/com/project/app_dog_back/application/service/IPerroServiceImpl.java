package com.project.app_dog_back.application.service;

import com.project.app_dog_back.application.dto.PerroDto;
import com.project.app_dog_back.application.mapper.IPerroMapper;
import com.project.app_dog_back.domain.model.entity.Perro;
import com.project.app_dog_back.domain.repository.IPerroRepository;
import com.project.app_dog_back.domain.service.*;
import com.project.app_dog_back.insfraestructure.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Locale;
import java.util.Objects;

@Service
public class IPerroServiceImpl implements IPerroService {

    private IPerroRepository iPerroRepository;
    private IRazaService iRazaService;
    private IMovilidadService iMovilidadService;
    private IColorPeloService iColorPeloService;
    private IAnimoService iAnimoService;
    private IIccService iIccService;
    private IUnidadMasaService iUnidadMasaService;
    private IClienteService iClienteService;
    private IMessageService iMessageService;

    @Autowired
    public IPerroServiceImpl(IPerroRepository iPerroRepository, IRazaService iRazaService, IMovilidadService iMovilidadService, IColorPeloService iColorPeloService, IAnimoService iAnimoService, IIccService iIccService, IUnidadMasaService iUnidadMasaService, IClienteService iClienteService, IMessageService iMessageService) {
        this.iPerroRepository = iPerroRepository;
        this.iRazaService = iRazaService;
        this.iMovilidadService = iMovilidadService;
        this.iColorPeloService = iColorPeloService;
        this.iAnimoService = iAnimoService;
        this.iIccService = iIccService;
        this.iUnidadMasaService = iUnidadMasaService;
        this.iClienteService = iClienteService;
        this.iMessageService = iMessageService;
    }

    @Override
    public PerroDto create(PerroDto perroDto) {
        Perro perro = IPerroMapper.INSTANCE.toEntity(perroDto);

        perro.setRaza(iRazaService.getById(perroDto.getIdRaza()));
        perro.setIcc(iIccService.getById(perroDto.getIdIcc()));
        perro.setMovilidad(iMovilidadService.getById(perroDto.getIdMovilidad()));
        perro.setColorPelo(iColorPeloService.getById(perroDto.getIdColorPelo()));
        perro.setAnimo(iAnimoService.getById(perroDto.getIdAnimo()));
        if (Objects.nonNull(perroDto.getIdUnidadMasa()))
            perro.setUnidadMasa(iUnidadMasaService.getById(perroDto.getIdUnidadMasa()));
        perro.setCliente(iClienteService.getClienteById(perroDto.getIdCliente()));

        return IPerroMapper.INSTANCE.toDto(iPerroRepository.save(perro));
    }

    @Override
    public PerroDto getById(Long id) {
        Locale locale = LocaleContextHolder.getLocale();
        String message = iMessageService.getMensaje("infor.not_found", locale);
        Perro entity = iPerroRepository.findById(id).orElseThrow(() -> new NotFoundException(message, String.valueOf(HttpStatus.NOT_FOUND.value()), HttpStatus.NOT_FOUND));
        return IPerroMapper.INSTANCE.toDto(entity);
    }

    @Override
    public Perro getPerroById(Long idPerro) {
        Locale locale = LocaleContextHolder.getLocale();
        String message = iMessageService.getMensaje("infor.not_found", locale);
        return iPerroRepository.findById(idPerro).orElseThrow(() -> new NotFoundException(message, String.valueOf(HttpStatus.NOT_FOUND.value()), HttpStatus.NOT_FOUND));
    }
}
