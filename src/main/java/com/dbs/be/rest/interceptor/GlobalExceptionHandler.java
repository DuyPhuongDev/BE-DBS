package com.dbs.be.rest.interceptor;

import com.dbs.be.domain.BaseException;
import com.dbs.be.rest.response.BaseResponse;
import jakarta.validation.ConstraintViolationException;
import lombok.NonNull;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Arrays;
import java.util.stream.Collectors;

@Order(Ordered.HIGHEST_PRECEDENCE)
@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
    private static final String VALIDATION_VIOLATION_EXCEPTION_CODE =
            "VALIDATION_VIOLATION_EXCEPTION";
    private static final String MESSAGE_NOT_READABLE_EXCEPTION_CODE =
            "MESSAGE_NOT_READABLE_EXCEPTION";
    private static final String CONSTRAINT_VIOLATION_EXCEPTION_CODE =
            "CONSTRAINT_VIOLATION_EXCEPTION";
    private static final String INTERNAL_AUTHENTICATION_SERVICE_EXCEPTION_CODE =
            "INTERNAL_AUTHENTICATION_SERVICE_EXCEPTION_CODE";

    private static final String ACCESS_DENIED_EXCEPTION_CODE = "ACCESS_DENIED_EXCEPTION";
    private static final String ACCESS_DENIED_EXCEPTION_MESSAGE =
            "You can not access this resource due to credential permission";

    private static final String BAD_CREDENTIAL_EXCEPTION_CODE = "BAD_CREDENTIAL_EXCEPTION";
    private static final String BAD_CREDENTIAL_EXCEPTION_MESSAGE =
            "The email or password is wrong, please try again";

    private String getRootCauseMessage(Exception exception) {
        return ExceptionUtils.getRootCauseMessage(exception);
    }

    private String getExceptionStackTrace(Exception exception) {
        return Arrays.toString(exception.getStackTrace());
    }

    private ResponseEntity<Object> wrapWithResponse(
            String code, String message, String stackTrace, HttpStatus status) {
        return new ResponseEntity<>(BaseResponse.error(code, message, stackTrace), status);
    }

    @ExceptionHandler(BaseException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<Object> handleBaseDomainException(BaseException exception) {
        return wrapWithResponse(
                exception.getCode(),
                getRootCauseMessage(exception),
                getExceptionStackTrace(exception),
                HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<Object> handleConstraintViolationException(
            ConstraintViolationException exception) {
        return wrapWithResponse(
                CONSTRAINT_VIOLATION_EXCEPTION_CODE,
                getRootCauseMessage(exception),
                getExceptionStackTrace(exception),
                HttpStatus.BAD_REQUEST);
    }



    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            @NonNull MethodArgumentNotValidException exception,
            @NonNull HttpHeaders headers,
            @NonNull HttpStatusCode status,
            @NonNull WebRequest request) {
        return wrapWithResponse(
                VALIDATION_VIOLATION_EXCEPTION_CODE,
                exception.getBindingResult().getAllErrors().stream()
                        .map(DefaultMessageSourceResolvable::getDefaultMessage)
                        .collect(Collectors.joining(", ")),
                getExceptionStackTrace(exception),
                HttpStatus.BAD_REQUEST);
    }

    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(
            @NonNull HttpMessageNotReadableException exception,
            @NonNull HttpHeaders headers,
            @NonNull HttpStatusCode status,
            @NonNull WebRequest request) {
        return wrapWithResponse(
                MESSAGE_NOT_READABLE_EXCEPTION_CODE,
                getRootCauseMessage(exception),
                getExceptionStackTrace(exception),
                HttpStatus.BAD_REQUEST);
    }
}
