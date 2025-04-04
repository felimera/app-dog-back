package com.project.app_dog_back.insfraestructure.controller;

import com.project.app_dog_back.application.dto.ClienteDto;
import com.project.app_dog_back.application.response.Meta;
import com.project.app_dog_back.application.response.Pagination;
import com.project.app_dog_back.application.response.Response;
import com.project.app_dog_back.domain.model.component.TypesStatus;
import com.project.app_dog_back.domain.service.IClienteService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Cliente", description = "Operations related to the customer.")
@RestController
@RequestMapping(path = "/api/v1/cliente")
@Slf4j
@CrossOrigin(origins = "http://localhost:4200")
public class ClienteController {

    private IClienteService iClienteService;

    @Autowired
    public ClienteController(IClienteService iClienteService) {
        this.iClienteService = iClienteService;
    }

    @Operation(summary = "Create a customer registration.")
    @PostMapping
    public ResponseEntity<Response> create(@RequestBody ClienteDto dto) {
        Response response = new Response();
        response.setMeta(Meta.builder().build().toMetaBuilder(TypesStatus.SUCCESS.name()));
        response.setPagination(Pagination.builder().build().toPaginationBuilder());
        response.setData(iClienteService.create(dto));

        return ResponseEntity.ok(response);
    }

    @Operation(summary = "Get a record by id.")
    @GetMapping(path = "{id}")
    public ResponseEntity<Response> getById(@PathVariable(name = "id") Long id) {
        Response response = new Response();
        response.setMeta(Meta.builder().build().toMetaBuilder(TypesStatus.SUCCESS.name()));
        response.setPagination(Pagination.builder().build().toPaginationBuilder());
        response.setData(iClienteService.getById(id));

        return ResponseEntity.ok(response);
    }

    @Operation(summary = "Get all customer records.")
    @GetMapping
    public ResponseEntity<Response> geAll() {
        Response response = new Response();
        response.setMeta(Meta.builder().build().toMetaBuilder(TypesStatus.SUCCESS.name()));
        response.setPagination(Pagination.builder().build().toPaginationBuilder());
        response.setData(iClienteService.getAll());

        return ResponseEntity.ok(response);
    }
}
