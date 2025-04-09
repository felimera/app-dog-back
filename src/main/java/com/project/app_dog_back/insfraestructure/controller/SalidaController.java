package com.project.app_dog_back.insfraestructure.controller;

import com.project.app_dog_back.application.dto.SalidaDto;
import com.project.app_dog_back.application.response.Meta;
import com.project.app_dog_back.application.response.Pagination;
import com.project.app_dog_back.application.response.Response;
import com.project.app_dog_back.domain.model.component.TypesStatus;
import com.project.app_dog_back.domain.service.ISalidaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Salida", description = "Operations related to dog outings.")
@RestController
@RequestMapping(path = "/api/v1/salida")
@Slf4j
@CrossOrigin(origins = "http://localhost:4200")
public class SalidaController {
    private ISalidaService iSalidaService;

    @Autowired
    public SalidaController(ISalidaService iSalidaService) {
        this.iSalidaService = iSalidaService;
    }

    @Operation(summary = "Create an exit record.")
    @PostMapping
    public ResponseEntity<Response> create(@RequestBody SalidaDto dto) {
        Response response = new Response();
        response.setMeta(Meta.builder().build().toMetaBuilder(TypesStatus.SUCCESS.name()));
        response.setPagination(Pagination.builder().build().toPaginationBuilder());
        response.setData(iSalidaService.create(dto));

        return ResponseEntity.ok(response);
    }

    @Operation(summary = "Get a record by id.")
    @GetMapping(path = "{id}")
    public ResponseEntity<Response> getById(@PathVariable(name = "id") Long id) {
        Response response = new Response();
        response.setMeta(Meta.builder().build().toMetaBuilder(TypesStatus.SUCCESS.name()));
        response.setPagination(Pagination.builder().build().toPaginationBuilder());
        response.setData(iSalidaService.getById(id));

        return ResponseEntity.ok(response);
    }

    @Operation(summary = "Obtain all records of the dog's outings.")
    @GetMapping
    public ResponseEntity<Response> getAll() {
        Response response = new Response();
        response.setMeta(Meta.builder().build().toMetaBuilder(TypesStatus.SUCCESS.name()));
        response.setPagination(Pagination.builder().build().toPaginationBuilder());
        response.setData(iSalidaService.getAll());

        return ResponseEntity.ok(response);
    }
}
