package com.project.graphqlproject.springgraphqlproject.repository;

import com.project.graphqlproject.springgraphqlproject.model.Department;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends ReactiveCrudRepository<Department, Integer> {
}
