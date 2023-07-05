package com.example.sample.controller;

import com.example.sample.dto.EmployeeDto;
import com.example.sample.entity.Employee;
import com.example.sample.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/post")
    ResponseEntity<EmployeeDto> newEmployee(@RequestBody EmployeeDto dto) {
       EmployeeDto employeeDto= employeeService.save(dto);
     return new ResponseEntity(employeeDto, HttpStatus.CREATED);
    }
    @GetMapping("/get")
    ResponseEntity<List<EmployeeDto>> allEmployee(){
        List<EmployeeDto> dtoList=employeeService.findAll();
        return new ResponseEntity<>(dtoList,HttpStatus.OK);
    }

    @PutMapping("/put/{id}")
    ResponseEntity<EmployeeDto> update(@PathVariable(name = "id") Integer id,@RequestBody EmployeeDto dto ){
        EmployeeDto dto1=employeeService.update(id,dto);
        return new ResponseEntity<>(dto1,HttpStatus.OK);
    }
}
