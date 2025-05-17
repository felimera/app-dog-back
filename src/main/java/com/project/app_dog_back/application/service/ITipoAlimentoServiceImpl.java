package com.project.app_dog_back.application.service;

import com.project.app_dog_back.application.dto.catalog.TipoAlimentoDto;
import com.project.app_dog_back.application.mapper.ITipoAlimentoMapper;
import com.project.app_dog_back.domain.model.catalog.TipoAlimento;
import com.project.app_dog_back.domain.repository.ITipoAlimentoRepository;
import com.project.app_dog_back.domain.service.IMessageService;
import com.project.app_dog_back.domain.service.ITipoAlimentoService;
import com.project.app_dog_back.insfraestructure.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;

@Service
public class ITipoAlimentoServiceImpl implements ITipoAlimentoService {

    private ITipoAlimentoRepository iTipoAlimentoRepository;
    private IMessageService iMessageService;

    @Autowired
    public ITipoAlimentoServiceImpl(ITipoAlimentoRepository iTipoAlimentoRepository, IMessageService iMessageService) {
        this.iTipoAlimentoRepository = iTipoAlimentoRepository;
        this.iMessageService = iMessageService;
    }

    @Override
    public List<TipoAlimentoDto> getAll() {
        return iTipoAlimentoRepository.findAll().stream().map(ITipoAlimentoMapper.INSTANCE::toDto).toList();
    }

    @Override
    public TipoAlimento getById(Long idTipoAlimento) {
        Locale locale = LocaleContextHolder.getLocale();
        String message = iMessageService.getMensaje("infor.not_found", locale);
        return iTipoAlimentoRepository.findById(idTipoAlimento)
                .orElseThrow(() -> new NotFoundException(message, String.valueOf(HttpStatus.NOT_FOUND.value()), HttpStatus.NOT_FOUND));
    }
}
