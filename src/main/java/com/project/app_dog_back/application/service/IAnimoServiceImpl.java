package com.project.app_dog_back.application.service;

import com.project.app_dog_back.application.dto.catalog.AnimoDto;
import com.project.app_dog_back.application.mapper.IAnimoMapper;
import com.project.app_dog_back.domain.model.catalog.Animo;
import com.project.app_dog_back.domain.repository.IAnimoRepository;
import com.project.app_dog_back.domain.service.IAnimoService;
import com.project.app_dog_back.domain.service.IMessageService;
import com.project.app_dog_back.insfraestructure.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;

@Service
public class IAnimoServiceImpl implements IAnimoService {

    private IAnimoRepository iAnimoRepository;
    private IMessageService iMessageService;

    @Autowired
    public IAnimoServiceImpl(IAnimoRepository iAnimoRepository, IMessageService iMessageService) {
        this.iAnimoRepository = iAnimoRepository;
        this.iMessageService = iMessageService;
    }

    @Override
    public List<AnimoDto> getAll() {
        return iAnimoRepository.findAll().stream().map(IAnimoMapper.INSTANCE::toDto).toList();
    }

    @Override
    public Animo getById(Long idAnimo) {
        Locale locale = LocaleContextHolder.getLocale();
        String mensaje = iMessageService.getMensaje("infor.not_found", locale);
        return iAnimoRepository.findById(idAnimo)
                .orElseThrow(() -> new NotFoundException(mensaje, String.valueOf(HttpStatus.NOT_FOUND.value()), HttpStatus.NOT_FOUND));
    }
}
