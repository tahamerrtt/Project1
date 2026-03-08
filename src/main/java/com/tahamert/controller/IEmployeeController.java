package com.tahamert.controller;

import com.tahamert.dto.DtoEmployee;

import java.util.List;

public interface IEmployeeController {
    public List<DtoEmployee> getEmployees();
}
