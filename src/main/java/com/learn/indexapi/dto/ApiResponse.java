package com.learn.indexapi.dto;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

public class ApiResponse<T> extends ResponseEntity {

    public ApiResponse(HttpStatus status) {
        this(ApiErrorBody.builder().code(status.value()).status(status.name()).build(), null, status);
    }

    public ApiResponse(T body, HttpStatus status) {
        this(ApiErrorBody.builder().code(status.value()).status(status.name()).data(body).build(), null, status);
    }

    public ApiResponse(MultiValueMap headers, HttpStatus status) {
        this(ApiErrorBody.builder().code(status.value()).build(), headers, status);
    }

    public ApiResponse(T body, MultiValueMap headers, HttpStatus status) {
        this(ApiErrorBody.builder().code(status.value()).status(status.name()).data(body).build(), headers, status);
    }

    public ApiResponse(ApiErrorBody body, MultiValueMap headers, HttpStatus status) {
        super(body, headers, status);
    }

    @Override
    public HttpStatus getStatusCode() {
        return super.getStatusCode();
    }

    @Override
    public int getStatusCodeValue() {
        return super.getStatusCodeValue();
    }

    public static <T> ApiResponse<T> response(T body, HttpStatus status) {
        return new ApiResponse(body, status);
    }

    public static <T> ApiResponse<T> okStatus(T body) {
        return new ApiResponse<T>(body, HttpStatus.OK);
    }

    @Getter
    @Setter
    @Builder
    public static class ApiErrorBody<T> {
        int code;
        String status;
        T data;
    }
}