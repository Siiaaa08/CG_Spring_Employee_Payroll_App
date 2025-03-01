
package com.example.employeepayrollapp;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Entity
@Table(name = "employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotNull(message="Employee name cannot be null")
    private String name;
    @Min(value=500,message="Min Wage should be more than 500")
    private double salary;

}
