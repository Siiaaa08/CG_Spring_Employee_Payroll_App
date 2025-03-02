
package com.example.employeepayrollapp;

import com.example.employeepayrollapp.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {
    @Query(value = "SELECT e.* FROM employees e " +
            "JOIN employee_department d ON e.employee_id = d.employee_id " +
            "WHERE d.department = :department",
            nativeQuery = true)
    List<Employee> findEmployee(String department);
}
