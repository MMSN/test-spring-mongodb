package com.example.testmongodb.EmployeesController;

import com.example.testmongodb.EmployeesEntity.Employee;
import com.example.testmongodb.EmployeesService.EmployeeService;
import com.mongodb.lang.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/employees")
@RestController
@ResponseBody
public class EmployeeController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public List<Employee> getAllPeople() {
        return employeeService.findAll();
    };

    @GetMapping(path = "{id}")
    public Employee getPersonById(@PathVariable("id") String id) {
        return employeeService.findById(id);
    }

    @PostMapping
    public Employee addPerson(
            @NonNull @RequestBody Employee employee) {
        return employeeService.saveEmployee(employee);
    }

    @DeleteMapping(path = "{id}")
    public void deletePersonById(@PathVariable("id") String id) {
        employeeService.deleteEmployee(id);
    }

    @PutMapping(path = "{id}")
    public void updatePerson(
            @PathVariable("id") String id,
            @NonNull @RequestBody Employee employeeToUpdate) {
        employeeService.updateEmployee(id, employeeToUpdate);

    }
}