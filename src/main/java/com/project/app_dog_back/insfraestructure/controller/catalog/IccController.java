package com.project.app_dog_back.insfraestructure.controller.catalog;

import com.project.app_dog_back.application.response.Meta;
import com.project.app_dog_back.application.response.Pagination;
import com.project.app_dog_back.application.response.Response;
import com.project.app_dog_back.domain.model.component.TypesStatus;
import com.project.app_dog_back.domain.service.IIccService;
import com.project.app_dog_back.domain.service.IMetaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Icc", description = "Operations related to the BCI (Body Condition Index catalog documentation.).")
@RestController
@RequestMapping(path = "/api/v1/icc")
@Slf4j
@CrossOrigin(origins = "http://localhost:4200")
public class IccController {

    private IIccService iIccService;
    private IMetaService iMetaService;

    @Autowired
    public IccController(IIccService iIccService, IMetaService iMetaService) {
        this.iIccService = iIccService;
        this.iMetaService = iMetaService;
    }

    @Operation(summary = "Get all ICC records.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved")
    })
    @GetMapping
    public ResponseEntity<Response> getAll() {
        Response response = new Response();
        Meta meta = iMetaService.buildMetaBody("infor.queries", TypesStatus.SUCCESS.name());
        response.setMeta(meta);
        response.setPagination(Pagination.builder().build().toPaginationBuilder());
        response.setData(iIccService.getAll());

        return ResponseEntity.ok(response);
    }
}
