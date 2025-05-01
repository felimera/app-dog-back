package com.project.app_dog_back.insfraestructure.controller;

import com.project.app_dog_back.application.dto.ClienteDto;
import com.project.app_dog_back.application.response.Meta;
import com.project.app_dog_back.application.response.Pagination;
import com.project.app_dog_back.application.response.Response;
import com.project.app_dog_back.application.response.error.ResponseErrorAttribute;
import com.project.app_dog_back.application.response.error.ResponseErrorGeneral;
import com.project.app_dog_back.domain.model.component.TypesStatus;
import com.project.app_dog_back.domain.service.IClienteService;
import com.project.app_dog_back.domain.service.IMetaService;
import com.project.app_dog_back.insfraestructure.exception.ResponseMessageException;
import com.project.app_dog_back.insfraestructure.utils.BuildErrorUtil;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
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

@Tag(name = "Cliente", description = "Operations related to the customer.")
@RestController
@RequestMapping(path = "/api/v1/cliente")
@Slf4j
@CrossOrigin(origins = "http://localhost:4200")
public class ClienteController {

    private IClienteService iClienteService;
    private IMetaService iMetaService;

    @Autowired
    public ClienteController(IClienteService iClienteService, IMetaService iMetaService) {
        this.iClienteService = iClienteService;
        this.iMetaService = iMetaService;
    }

    @Operation(summary = "Create a customer registration.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Created successfully."),
            @ApiResponse(
                    responseCode = "400",
                    description = "Bad Request.",
                    content = {
                            @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = ResponseErrorAttribute.class)
                            )}),
            @ApiResponse(
                    responseCode = "409",
                    description = "Conflict in the creation of the registry.",
                    content = {
                            @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = ResponseErrorAttribute.class)
                            )})
    })
    @PostMapping
    public ResponseEntity<Response> create(@Valid @RequestBody ClienteDto dto, BindingResult bindingResult) {
        log.info("Creating Cliente: {}", dto);
        if (bindingResult.hasErrors())
            throw new ResponseMessageException("401-01", "Error creating store.", BuildErrorUtil.formatMessage(bindingResult), HttpStatus.BAD_REQUEST);
        Response response = new Response();
        Meta meta = iMetaService.buildMetaBody("infor.created", TypesStatus.CREATED.name());
        response.setMeta(meta);
        response.setPagination(Pagination.builder().build().toPaginationBuilder());
        response.setData(iClienteService.create(dto));

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @Operation(summary = "Get a record by id.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved"),
            @ApiResponse(
                    responseCode = "404",
                    description = "Not found - The record was not found.",
                    content = {
                            @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = ResponseErrorGeneral.class)
                            )})
    })
    @GetMapping(path = "{id}")
    public ResponseEntity<Response> getById(
            @Parameter(name = "id", in = ParameterIn.PATH, description = "ID de la salida a obtener.", required = true)
            @PathVariable(name = "id") Long id) {
        Response response = new Response();
        Meta meta = iMetaService.buildMetaBody("infor.query", TypesStatus.SUCCESS.name());
        response.setMeta(meta);
        response.setPagination(Pagination.builder().build().toPaginationBuilder());
        response.setData(iClienteService.getById(id));

        return ResponseEntity.ok(response);
    }

    @Operation(summary = "Get all customer records.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved"),
            @ApiResponse(
                    responseCode = "404",
                    description = "Not found - The record was not found.",
                    content = {
                            @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = ResponseErrorGeneral.class)
                            )})
    })
    @GetMapping
    public ResponseEntity<Response> geAll() {
        Response response = new Response();
        Meta meta = iMetaService.buildMetaBody("infor.queries", TypesStatus.SUCCESS.name());
        response.setMeta(meta);
        response.setPagination(Pagination.builder().build().toPaginationBuilder());
        response.setData(iClienteService.getAll());

        return ResponseEntity.ok(response);
    }
}
