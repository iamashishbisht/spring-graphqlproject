package com.project.graphqlproject.springgraphqlproject.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateSalaryInput {
    private int employeeId;
    private String salary;
}
