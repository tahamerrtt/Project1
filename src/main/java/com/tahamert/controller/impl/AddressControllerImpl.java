package com.tahamert.controller.impl;

import com.tahamert.controller.IAddressController;
import com.tahamert.dto.DtoAddress;
import com.tahamert.services.IAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(path = "rest/api/address")
public class AddressControllerImpl implements IAddressController {

    @Autowired
    private IAddressService addressService;



    @Override
    @GetMapping(value = "/list/{id}")
    public DtoAddress getAddressById(@PathVariable(name = "id")Long id){
        return  addressService.getAddressById(id);
    }
}
