package com.project.app_dog_back.application.service;

import com.project.app_dog_back.application.dto.catalog.RazaDto;
import com.project.app_dog_back.application.mapper.IRazaMapper;
import com.project.app_dog_back.domain.model.catalog.Raza;
import com.project.app_dog_back.domain.repository.IRazaRepository;
import com.project.app_dog_back.domain.service.IMessageService;
import com.project.app_dog_back.domain.service.IRazaService;
import com.project.app_dog_back.insfraestructure.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;

@Service
public class IRazaServiceImpl implements IRazaService {
    private IRazaRepository iRazaRepository;
    private IMessageService iMessageService;

    @Autowired
    public IRazaServiceImpl(IRazaRepository iRazaRepository, IMessageService iMessageService) {
        this.iRazaRepository = iRazaRepository;
        this.iMessageService = iMessageService;
    }

    @Override
    public List<RazaDto> getAll() {
        return iRazaRepository.findAll().stream().map(IRazaMapper.INSTANCE::toDto).toList();
    }

    @Override
    public Raza getById(Long idRaza) {
        Locale locale = LocaleContextHolder.getLocale();
        String mensaje = iMessageService.getMensaje("infor.not_found", locale);
        return iRazaRepository.findById(idRaza)
                .orElseThrow(() -> new NotFoundException(mensaje, String.valueOf(HttpStatus.NOT_FOUND.value()), HttpStatus.NOT_FOUND));
    }
}
