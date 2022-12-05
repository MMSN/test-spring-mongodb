package com.example.testmongodb.EmployeesRepository;

import com.example.testmongodb.EmployeesEntity.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface EmployeeRepository extends MongoRepository<Employee, String> {

    public Employee findByFirstName(String firstName);
    public List<Employee> findByLastName(String lastName);
}