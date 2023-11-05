package com.project.graphqlproject.springgraphqlproject.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
public class Employee {

    @Id
    @GeneratedValue
    private int id;
    private String name;
    private String salary;
    private int departmentId;

}
