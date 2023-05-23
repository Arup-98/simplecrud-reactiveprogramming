package com.example.SimpleCrud.entity;


import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.lang.annotation.Documented;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document(value = "employees")
public class Employee {
    @Id
    private String id;
    private String name;
    private String email;
}
