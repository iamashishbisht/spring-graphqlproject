package com.project.graphqlproject.springgraphqlproject.repository;

import com.project.graphqlproject.springgraphqlproject.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    List<Employee> getEmployeeByName(String employeeName);
}
