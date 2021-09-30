package com.example.springmvc01.controller.model.common;

import lombok.Data;

@Data
public class ApiResponse<T> {

  private String code;
  private T data;

}
