package com.project.app_dog_back.application.service;

import com.project.app_dog_back.application.dto.AlimentoDto;
import com.project.app_dog_back.application.mapper.IAlimentoMapper;
import com.project.app_dog_back.application.response.error.KeyValueError;
import com.project.app_dog_back.domain.model.entity.Alimento;
import com.project.app_dog_back.domain.repository.IAlimentoRepository;
import com.project.app_dog_back.domain.service.IAlimentoService;
import com.project.app_dog_back.domain.service.IMessageService;
import com.project.app_dog_back.domain.service.ITipoAlimentoService;
import com.project.app_dog_back.insfraestructure.exception.ConflictException;
import com.project.app_dog_back.insfraestructure.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Locale;

@Service
public class IAlimentoServiceImpl implements IAlimentoService {

    private IAlimentoRepository iAlimentoRepository;
    private IMessageService iMessageService;
    private ITipoAlimentoService iTipoAlimentoService;

    @Autowired
    public IAlimentoServiceImpl(IAlimentoRepository iAlimentoRepository, IMessageService iMessageService, ITipoAlimentoService iTipoAlimentoService) {
        this.iAlimentoRepository = iAlimentoRepository;
        this.iMessageService = iMessageService;
        this.iTipoAlimentoService = iTipoAlimentoService;
    }

    @Override
    public List<AlimentoDto> getAll() {
        return iAlimentoRepository.findAll().stream().map(IAlimentoMapper.INSTANCE::toDto).toList();
    }

    @Override
    public AlimentoDto getById(Long idAlimento) {
        Locale locale = LocaleContextHolder.getLocale();
        String message = iMessageService.getMensaje("infor.not_found", locale);
        Alimento entity = iAlimentoRepository.findById(idAlimento).orElseThrow(() -> new NotFoundException(message, String.valueOf(HttpStatus.NOT_FOUND.value()), HttpStatus.NOT_FOUND));
        return IAlimentoMapper.INSTANCE.toDto(entity);
    }

    @Override
    public Alimento getAlimentoById(Long idAlimento) {
        Locale locale = LocaleContextHolder.getLocale();
        String message = iMessageService.getMensaje("infor.not_found", locale);
        return iAlimentoRepository.findById(idAlimento).orElseThrow(() -> new NotFoundException(message, String.valueOf(HttpStatus.NOT_FOUND.value()), HttpStatus.NOT_FOUND));
    }

    @Override
    public AlimentoDto create(AlimentoDto dto) {
        if (iAlimentoRepository.getMatchOnNombre(dto.getNombre()) > 0) {
            String message = iMessageService.getMessage("war.repeated");
            List<KeyValueError> conflictingFields = Collections.singletonList(KeyValueError.builder().attributeName("nombre").attributeValue(message).build());
            throw new ConflictException(message, String.valueOf(HttpStatus.CONFLICT.value()), HttpStatus.CONFLICT, conflictingFields);
        }
        Alimento alimento = IAlimentoMapper.INSTANCE.toEntity(dto);
        alimento.setTipoAlimento(iTipoAlimentoService.getById(dto.getIdTipoAlimento()));
        return IAlimentoMapper.INSTANCE.toDto(iAlimentoRepository.save(alimento));
    }
}
