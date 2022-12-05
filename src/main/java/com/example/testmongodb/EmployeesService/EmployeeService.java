package com.example.testmongodb.EmployeesService;

import com.example.testmongodb.EmployeesEntity.Employee;
import com.example.testmongodb.EmployeesRepository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    public Employee findById(String id) {
        return employeeRepository.findById(id).orElse(null);
    }

    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public Employee updateEmployee(String id, Employee employee) {
        Optional<Employee> oldEmployee = employeeRepository.findById(id);
        if (oldEmployee.isPresent()) {
            return employeeRepository.save(
                    new Employee(oldEmployee.get().id, employee.firstName, employee.lastName)
            );
        }
        return null;
    }

    public void deleteEmployee(String id) {
        Optional<Employee> oldEmployee = employeeRepository.findById(id);
        if (oldEmployee.isPresent()) {
            employeeRepository.delete(oldEmployee.get());
        }
        return;
    }

}