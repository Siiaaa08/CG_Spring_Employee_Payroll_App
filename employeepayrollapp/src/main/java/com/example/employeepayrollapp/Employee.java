
package com.example.employeepayrollapp;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;
import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@Table(name = "employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="employee_id")
    public long id;
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
    @ElementCollection
    @CollectionTable(name="employee_department",joinColumns = @JoinColumn(name="id"))
    @Column(name="department")
    @NotEmpty(message = "Department cannot be empty")
    public List<String> department;
    public Employee(Employee emp){
        this.name=emp.name;
        this.salary=emp.salary;
        this.gender=emp.gender;
        this.id=emp.id;
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
}
