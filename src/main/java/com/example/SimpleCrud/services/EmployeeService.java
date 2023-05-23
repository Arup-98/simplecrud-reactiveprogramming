package com.example.SimpleCrud.services;

import com.example.SimpleCrud.dto.EmployeeDto;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface EmployeeService {
    public Mono<EmployeeDto> saveEmployee(EmployeeDto employeeDto);

    public Mono<EmployeeDto> getEmployeeById(String empId);
   public Mono<EmployeeDto> updateEmployee(EmployeeDto employeeDto, String empId);

    public Mono<Void> deleteEmployee(String empId);

    Flux<EmployeeDto> getAllEmployees();

}
