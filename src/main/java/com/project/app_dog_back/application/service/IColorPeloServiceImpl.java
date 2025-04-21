package com.project.app_dog_back.application.service;

import com.project.app_dog_back.application.dto.catalog.ColorPeloDto;
import com.project.app_dog_back.application.mapper.IColorPeloMapper;
import com.project.app_dog_back.domain.model.catalog.ColorPelo;
import com.project.app_dog_back.domain.repository.IColorPeloRepository;
import com.project.app_dog_back.domain.service.IColorPeloService;
import com.project.app_dog_back.domain.service.IMessageService;
import com.project.app_dog_back.insfraestructure.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;

@Service
public class IColorPeloServiceImpl implements IColorPeloService {

    private IColorPeloRepository iColorPeloRepository;
    private IMessageService iMessageService;

    @Autowired
    public IColorPeloServiceImpl(IColorPeloRepository iColorPeloRepository, IMessageService iMessageService) {
        this.iColorPeloRepository = iColorPeloRepository;
        this.iMessageService = iMessageService;
    }

    @Override
    public List<ColorPeloDto> getAll() {
        return iColorPeloRepository.findAll().stream().map(IColorPeloMapper.INSTANCE::toDto).toList();
    }

    @Override
    public ColorPelo getById(Long idColorPelo) {
        Locale locale = LocaleContextHolder.getLocale();
        String mensaje = iMessageService.getMensaje("infor.not_found", locale);
        return iColorPeloRepository.findById(idColorPelo)
                .orElseThrow(() -> new NotFoundException(mensaje, String.valueOf(HttpStatus.NOT_FOUND.value()), HttpStatus.NOT_FOUND));
    }
}
