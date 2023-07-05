package com.example.sample.mapper;

import com.example.sample.dto.EmployeeDto;
import com.example.sample.entity.Employee;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {
    EmployeeDto toDto(Employee employee);
    Employee toEntity(EmployeeDto employeeDto);

    List<EmployeeDto> employeeDtoList(List<Employee> employeeList);

    List<Employee> employeeList( List<EmployeeDto> employeeDtoList);

    @BeanMapping( nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
    Employee partialUpdate(EmployeeDto dto ,@MappingTarget Employee employee);
}
