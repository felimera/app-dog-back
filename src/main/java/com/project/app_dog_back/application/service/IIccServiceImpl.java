package com.project.app_dog_back.application.service;

import com.project.app_dog_back.application.dto.IccDto;
import com.project.app_dog_back.application.mapper.IIccMapper;
import com.project.app_dog_back.domain.model.catalog.Icc;
import com.project.app_dog_back.domain.repository.IIccRepository;
import com.project.app_dog_back.domain.service.IIccService;
import com.project.app_dog_back.domain.service.IMessageService;
import com.project.app_dog_back.insfraestructure.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;

@Service
public class IIccServiceImpl implements IIccService {

    private IIccRepository iIccRepository;
    private IMessageService iMessageService;

    @Autowired
    public IIccServiceImpl(IIccRepository iIccRepository, IMessageService iMessageService) {
        this.iIccRepository = iIccRepository;
        this.iMessageService = iMessageService;
    }

    @Override
    public List<IccDto> getAll() {
        return iIccRepository.findAll().stream().map(IIccMapper.INSTANCE::toDto).toList();
    }

    @Override
    public Icc getById(Long idIcc) {
        Locale locale = LocaleContextHolder.getLocale();
        String mensaje = iMessageService.getMensaje("war.repeated", locale);
        return iIccRepository.findById(idIcc)
                .orElseThrow(() -> new NotFoundException(mensaje, String.valueOf(HttpStatus.NOT_FOUND.value()), HttpStatus.NOT_FOUND));
    }
}
