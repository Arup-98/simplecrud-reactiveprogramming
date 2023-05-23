package com.example.SimpleCrud.repository;

import com.example.SimpleCrud.entity.Employee;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface EmployeeRepository extends ReactiveCrudRepository<Employee,String> {

}
