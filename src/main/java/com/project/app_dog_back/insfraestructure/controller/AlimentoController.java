package com.project.app_dog_back.insfraestructure.controller;

import com.project.app_dog_back.application.dto.AlimentoDto;
import com.project.app_dog_back.application.response.AlimentoManageResponse;
import com.project.app_dog_back.application.response.AlimentoQueryResponse;
import com.project.app_dog_back.application.response.Meta;
import com.project.app_dog_back.application.response.Pagination;
import com.project.app_dog_back.domain.model.component.TypesStatus;
import com.project.app_dog_back.domain.service.IAlimentoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

    @Operation(summary = "Create a dog food log.", description = "Returns the created record.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Created successfully.")
    })
    @PostMapping
    public ResponseEntity<AlimentoManageResponse> create(@RequestBody AlimentoDto dto) {
        AlimentoManageResponse response = new AlimentoManageResponse();
        response.setStatus(TypesStatus.CREATED.name());
        response.setMessage("Record created successfully.");
        response.setData(iAlimentoService.create(dto));

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @Operation(summary = "Get a record by id.", description = "Returns a record by its ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved"),
            @ApiResponse(responseCode = "404", description = "Not found - The record was not found.")
    })
    @GetMapping(path = "{id}")
    public ResponseEntity<AlimentoQueryResponse> getById(@PathVariable(name = "id") Long id) {
        AlimentoQueryResponse response = new AlimentoQueryResponse();
        response.setMeta(Meta.builder().build().toMetaBuilder(TypesStatus.SUCCESS.name()));
        response.setPagination(Pagination.builder().build().toPaginationBuilder());
        response.setData(iAlimentoService.getById(id));

        return ResponseEntity.ok(response);
    }

    @Operation(summary = "Get all the food records.", description = "Returns a list of records.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved"),
            @ApiResponse(responseCode = "404", description = "Not found - The record was not found.")
    })
    @GetMapping
    public ResponseEntity<AlimentoQueryResponse> getAll() {
        AlimentoQueryResponse response = new AlimentoQueryResponse();
        response.setMeta(Meta.builder().build().toMetaBuilder(TypesStatus.SUCCESS.name()));
        response.setPagination(Pagination.builder().build().toPaginationBuilder());
        response.setData(iAlimentoService.getAll());

        return ResponseEntity.ok(response);
    }
}
