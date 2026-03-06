package com.tahamert.services;

import com.tahamert.dto.DtoCustomer;

public interface ICustomerService {

    public DtoCustomer getCustomerById(Long id);

}
