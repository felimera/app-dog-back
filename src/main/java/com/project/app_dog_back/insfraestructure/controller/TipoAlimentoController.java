package com.project.app_dog_back.insfraestructure.controller;

import com.project.app_dog_back.application.response.Meta;
import com.project.app_dog_back.application.response.Pagination;
import com.project.app_dog_back.application.response.Response;
import com.project.app_dog_back.domain.model.component.TypesStatus;
import com.project.app_dog_back.domain.service.ITipoAlimentoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Tipo alimento", description = "Operation related to types of dog food.")
@RestController
@RequestMapping(path = "/api/v1/tipoalimento")
@Slf4j
@CrossOrigin(origins = "http://localhost:4200")
public class TipoAlimentoController {

    private ITipoAlimentoService iTipoAlimentoService;

    @Autowired
    public TipoAlimentoController(ITipoAlimentoService iTipoAlimentoService) {
        this.iTipoAlimentoService = iTipoAlimentoService;
    }

    @Operation(summary = "Get all types of dog food.")
    @GetMapping
    public ResponseEntity<Response> getAll() {
        Response response = new Response();
        response.setMeta(Meta.builder().build().toMetaBuilder(TypesStatus.SUCCESS.name()));
        response.setPagination(Pagination.builder().build().toPaginationBuilder());
        response.setData(iTipoAlimentoService.getAll());

        return ResponseEntity.ok(response);
    }
}
