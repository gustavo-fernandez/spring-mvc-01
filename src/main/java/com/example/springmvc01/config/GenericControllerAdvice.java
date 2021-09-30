package com.example.springmvc01.config;

import com.example.springmvc01.controller.model.common.ApiResponse;
import com.example.springmvc01.exception.BusinessException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Slf4j
public class GenericControllerAdvice {

  @ExceptionHandler(BusinessException.class)
  public ResponseEntity<ApiResponse<String>> exceptionHandler(BusinessException businessException) {
    ApiResponse<String> apiResponse = new ApiResponse<>();
    apiResponse.setCode(businessException.getCode());
    apiResponse.setData(businessException.getMessage()); // message
    return new ResponseEntity<>(apiResponse, HttpStatus.OK);
  }

  @ExceptionHandler(Throwable.class)
  public ResponseEntity<ApiResponse<String>> anyException(Throwable throwable) {
    log.error("Error no controlado", throwable);
    ApiResponse<String> apiResponse = new ApiResponse<>();
    apiResponse.setCode("99");
    apiResponse.setData("Ocurrio un error no controlado");
    return new ResponseEntity<>(apiResponse, HttpStatus.INTERNAL_SERVER_ERROR);
  }

}
