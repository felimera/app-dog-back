package com.project.app_dog_back.application.service;

import com.project.app_dog_back.application.dto.MascotaDto;
import com.project.app_dog_back.application.mapper.IMascotaMapper;
import com.project.app_dog_back.domain.model.entity.Mascota;
import com.project.app_dog_back.domain.repository.IMascotaRepository;
import com.project.app_dog_back.domain.service.*;
import com.project.app_dog_back.insfraestructure.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;

@Service
public class IMascotaServiceImpl implements IMascotaService {

    private IMascotaRepository iMascotaRepository;
    private IRazaService iRazaService;
    private IColorPeloService iColorPeloService;
    private IClienteService iClienteService;
    private IMessageService iMessageService;

    @Autowired
    public IMascotaServiceImpl(IMascotaRepository iMascotaRepository, IRazaService iRazaService, IColorPeloService iColorPeloService, IClienteService iClienteService, IMessageService iMessageService) {
        this.iMascotaRepository = iMascotaRepository;
        this.iRazaService = iRazaService;
        this.iColorPeloService = iColorPeloService;
        this.iClienteService = iClienteService;
        this.iMessageService = iMessageService;
    }

    @Override
    public MascotaDto create(MascotaDto mascotaDto) {
        Mascota mascota = IMascotaMapper.INSTANCE.toEntity(mascotaDto);

        mascota.setRaza(iRazaService.getById(mascotaDto.getIdRaza()));
        mascota.setColorPelo(iColorPeloService.getById(mascotaDto.getIdColorPelo()));
        mascota.setCliente(iClienteService.getClienteById(mascotaDto.getIdCliente()));

        return IMascotaMapper.INSTANCE.toDto(iMascotaRepository.save(mascota));
    }

    @Override
    public MascotaDto getById(Long id) {
        Locale locale = LocaleContextHolder.getLocale();
        String message = iMessageService.getMensaje("infor.not_found", locale);
        Mascota entity = iMascotaRepository.findById(id).orElseThrow(() -> new NotFoundException(message, String.valueOf(HttpStatus.NOT_FOUND.value()), HttpStatus.NOT_FOUND));
        return IMascotaMapper.INSTANCE.toDto(entity);
    }

    @Override
    public Mascota getMascotaById(Long idMascota) {
        Locale locale = LocaleContextHolder.getLocale();
        String message = iMessageService.getMensaje("infor.not_found", locale);
        return iMascotaRepository.findById(idMascota).orElseThrow(() -> new NotFoundException(message, String.valueOf(HttpStatus.NOT_FOUND.value()), HttpStatus.NOT_FOUND));
    }

    @Override
    public List<MascotaDto> getAll() {
        return iMascotaRepository.findAll().stream().map(IMascotaMapper.INSTANCE::toDto).toList();
    }
}
