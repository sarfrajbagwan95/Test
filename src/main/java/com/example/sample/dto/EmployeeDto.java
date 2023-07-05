package com.example.sample.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class EmployeeDto {

    public int id;

    public String employeeName;

    public String department;
}
