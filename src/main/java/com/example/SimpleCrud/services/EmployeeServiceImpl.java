package com.example.SimpleCrud.services;

import com.example.SimpleCrud.dto.EmployeeDto;
import com.example.SimpleCrud.entity.Employee;
import com.example.SimpleCrud.mapper.EmployeeMapper;
import com.example.SimpleCrud.repository.EmployeeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;
    @Override
    public Mono<EmployeeDto> saveEmployee(EmployeeDto employeeDto) {
        Employee employee = EmployeeMapper.mapToEmplyee(employeeDto);
        Mono<Employee> employeeMono = employeeRepository.save((employee));
        return  employeeMono.map(employeeEntity-> EmployeeMapper.mapToEmplyeeDto(employeeEntity));
    }


    @Override
    public Mono<EmployeeDto> getEmployeeById(String empId) {
        Mono<Employee> empById = employeeRepository.findById(empId);

        return empById.map(empEntity->EmployeeMapper.mapToEmplyeeDto(empEntity));
    }
    @Override
    public Flux<EmployeeDto> getAllEmployees() {

        Flux<Employee> employeeFlux  = employeeRepository.findAll();
        return employeeFlux
                .map((employee) -> EmployeeMapper.mapToEmployeeDto(employee))
                .switchIfEmpty(Flux.empty());
    }
    public Mono<EmployeeDto> updateEmployee(EmployeeDto employeeDto, String empId) {

        Mono<Employee> employeeMono = employeeRepository.findById(empId);

        return employeeMono.flatMap((existingEmployee) -> {
            existingEmployee.setName(employeeDto.getName());
            existingEmployee.setEmail(employeeDto.getEmail());
            return employeeRepository.save(existingEmployee);
        }).map((empEntity -> EmployeeMapper.mapToEmployeeDto(empEntity)));
    }

    @Override
    public Mono<Void> deleteEmployee(String empId) {
        return employeeRepository.deleteById(empId);
    }
}
