
package com.example.employeepayrollapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServices {
    private List<Employee> list=new ArrayList<>();

    @Autowired
    private EmployeeRepository employeeRepository;
    public Employee add(Employee employee){
        list.add(employee);
        return employeeRepository.save(employee);
    }

    public boolean deleting(Long id) {
        if (employeeRepository.existsById(id)) {
            employeeRepository.deleteById(id);
            return true;
        }
        return false;
    }
    public List<Employee> fetchAll(){

        return employeeRepository.findAll();
    }

    public Employee update(long id ,Employee updateEmployee) {
        return employeeRepository.findById(id).map(employee -> {employee.setName(updateEmployee.getName());
            employee.setSalary(updateEmployee.getSalary());
            return employeeRepository.save(employee);
        }).orElse(null);
    }
    public Optional<Employee> check(long id){
        return employeeRepository.findById(id);
    }
}
