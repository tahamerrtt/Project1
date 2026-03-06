package com.tahamert.services.impl;

import com.tahamert.dto.DtoAddress;
import com.tahamert.dto.DtoCustomer;
import com.tahamert.entities.Address;
import com.tahamert.repository.AddressRepository;
import com.tahamert.repository.CustomerRepository;
import com.tahamert.services.IAddressService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.OptionalInt;

@Service
public class AddressServiceImpl implements IAddressService {

    @Autowired
    AddressRepository addressRepository;

    @Override
    public DtoAddress getAddressById(Long id) {
        DtoAddress dtoAddress = new DtoAddress();
        Optional<Address> optional = addressRepository.findById(id);
        if (optional.isEmpty()) {
            return null;
        }

        Address address = optional.get();
        BeanUtils.copyProperties(address, dtoAddress);
        DtoCustomer dtoCustomer = new DtoCustomer();
        dtoCustomer.setId(address.getCustomer().getId());
        dtoCustomer.setName(address.getCustomer().getName());


        dtoAddress.setDtoCustomer(dtoCustomer);
        return dtoAddress;



    }



}
