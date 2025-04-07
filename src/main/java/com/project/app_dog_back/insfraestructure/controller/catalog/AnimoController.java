package com.project.app_dog_back.insfraestructure.controller.catalog;

import com.project.app_dog_back.application.response.Meta;
import com.project.app_dog_back.application.response.Pagination;
import com.project.app_dog_back.application.response.Response;
import com.project.app_dog_back.domain.model.component.TypesStatus;
import com.project.app_dog_back.domain.service.IAnimoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Animo", description = "Operations related to the spirit.")
@RestController
@RequestMapping(path = "/api/v1/animo")
@Slf4j
@CrossOrigin(origins = "http://localhost:4200")
public class AnimoController {

    private IAnimoService iAnimoService;

    @Autowired
    public AnimoController(IAnimoService iAnimoService) {
        this.iAnimoService = iAnimoService;
    }

    @Operation(summary = "Get all mood logs.")
    @GetMapping
    public ResponseEntity<Response> getAll() {
        Response response = new Response();
        response.setMeta(Meta.builder().build().toMetaBuilder(TypesStatus.SUCCESS.name()));
        response.setPagination(Pagination.builder().build().toPaginationBuilder());
        response.setData(iAnimoService.getAll());

        return ResponseEntity.ok(response);
    }
}
