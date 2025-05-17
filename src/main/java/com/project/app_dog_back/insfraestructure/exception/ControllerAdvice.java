package com.project.app_dog_back.insfraestructure.exception;

import com.project.app_dog_back.application.response.Meta;
import com.project.app_dog_back.application.response.error.ErrorGeneral;
import com.project.app_dog_back.application.response.error.ResponseErrorAttribute;
import com.project.app_dog_back.application.response.error.ResponseErrorGeneral;
import com.project.app_dog_back.domain.model.component.TypesStatus;
import com.project.app_dog_back.domain.service.IMetaService;
import com.project.app_dog_back.insfraestructure.utils.BuildErrorUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerAdvice {
    private IMetaService iMetaService;

    @Autowired
    public ControllerAdvice(IMetaService iMetaService) {
        this.iMetaService = iMetaService;
    }

    @ExceptionHandler(value = RuntimeException.class)
    public ResponseEntity<ErrorGeneral> runtimeExceptionHandler(RuntimeException ex) {
        ErrorGeneral errorGeneral = ErrorGeneral.builder().code("500").message(ex.getMessage()).build();
        return new ResponseEntity<>(errorGeneral, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(value = NotFoundException.class)
    public ResponseEntity<ResponseErrorGeneral> notFoundExceptionHandler(NotFoundException ex) {
        ResponseErrorGeneral response = new ResponseErrorGeneral();
        Meta meta = iMetaService.buildMetaBody("infor.not_found", TypesStatus.ERROR.name());
        response.setMeta(meta);
        response.setError(BuildErrorUtil.buildNotFoundExceptionForErrorAttribute(ex));
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }

    @ExceptionHandler(value = ConflictException.class)
    public ResponseEntity<ResponseErrorAttribute> conflictExceptionHandler(ConflictException ex) {
        ResponseErrorAttribute response = new ResponseErrorAttribute();
        Meta meta = iMetaService.buildMetaBody("war.repeated", TypesStatus.ERROR.name());
        response.setMeta(meta);
        response.setError(BuildErrorUtil.buildConflictExceptionForErrorAttribute(ex));
        return ResponseEntity.status(HttpStatus.CONFLICT).body(response);
    }

    @ExceptionHandler(value = BadRequestException.class)
    public ResponseEntity<ResponseErrorAttribute> badRequestExceptionHandler(BadRequestException ex) {
        ResponseErrorAttribute response = new ResponseErrorAttribute();
        Meta meta = iMetaService.buildMetaBody("error.emptynull", TypesStatus.ERROR.name());
        response.setMeta(meta);
        response.setError(BuildErrorUtil.buildBadRequestExceptionForErrorAttribute(ex));
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }

    @ExceptionHandler(value = ResponseMessageException.class)
    public ResponseEntity<ResponseErrorAttribute> responseErrorAttributeResponseEntity(ResponseMessageException ex) {
        ResponseErrorAttribute response = new ResponseErrorAttribute();
        Meta meta = iMetaService.buildMetaBodyWithEx(TypesStatus.ERROR.name(), ex);
        response.setMeta(meta);
        response.setError(BuildErrorUtil.buildResponseMessageExceptionForErrorAttribute(ex));
        return ResponseEntity.status(ex.getHttpStatus()).body(response);
    }
}
