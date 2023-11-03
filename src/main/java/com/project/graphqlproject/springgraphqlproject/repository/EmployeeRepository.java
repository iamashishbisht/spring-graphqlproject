package com.project.graphqlproject.springgraphqlproject.repository;

import com.project.graphqlproject.springgraphqlproject.model.Employee;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface EmployeeRepository extends ReactiveCrudRepository<Employee, Integer> {
    Flux<Employee> getEmployeeByName(String employeeName);
}
