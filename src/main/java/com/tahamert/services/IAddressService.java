package com.tahamert.services;

import com.tahamert.dto.DtoAddress;

public interface IAddressService {
    public DtoAddress getAddressById(Long id);
}
