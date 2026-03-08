package com.tahamert.controller.impl;

import com.tahamert.controller.IEmployeeController;
import com.tahamert.dto.DtoEmployee;
import com.tahamert.services.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/rest/api/employee")
public class EmployeeControllerImpl implements IEmployeeController {
    @Autowired
    private IEmployeeService employeeService;



    @Override
    @GetMapping(path="/list")
    public List<DtoEmployee> getEmployees() {

        return employeeService.getEmployees();
    }
}
