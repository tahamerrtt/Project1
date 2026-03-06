package com.tahamert.controller;

import com.tahamert.dto.DtoAddress;

public interface IAddressController {
    public DtoAddress getAddressById(Long id);
}
