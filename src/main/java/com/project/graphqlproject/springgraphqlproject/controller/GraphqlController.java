package com.project.graphqlproject.springgraphqlproject.controller;

import com.project.graphqlproject.springgraphqlproject.model.AddEmployeeInput;
import com.project.graphqlproject.springgraphqlproject.model.Department;
import com.project.graphqlproject.springgraphqlproject.model.Employee;
import com.project.graphqlproject.springgraphqlproject.model.UpdateSalaryInput;
import com.project.graphqlproject.springgraphqlproject.repository.DepartmentRepository;
import com.project.graphqlproject.springgraphqlproject.repository.EmployeeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SubscriptionMapping;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@Controller
@Slf4j
public class GraphqlController {

    private final EmployeeRepository employeeRepository;
    private final DepartmentRepository departmentRepository;

    @Autowired
    public GraphqlController(EmployeeRepository employeeRepository, DepartmentRepository departmentRepository) {
        this.employeeRepository = employeeRepository;
        this.departmentRepository = departmentRepository;
    }

    //function to map employee input into employee entity
    Function<AddEmployeeInput, Employee> mapping = employeeInput -> {
        var employee = new Employee();
        //BeanUtils.copyProperties(employeeInput, employee);
        employee.setName(employeeInput.getName());
        employee.setSalary(employeeInput.getSalary());
        employee.setDepartmentId(employeeInput.getDepartmentId());
        log.info("-->"+employee.getName());
        return employee;
    };

    //@SchemaMapping(typeName = "Mutation", field = "addEmployee")
    @MutationMapping
    public Employee addEmployee(@Argument AddEmployeeInput addEmployee){
        // method name and argument name should match what defined within graphql file
        log.info("add Employee method");
        return this.employeeRepository.save(mapping.apply(addEmployee));
    }

    @QueryMapping
    public List<Employee> employeeByName(@Argument String employeeName){
        return this.employeeRepository.getEmployeeByName(employeeName);
    }

    @MutationMapping
    public Optional<Employee> updateSalary(@Argument UpdateSalaryInput updateSalaryInput){
        return employeeRepository.findById(updateSalaryInput.getEmployeeId()).
                map(employee -> {employee.setSalary(updateSalaryInput.getSalary());
                        return employeeRepository.save(employee);
                });
    }

    @QueryMapping
    public List<Department> allDepartment(){
        return departmentRepository.findAll();
    }

    @SubscriptionMapping
    public List<Employee> allEmployee(){
        return employeeRepository.findAll();
    }

}
