package com.example.employeepayrollapp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

        import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @GetMapping
    public String getEmployee() {
        return "Employee data";
    }



    @PostMapping("/add")
    public String add(@RequestBody Employee employee) {
        return "add";
    }

    @PutMapping("/put/{id}")
    public String put(@PathVariable Long id,@RequestBody Employee employee){
        return "putiing";
    }
    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Long id){
        return "deleting";
    }
    @GetMapping("/all")
    public String all(){
        return "all";
    }
    @GetMapping("/get/{id}")
    public String checking(@PathVariable Long id){

        return "checking";
    }


}
