
package com.example.employeepayrollapp;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // Ensure auto-increment is enabled
    @Column(name = "employee_id", nullable = false, updatable = false)
    private Long id;  // Change to Wrapper class Long instead of long

    @Pattern(regexp = "^[A-Za-z ]+$",message = "Name should contain alphabets and spaces")
    @NotNull(message="Employee name cannot be null")
    @Column(name="name")
    public String name;
    @Min(value=500,message="Min Wage should be more than 500")
    public double salary;
    @Pattern(regexp = "male|female", message = "Please enter valid gender")
    public String gender;

    @JsonFormat(pattern = "dd-MM-yyyy")
    @NotNull(message = "startDate should Not be Empty")
    @PastOrPresent(message = "startDate should be past or today date")

    public LocalDate startDate;

    @NotBlank(message = "Note cannot be empty")
    public String note;

    @NotBlank(message = "Profile Pic cannot be empty")
    public String profilePic;
    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "employee_department", joinColumns = @JoinColumn(name = "employee_id"))
    @Column(name = "department")
    @NotEmpty(message = "Department cannot be empty")
    private List<String> department = new ArrayList<>();


    public Employee(Employee emp){
        this.name=emp.name;
        this.salary=emp.salary;
        this.gender=emp.gender;
        this.department=emp.department;
        this.profilePic=emp.profilePic;
        this.note=emp.note;
        this.startDate=emp.startDate;
    }
    public Employee() {
    }

    public Employee(String name, double salary, String gender, LocalDate startDate, String note, String profilePic, List<String> department) {
        this.name = name;
        this.salary = salary;
        this.gender = gender;
        this.startDate = startDate;
        this.note = note;
        this.profilePic = profilePic;
        this.department = department;
    }
    public void updateEmployee(Employee empPayrollDTO) {
        if (empPayrollDTO.getName() != null)
            this.name = empPayrollDTO.getName();
        if (empPayrollDTO.getSalary() != 0)
            this.salary = empPayrollDTO.getSalary();
        if (empPayrollDTO.getGender() != null)
            this.gender = empPayrollDTO.getGender();
        if (empPayrollDTO.getStartDate() != null)
            this.startDate = empPayrollDTO.getStartDate();
        if (empPayrollDTO.getNote() != null)
            this.note = empPayrollDTO.getNote();
        if (empPayrollDTO.getProfilePic() != null)
            this.profilePic = empPayrollDTO.getProfilePic();
        if (empPayrollDTO.getDepartment() != null)
            this.department = empPayrollDTO.getDepartment();
    }
}
