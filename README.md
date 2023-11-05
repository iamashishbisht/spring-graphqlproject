# spring-graphqlproject

Adding Queries -->

mutation {
  addEmployee(addEmployee: {name: "cccc", salary: "10", departmentId: 1}) {
    name,id
  }
  }


query{
  employeeByName(employeeName:"Ashish"){
    id,name,salary
  }
  }


mutation {
  updateSalary(updateSalaryInput: {employeeId: "1", salary: "20"}) {
    name,
    id
  }
}


query{
  allDepartment{
    name
  }
}

subscription {
  allEmployee {
    name
  }
}


I created a graphQl client to invoke graphql mappings  from an API call-->
http://localhost:8080/employeeByName
