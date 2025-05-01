package com.project.app_dog_back.application.service;

import com.project.app_dog_back.application.dto.ClienteDto;
import com.project.app_dog_back.application.mapper.IClienteMapper;
import com.project.app_dog_back.application.response.error.KeyValueError;
import com.project.app_dog_back.domain.model.entity.Cliente;
import com.project.app_dog_back.domain.repository.IClienteRepository;
import com.project.app_dog_back.domain.service.IClienteService;
import com.project.app_dog_back.domain.service.IMessageService;
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
public class IClienteServiceImpl implements IClienteService {

    private IClienteRepository iClienteRepository;
    private IMessageService iMessageService;

    @Autowired
    public IClienteServiceImpl(IClienteRepository iClienteRepository, IMessageService iMessageService) {
        this.iClienteRepository = iClienteRepository;
        this.iMessageService = iMessageService;
    }

    @Override
    public List<ClienteDto> getAll() {
        return iClienteRepository.findAll().stream().map(IClienteMapper.INSTANCE::toDto).toList();
    }

    @Override
    public ClienteDto getById(Long idCliente) {
        Locale locale = LocaleContextHolder.getLocale();
        String message = iMessageService.getMensaje("infor.not_found", locale);
        Cliente entity = iClienteRepository.findById(idCliente).orElseThrow(() -> new NotFoundException(message, String.valueOf(HttpStatus.NOT_FOUND.value()), HttpStatus.NOT_FOUND));
        return IClienteMapper.INSTANCE.toDto(entity);
    }

    @Override
    public Cliente getClienteById(Long idCliente) {
        Locale locale = LocaleContextHolder.getLocale();
        String message = iMessageService.getMensaje("infor.not_found", locale);
        return iClienteRepository.findById(idCliente).orElseThrow(() -> new NotFoundException(message, String.valueOf(HttpStatus.NOT_FOUND.value()), HttpStatus.NOT_FOUND));
    }

    @Override
    public ClienteDto create(ClienteDto dto) {
        if (iClienteRepository.getMatchOnEmail(dto.getEmail()) > 0) {
            Locale locale = LocaleContextHolder.getLocale();
            String message = iMessageService.getMensaje("war.repeated", locale);
            List<KeyValueError> conflictingFields = Collections.singletonList(KeyValueError.builder().attributeName("email").attributeValue(message).build());
            throw new ConflictException(message, String.valueOf(HttpStatus.CONFLICT.value()), HttpStatus.CONFLICT, conflictingFields);
        }

        Cliente cliente = IClienteMapper.INSTANCE.toEntity(dto);

        return IClienteMapper.INSTANCE.toDto(iClienteRepository.save(cliente));
    }
}
