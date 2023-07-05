package com.example.sample.service;

import com.example.sample.dto.EmployeeDto;
import com.example.sample.entity.Employee;
import com.example.sample.exceptions.EmployeeNotFoundException;

import com.example.sample.mapper.EmployeeMapper;
import com.example.sample.repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService{
    @Autowired
    private EmployeeRepo employeeRepo;
    @Autowired
    private EmployeeMapper mapper;
    @Override
    public EmployeeDto save(EmployeeDto dto) {
        Employee newEmployee=mapper.toEntity(dto);
       Employee employee= employeeRepo.save(newEmployee);
       EmployeeDto employeeDto=mapper.toDto(employee);
        return employeeDto;
    }

    @Override
    public List<EmployeeDto> findAll() {
        List<Employee> allEmployee=employeeRepo.findAll();
List<EmployeeDto> dtoList=mapper.employeeDtoList(allEmployee);
        return dtoList;
    }

    @Override
    public EmployeeDto update(Integer id, EmployeeDto dto) {
        Employee currentEntity=employeeRepo.findById(id).get();
Employee newEntity=mapper.partialUpdate(dto,currentEntity);
Employee employee=employeeRepo.save(newEntity);
        return mapper.toDto(employee);
    }


}
