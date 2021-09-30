package com.example.springmvc01.service;

import com.example.springmvc01.controller.model.response.EmployeeResponse;
import com.example.springmvc01.exception.BusinessException;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

  public EmployeeResponse getEmployeeById(String employeeId) {
    if (employeeId.equals("10")) {
      throw new BusinessException("01", "Empleado se encuentra de vacaciones");
    }
    if (employeeId.equals("11")) {
      throw new BusinessException("02", "Empleado esta pendiente de entregar boletas");
    }
    return EmployeeResponse.builder().id(employeeId).name("Alonso Del Campo").build();
  }

}
