package com.example.employeepayrollapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServices {
    private List<Employee> list=new ArrayList<>();


    public void add(Employee employee){
        list.add(employee);
    }

    public boolean delete(Long id){
        for(Employee emp:list){
            if(emp.getId()==id){
                list.remove(emp);
                return true;
            }
        }
        return false;
    }
    public List<Employee> fetchAll(){
        return list;
    }

    public boolean update(long id ,Employee updateEmployee) {
        for(Employee emp:list){
            if(emp.getId()==id){
                list.remove(emp);
                list.add(updateEmployee);
                return true;
            }
        }
        return false;
    }
    public Employee check(long id){

        for(Employee emp:list){
            if(emp.getId()==id){
                return emp;
            }
        }
        return null;
    }
}

