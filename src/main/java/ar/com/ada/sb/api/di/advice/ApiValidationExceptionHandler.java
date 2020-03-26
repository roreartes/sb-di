package ar.com.ada.sb.api.di.advice;

import ar.com.ada.sb.api.persistence.persistence.exception.ApiErrorsResponseBody;
import ar.com.ada.sb.api.persistence.persistence.exception.ApiFieldError;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.List;
import java.util.stream.Collectors;

public class ApiValidationExceptionHandler extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex,
            HttpHeaders headers,
            HttpStatus status,
            WebRequest request) {

        List<FieldError> fieldErrors = ex.getBindingResult().getFieldErrors();

        List<ApiFieldError> apiFieldErrors = fieldErrors
                .stream()
                .map(fieldError -> new ApiFieldError(
                        fieldError.getField(),
                        fieldError.getCode(),
                        fieldError.getDefaultMessage())
                )
                .collect(Collectors.toList());

        ApiErrorsResponseBody apiErrorsResponseBody = new ApiErrorsResponseBody<ApiFieldError>(
                HttpStatus.BAD_REQUEST.value(),
                HttpStatus.BAD_REQUEST.getReasonPhrase(),
                apiFieldErrors);

        return ResponseEntity
                .badRequest()
                .body(apiErrorsResponseBody);
    }
}

