package com.tahamert.services.impl;

import com.tahamert.dto.DtoDepartment;
import com.tahamert.dto.DtoEmployee;
import com.tahamert.entities.Employee;
import com.tahamert.repository.EmployeeRepository;
import com.tahamert.services.IEmployeeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceImpl implements IEmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;


    @Override
    public List<DtoEmployee> getEmployees() {
        List<DtoEmployee> dtoEmployees = new ArrayList<>();
        List<Employee> employeeList =employeeRepository.findAll();
        for (Employee employee : employeeList) {
            DtoDepartment dtoDepartment = new DtoDepartment();
            dtoDepartment.setId(employee.getDepartment().getId());
            dtoDepartment.setDepartmentName(employee.getDepartment().getDepartmentName());
            DtoEmployee dtoEmployee = new DtoEmployee();
            BeanUtils.copyProperties(employee, dtoEmployee);
            dtoEmployee.setDepartment(dtoDepartment);
            dtoEmployees.add(dtoEmployee);



        }





        return dtoEmployees;
    }
}
