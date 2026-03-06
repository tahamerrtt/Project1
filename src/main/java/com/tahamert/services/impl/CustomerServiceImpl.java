package com.tahamert.services.impl;

import com.tahamert.dto.DtoAddress;
import com.tahamert.dto.DtoCustomer;
import com.tahamert.entities.Address;
import com.tahamert.entities.Customer;
import com.tahamert.repository.CustomerRepository;
import com.tahamert.services.ICustomerService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerServiceImpl implements ICustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public DtoCustomer getCustomerById(Long id) {
        DtoCustomer dtoCustomer = new DtoCustomer();
        DtoAddress dtoAddress = new DtoAddress();

        Optional<Customer> optional = customerRepository.findById(id);
        if (optional.isEmpty()) {
            return null;

        }
        Customer customer = optional.get();
        Address address = customer.getAddress();

        BeanUtils.copyProperties(customer, dtoCustomer);
        BeanUtils.copyProperties(address, dtoAddress);
        dtoCustomer.setAddress(dtoAddress);
        return dtoCustomer;


    }
}
