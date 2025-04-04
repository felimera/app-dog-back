package com.project.app_dog_back.insfraestructure.controller;

import com.project.app_dog_back.application.dto.AlimentoDto;
import com.project.app_dog_back.application.response.Meta;
import com.project.app_dog_back.application.response.Pagination;
import com.project.app_dog_back.application.response.Response;
import com.project.app_dog_back.domain.model.component.TypesStatus;
import com.project.app_dog_back.domain.service.IAlimentoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Alimento", description = "Operations related to dog food.")
@RestController
@RequestMapping(path = "/api/v1/alimento")
@Slf4j
@CrossOrigin(origins = "http://localhost:4200")
public class AlimentoController {

    private IAlimentoService iAlimentoService;

    @Autowired
    public AlimentoController(IAlimentoService iAlimentoService) {
        this.iAlimentoService = iAlimentoService;
    }

    @Operation(summary = "Create a dog food log.")
    @PostMapping
    public ResponseEntity<Response> create(@RequestBody AlimentoDto dto) {
        Response response = new Response();
        response.setMeta(Meta.builder().build().toMetaBuilder(TypesStatus.SUCCESS.name()));
        response.setPagination(Pagination.builder().build().toPaginationBuilder());
        response.setData(iAlimentoService.create(dto));

        return ResponseEntity.ok(response);
    }

    @Operation(summary = "Get a record by id.")
    @GetMapping(path = "{id}")
    public ResponseEntity<Response> getById(@PathVariable(name = "id") Long id) {
        Response response = new Response();
        response.setMeta(Meta.builder().build().toMetaBuilder(TypesStatus.SUCCESS.name()));
        response.setPagination(Pagination.builder().build().toPaginationBuilder());
        response.setData(iAlimentoService.getById(id));

        return ResponseEntity.ok(response);
    }

    @Operation(summary = "Get all the food records.")
    @GetMapping
    public ResponseEntity<Response> getAll() {
        Response response = new Response();
        response.setMeta(Meta.builder().build().toMetaBuilder(TypesStatus.SUCCESS.name()));
        response.setPagination(Pagination.builder().build().toPaginationBuilder());
        response.setData(iAlimentoService.getAll());

        return ResponseEntity.ok(response);
    }
}
