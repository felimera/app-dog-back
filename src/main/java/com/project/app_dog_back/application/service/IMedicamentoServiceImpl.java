package com.project.app_dog_back.application.service;

import com.project.app_dog_back.application.dto.MedicamentoDto;
import com.project.app_dog_back.application.mapper.IMedicamentoMapper;
import com.project.app_dog_back.domain.model.entity.Medicamento;
import com.project.app_dog_back.domain.repository.IMedicamentoRepository;
import com.project.app_dog_back.domain.service.IMedicamentoService;
import com.project.app_dog_back.domain.service.IMessageService;
import com.project.app_dog_back.domain.service.IViaAdministracionService;
import com.project.app_dog_back.insfraestructure.exception.ConflictException;
import com.project.app_dog_back.insfraestructure.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;
import java.util.Objects;

@Service
public class IMedicamentoServiceImpl implements IMedicamentoService {
    private IMedicamentoRepository iMedicamentoRepository;
    private IMessageService iMessageService;
    private IViaAdministracionService iViaAdministracionService;

    @Autowired
    public IMedicamentoServiceImpl(IMedicamentoRepository iMedicamentoRepository, IMessageService iMessageService, IViaAdministracionService iViaAdministracionService) {
        this.iMedicamentoRepository = iMedicamentoRepository;
        this.iMessageService = iMessageService;
        this.iViaAdministracionService = iViaAdministracionService;
    }

    @Override
    public MedicamentoDto getById(Long id) {
        Locale locale = LocaleContextHolder.getLocale();
        String message = iMessageService.getMensaje("infor.not_found", locale);
        Medicamento entity = iMedicamentoRepository.findById(id).orElseThrow(() -> new NotFoundException(message, String.valueOf(HttpStatus.NOT_FOUND.value()), HttpStatus.NOT_FOUND));
        return IMedicamentoMapper.INSTANCE.toDto(entity);
    }

    @Override
    public List<MedicamentoDto> getAll() {
        return iMedicamentoRepository.findAll().stream().map(IMedicamentoMapper.INSTANCE::toDto).toList();
    }

    @Override
    public MedicamentoDto create(MedicamentoDto dto) {
        if (iMedicamentoRepository.getMatchOnName(dto.getNombre()) > 0) {
            Locale locale = LocaleContextHolder.getLocale();
            String message = iMessageService.getMensaje("war.repeated", locale);
            throw new ConflictException(message, String.valueOf(HttpStatus.CONFLICT.value()), HttpStatus.CONFLICT);
        }

        Medicamento entity = IMedicamentoMapper.INSTANCE.toEntity(dto);
        if (Objects.nonNull(dto.getIdViaAdministracion()))
            entity.setViaAdministracion(iViaAdministracionService.getById(dto.getIdViaAdministracion()));

        return IMedicamentoMapper.INSTANCE.toDto(iMedicamentoRepository.save(entity));
    }
}
