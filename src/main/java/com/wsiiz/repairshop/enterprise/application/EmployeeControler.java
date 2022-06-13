package com.wsiiz.repairshop.enterprise.application;

import com.wsiiz.repairshop.enterprise.domain.Employee;
import com.wsiiz.repairshop.enterprise.domain.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@RestController

public class EmployeeControler {
    @Autowired
    EmployeeRepository employeeRepository;

    @GetMapping("/employees")
    public ResponseEntity<List<Employee>> getMany (
            @RequestParam(value = "idDep", required = false) Long idDepartment)
    {
        if (idDepartment == null) {
            return ResponseEntity.ok(employeeRepository.findAll());

        }
        else {
            return ResponseEntity.ok(employeeRepository.findByidDepartment(idDepartment));

        }

    }

    @GetMapping("/employees/{id}")
    public ResponseEntity<Employee> getOne (
            @PathVariable("id") Long id)
    {
        Optional<Employee> employee = employeeRepository.findById(id);
        return employee.map(ResponseEntity::ok).orElseGet(()->ResponseEntity.notFound().build());

    }

    @PostMapping("/employees")
    public ResponseEntity<Employee> addNew (@RequestBody Employee employee)
    {
        return ResponseEntity.created(null).body(employeeRepository.save(employee));
    }

    @DeleteMapping("/employees{id}")
    public ResponseEntity<Employee> remove (@PathVariable("id") Long id ){
        Optional <Employee> employee = employeeRepository.findById(id);
        if (employee.isPresent())
        {
            employeeRepository.deleteById(id);
            return ResponseEntity.ok(employee.get());

        }
        else
            return ResponseEntity.notFound().build();

    }
}
