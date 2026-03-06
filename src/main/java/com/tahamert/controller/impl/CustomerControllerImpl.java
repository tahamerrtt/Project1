package com.tahamert.controller.impl;

import com.tahamert.controller.ICustomerController;
import com.tahamert.dto.DtoCustomer;
import com.tahamert.services.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/api/customer")
public class CustomerControllerImpl implements ICustomerController {
    @Autowired
    private ICustomerService customerService;


    @GetMapping(path = "/list/{id}")
    @Override
    public DtoCustomer getCustomerById(@PathVariable(name="id")Long id) {
        return customerService.getCustomerById(id);
    }
}
