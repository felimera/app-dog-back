package com.project.app_dog_back.insfraestructure.controller;

import com.project.app_dog_back.application.dto.DosisMedicamentoDto;
import com.project.app_dog_back.application.response.Meta;
import com.project.app_dog_back.application.response.Pagination;
import com.project.app_dog_back.application.response.Response;
import com.project.app_dog_back.domain.model.component.TypesStatus;
import com.project.app_dog_back.domain.service.IDosisMedicamentoService;
import com.project.app_dog_back.domain.service.IMetaService;
import com.project.app_dog_back.insfraestructure.exception.ResponseMessageException;
import com.project.app_dog_back.insfraestructure.utils.BuildErrorUtil;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Dosis del medicamento", description = "Operation related to medication dose.")
@RestController
@RequestMapping(path = "/api/v1/dosismedicamento")
@Slf4j
@CrossOrigin(origins = "http://localhost:4200")
public class DosisMedicamentoController {
    private IDosisMedicamentoService iDosisMedicamentoService;
    private IMetaService iMetaService;

    @Autowired
    public DosisMedicamentoController(IDosisMedicamentoService iDosisMedicamentoService, IMetaService iMetaService) {
        this.iDosisMedicamentoService = iDosisMedicamentoService;
        this.iMetaService = iMetaService;
    }

    @Operation(summary = "Create a record of medication doses.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Created successfully."),
            @ApiResponse(responseCode = "400", description = "Bad Request."),
            @ApiResponse(responseCode = "409", description = "Conflict in the creation of the registry.")
    })
    @PostMapping
    public ResponseEntity<Response> create(@Valid @RequestBody DosisMedicamentoDto dto, BindingResult bindingResult) {
        log.info("Creating Cliente: {}", dto);
        if (bindingResult.hasErrors())
            throw new ResponseMessageException("401-01", "Error creating store.", BuildErrorUtil.formatMessage(bindingResult), HttpStatus.BAD_REQUEST);

        Response response = new Response();
        Meta meta = iMetaService.buildMetaBody("infor.created", TypesStatus.CREATED.name());
        response.setMeta(meta);
        response.setPagination(Pagination.builder().build().toPaginationBuilder());
        response.setData(iDosisMedicamentoService.create(dto));

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @Operation(summary = "Get a record by id.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved"),
            @ApiResponse(responseCode = "404", description = "Not found - The record was not found.")
    })
    @GetMapping(path = "{id}")
    public ResponseEntity<Response> getById(@PathVariable(name = "id") Long id) {
        Response response = new Response();
        Meta meta = iMetaService.buildMetaBody("infor.query", TypesStatus.SUCCESS.name());
        response.setMeta(meta);
        response.setPagination(Pagination.builder().build().toPaginationBuilder());
        response.setData(iDosisMedicamentoService.getById(id));

        return ResponseEntity.ok(response);
    }

    @Operation(summary = "Obtain all records of medication doses.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved"),
            @ApiResponse(responseCode = "404", description = "Not found - The record was not found.")
    })
    @GetMapping
    public ResponseEntity<Response> getAll() {
        Response response = new Response();
        Meta meta = iMetaService.buildMetaBody("infor.queries", TypesStatus.SUCCESS.name());
        response.setMeta(meta);
        response.setPagination(Pagination.builder().build().toPaginationBuilder());
        response.setData(iDosisMedicamentoService.getAll());

        return ResponseEntity.ok(response);
    }
}
