package com.project.app_dog_back.application.service;

import com.project.app_dog_back.application.dto.NotificacionDto;
import com.project.app_dog_back.application.mapper.INotificacionMapper;
import com.project.app_dog_back.domain.model.entity.Notificacion;
import com.project.app_dog_back.domain.repository.INotificacionRepository;
import com.project.app_dog_back.domain.service.*;
import com.project.app_dog_back.insfraestructure.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;
import java.util.Objects;

@Service
public class INotificacionServiceImpl implements INotificacionService {
    private INotificacionRepository iNotificacionRepository;
    private IMessageService iMessageService;
    private ISalidaService iSalidaService;
    private ISuministroAlimentoService iSuministroAlimentoService;
    private IDosisMedicamentoService iDosisMedicamentoService;
    private IMascotaService iMascotaService;

    @Autowired
    public INotificacionServiceImpl(INotificacionRepository iNotificacionRepository, IMessageService iMessageService, ISalidaService iSalidaService, ISuministroAlimentoService iSuministroAlimentoService, IDosisMedicamentoService iDosisMedicamentoService, IMascotaService iMascotaService) {
        this.iNotificacionRepository = iNotificacionRepository;
        this.iMessageService = iMessageService;
        this.iSalidaService = iSalidaService;
        this.iSuministroAlimentoService = iSuministroAlimentoService;
        this.iDosisMedicamentoService = iDosisMedicamentoService;
        this.iMascotaService = iMascotaService;
    }

    @Override
    public NotificacionDto create(NotificacionDto dto) {
        Notificacion entity = INotificacionMapper.INSTANCE.toEntity(dto);

        if (Objects.nonNull(dto.getIdSalida()))
            entity.setSalida(iSalidaService.getSalidaById(dto.getIdSalida()));
        if (Objects.nonNull(dto.getIdSuministroAlimento()))
            entity.setSuministroAlimento(iSuministroAlimentoService.getSuministraAlimentoById(dto.getIdSuministroAlimento()));
        if (Objects.nonNull(dto.getIdDosisMedicamento()))
            entity.setDosisMedicamento(iDosisMedicamentoService.getDosisMedicamento(dto.getIdDosisMedicamento()));
        if (Objects.nonNull(dto.getIdMascota()))
            entity.setMascota(iMascotaService.getMascotaById(dto.getIdMascota()));

        return INotificacionMapper.INSTANCE.toDto(iNotificacionRepository.save(entity));
    }

    @Override
    public NotificacionDto getById(Long id) {
        Locale locale = LocaleContextHolder.getLocale();
        String message = iMessageService.getMensaje("infor.not_found", locale);
        Notificacion entity = iNotificacionRepository.findById(id).orElseThrow(() -> new NotFoundException(message, String.valueOf(HttpStatus.NOT_FOUND.value()), HttpStatus.NOT_FOUND));
        return INotificacionMapper.INSTANCE.toDto(entity);
    }

    @Override
    public List<NotificacionDto> getAll() {
        return iNotificacionRepository.findAll().stream().map(INotificacionMapper.INSTANCE::toDto).toList();
    }
}
