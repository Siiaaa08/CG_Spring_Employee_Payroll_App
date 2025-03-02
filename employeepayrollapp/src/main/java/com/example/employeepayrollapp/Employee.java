
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
    private long id;
    @Pattern(regexp = "^[A-Za-z ]+$",message = "Name should contain alphabets and spaces")
    @NotNull(message="Employee name cannot be null")
    private String name;
    @Min(value=500,message="Min Wage should be more than 500")
    private double salary;
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

    @NotEmpty(message = "Department cannot be empty")
    public List<String> department;

}
