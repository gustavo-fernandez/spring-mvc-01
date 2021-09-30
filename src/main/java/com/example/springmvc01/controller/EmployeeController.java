package com.example.springmvc01.controller;

import com.example.springmvc01.controller.model.common.ApiResponse;
import com.example.springmvc01.controller.model.response.EmployeeResponse;
import com.example.springmvc01.service.EmployeeService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/employee")
@RequiredArgsConstructor
public class EmployeeController {

  private final EmployeeService employeeService;

  @GetMapping("{id}")
  public ApiResponse<EmployeeResponse> getEmployeeById(@PathVariable("id") String employeeId) {
    if (employeeId.equals("0")) {
      throw new NullPointerException();
    }
    ApiResponse apiResponse = new ApiResponse();
    apiResponse.setData(employeeService.getEmployeeById(employeeId));
    apiResponse.setCode("00");
    return apiResponse;
  }

  @GetMapping("")
  public ApiResponse<List<EmployeeResponse>> getEmployee() {
    ApiResponse apiResponse = new ApiResponse();
    apiResponse.setCode("00");
    List<EmployeeResponse> employees = List.of(
      EmployeeResponse.builder().id("1").name("Alonso Del Campo").build(),
      EmployeeResponse.builder().id("2").name("Juan Roman").build(),
      EmployeeResponse.builder().id("3").name("Jorge Del Aguila").build(),
      EmployeeResponse.builder().id("4").name("Andres Rivas").build()
    );
    apiResponse.setData(employees);
    return apiResponse;
  }

}
