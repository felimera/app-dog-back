package com.project.app_dog_back.application.service;

import com.project.app_dog_back.application.dto.MovilidadDto;
import com.project.app_dog_back.application.mapper.IMovilidadMapper;
import com.project.app_dog_back.domain.model.catalog.Movilidad;
import com.project.app_dog_back.domain.repository.IMovilidadRepository;
import com.project.app_dog_back.domain.service.IMessageService;
import com.project.app_dog_back.domain.service.IMovilidadService;
import com.project.app_dog_back.insfraestructure.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;

@Service
public class IMovilidadServiceImpl implements IMovilidadService {
    private IMovilidadRepository iMovilidadRepository;
    private IMessageService iMessageService;

    @Autowired
    public IMovilidadServiceImpl(IMovilidadRepository iMovilidadRepository, IMessageService iMessageService) {
        this.iMovilidadRepository = iMovilidadRepository;
        this.iMessageService = iMessageService;
    }

    @Override
    public List<MovilidadDto> getAll() {
        return iMovilidadRepository.findAll().stream().map(IMovilidadMapper.INSTANCE::toDto).toList();
    }

    @Override
    public Movilidad getById(Long idMovlidad) {
        Locale locale = LocaleContextHolder.getLocale();
        String mensaje = iMessageService.getMensaje("infor.not_found", locale);
        return iMovilidadRepository.findById(idMovlidad)
                .orElseThrow(() -> new NotFoundException(mensaje, String.valueOf(HttpStatus.NOT_FOUND.value()), HttpStatus.NOT_FOUND));
    }
}
