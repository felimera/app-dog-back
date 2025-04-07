package com.project.app_dog_back.application.service;

import com.project.app_dog_back.application.dto.ViaAdministracionDto;
import com.project.app_dog_back.application.mapper.IViaAdministracionMapper;
import com.project.app_dog_back.domain.model.catalog.ViaAdministracion;
import com.project.app_dog_back.domain.repository.IViaAdministracionRepository;
import com.project.app_dog_back.domain.service.IMessageService;
import com.project.app_dog_back.domain.service.IViaAdministracionService;
import com.project.app_dog_back.insfraestructure.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;

@Service
public class IViaAdministracionServiceImpl implements IViaAdministracionService {
    private IViaAdministracionRepository iViaAdministracionRepository;
    private IMessageService iMessageService;

    @Autowired
    public IViaAdministracionServiceImpl(IViaAdministracionRepository iViaAdministracionRepository, IMessageService iMessageService) {
        this.iViaAdministracionRepository = iViaAdministracionRepository;
        this.iMessageService = iMessageService;
    }

    @Override
    public List<ViaAdministracionDto> getAll() {
        return iViaAdministracionRepository.findAll().stream().map(IViaAdministracionMapper.INSTANCE::toDto).toList();
    }

    @Override
    public ViaAdministracion getById(Long idViaAdministracion) {
        Locale locale = LocaleContextHolder.getLocale();
        String mensaje = iMessageService.getMensaje("infor.not_found", locale);
        return iViaAdministracionRepository.findById(idViaAdministracion)
                .orElseThrow(() -> new NotFoundException(mensaje, String.valueOf(HttpStatus.NOT_FOUND.value()), HttpStatus.NOT_FOUND));
    }
}
