package com.example.SimpleCrud.mapper;

import com.example.SimpleCrud.dto.EmployeeDto;
import com.example.SimpleCrud.entity.Employee;

public class EmployeeMapper {
    public static Employee mapToEmplyee(EmployeeDto employeeDto) {
        return new Employee(employeeDto.getId(), employeeDto.getName(), employeeDto.getEmail());
    }

    public static EmployeeDto mapToEmplyeeDto(Employee employee) {
        return new EmployeeDto(employee.getId(), employee.getName(), employee.getEmail());
    }

    public static EmployeeDto mapToEmployeeDto(Employee empEntity) {
        return new EmployeeDto(empEntity.getId(), empEntity.getName(), empEntity.getEmail());
    }
}

