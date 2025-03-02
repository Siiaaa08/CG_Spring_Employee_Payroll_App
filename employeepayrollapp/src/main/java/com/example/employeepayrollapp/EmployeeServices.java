
package com.example.employeepayrollapp;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Slf4j
@Service
public class EmployeeServices implements IEmployeeService{
    private List<Employee> list = new ArrayList<>();

    @Autowired
    private EmployeeRepository employeeRepository;

    public Employee add(Employee employee) {
        Employee emp = null;
        emp = new Employee(employee);

        list.add(employee);
        return employeeRepository.save(emp);
    }


    public boolean deleting(Long id) {
        if (employeeRepository.existsById(id)) {
            Employee empData = check(id);
            employeeRepository.delete(empData);
            return true;
        } else {
            throw new EmployeeNotFound("Employee not found");
        }

    }

    public List<Employee> fetchAll() {

        return employeeRepository.findAll();
    }

    public Employee update(long id, Employee updateEmployee) {
        return employeeRepository.findById(id).map(employee -> {
            employee.setName(updateEmployee.getName());
            employee.setSalary(updateEmployee.getSalary());
            employee.setStartDate(updateEmployee.getStartDate());
            employee.setNote(updateEmployee.getNote());
            employee.setProfilePic(updateEmployee.getProfilePic());
            employee.setGender(updateEmployee.getGender());

            if (updateEmployee.getDepartment() != null) {
                employee.getDepartment().clear();
                employee.getDepartment().addAll(updateEmployee.getDepartment());
            }

            return employeeRepository.save(employee);
        }).orElseThrow(() -> new EmployeeNotFound("Employee not found"));
    }




    public Employee check(long id) {
        return employeeRepository.findById(id).orElseThrow(() -> new EmployeeNotFound("Employee not found."));
    }


    @Override
    public List<Employee> getEmployeeByDepartment(String department) {
        return employeeRepository.findEmployee(department);
    }
}
