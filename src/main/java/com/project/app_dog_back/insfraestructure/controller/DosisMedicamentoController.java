package com.project.app_dog_back.insfraestructure.controller;

import com.project.app_dog_back.application.dto.DosisMedicamentoDto;
import com.project.app_dog_back.application.response.Meta;
import com.project.app_dog_back.application.response.Pagination;
import com.project.app_dog_back.application.response.Response;
import com.project.app_dog_back.domain.model.component.TypesStatus;
import com.project.app_dog_back.domain.service.IDosisMedicamentoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Dosis del medicamento", description = "Operation related to medication dose.")
@RestController
@RequestMapping(path = "/api/v1/dosismedicamento")
@Slf4j
@CrossOrigin(origins = "http://localhost:4200")
public class DosisMedicamentoController {
    private IDosisMedicamentoService iDosisMedicamentoService;

    @Autowired
    public DosisMedicamentoController(IDosisMedicamentoService iDosisMedicamentoService) {
        this.iDosisMedicamentoService = iDosisMedicamentoService;
    }

    @Operation(summary = "Create a record of medication doses.")
    @PostMapping
    public ResponseEntity<Response> create(@RequestBody DosisMedicamentoDto dto) {
        Response response = new Response();
        response.setMeta(Meta.builder().build().toMetaBuilder(TypesStatus.SUCCESS.name()));
        response.setPagination(Pagination.builder().build().toPaginationBuilder());
        response.setData(iDosisMedicamentoService.create(dto));

        return ResponseEntity.ok(response);
    }

    @Operation(summary = "Get a record by id.")
    @GetMapping(path = "{id}")
    public ResponseEntity<Response> getById(@PathVariable(name = "id") Long id) {
        Response response = new Response();
        response.setMeta(Meta.builder().build().toMetaBuilder(TypesStatus.SUCCESS.name()));
        response.setPagination(Pagination.builder().build().toPaginationBuilder());
        response.setData(iDosisMedicamentoService.getById(id));

        return ResponseEntity.ok(response);
    }

    @Operation(summary = "Obtain all records of medication doses.")
    @GetMapping
    public ResponseEntity<Response> getAll() {
        Response response = new Response();
        response.setMeta(Meta.builder().build().toMetaBuilder(TypesStatus.SUCCESS.name()));
        response.setPagination(Pagination.builder().build().toPaginationBuilder());
        response.setData(iDosisMedicamentoService.getAll());

        return ResponseEntity.ok(response);
    }
}
