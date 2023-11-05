package com.project.graphqlproject.springgraphqlproject.controller;

import com.project.graphqlproject.springgraphqlproject.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.client.HttpGraphQlClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
public class RestControllerGraphql {

    @Autowired
    HttpGraphQlClient httpGraphQlClient;

    @GetMapping("/employeeByName")
    public Mono<List<Employee>> getEmployeeByName(){
        var document = "query{\n" +
                "  employeeByName(employeeName:\"Ashish\"){\n" +
                "    name,salary\n" +
                "  }\n" +
                "  }";
        return  httpGraphQlClient.document(document).
                retrieve("employeeByName").
                toEntityList(Employee.class);
    }
}
