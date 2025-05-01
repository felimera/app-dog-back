package com.project.app_dog_back.application.service;

import com.project.app_dog_back.application.dto.catalog.UnidadMasaDto;
import com.project.app_dog_back.application.mapper.IUnidadMasaMapper;
import com.project.app_dog_back.domain.model.catalog.UnidadMasa;
import com.project.app_dog_back.domain.repository.IUnidadMasaRepository;
import com.project.app_dog_back.domain.service.IMessageService;
import com.project.app_dog_back.domain.service.IUnidadMasaService;
import com.project.app_dog_back.insfraestructure.exception.NotFoundException;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;

@Service
public class IUnidadMasaServiceImpl implements IUnidadMasaService {
    private IUnidadMasaRepository iUnidadMasaRepository;
    private IMessageService iMessageService;

    public IUnidadMasaServiceImpl(IUnidadMasaRepository iUnidadMasaRepository, IMessageService iMessageService) {
        this.iUnidadMasaRepository = iUnidadMasaRepository;
        this.iMessageService = iMessageService;
    }

    @Override
    public List<UnidadMasaDto> getAll() {
        return iUnidadMasaRepository.findAll().stream().map(IUnidadMasaMapper.INSTANCE::toDto).toList();
    }

    @Override
    public UnidadMasa getById(Long idUnidadMasa) {
        Locale locale = LocaleContextHolder.getLocale();
        String mensaje = iMessageService.getMensaje("infor.not_found", locale);
        return iUnidadMasaRepository.findById(idUnidadMasa)
                .orElseThrow(() -> new NotFoundException(mensaje, String.valueOf(HttpStatus.NOT_FOUND.value()), HttpStatus.NOT_FOUND));
    }
}
