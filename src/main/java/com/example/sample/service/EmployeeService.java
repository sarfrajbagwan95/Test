package com.example.sample.service;

import com.example.sample.dto.EmployeeDto;


import java.util.List;

public interface EmployeeService {
    EmployeeDto save(EmployeeDto dto);

    List<EmployeeDto> findAll();


    EmployeeDto update(Integer id, EmployeeDto dto);
}
