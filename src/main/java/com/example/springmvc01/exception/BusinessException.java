package com.example.springmvc01.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class BusinessException extends RuntimeException {

  private final String code;
  private final String message;

}
