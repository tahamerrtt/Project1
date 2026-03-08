package com.tahamert.controller.impl;

import com.tahamert.controller.IHomeController;
import com.tahamert.dto.DtoHome;
import com.tahamert.services.IHomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.nio.file.Path;

@RestController
@RequestMapping("/rest/api/home")

public class HomeControllerImpl implements IHomeController {
    @Autowired
    private IHomeService homeService;


    @GetMapping(path = "/{id}")
    @Override
    public DtoHome getDtoHome(@PathVariable(name="id")Long id) {
        return homeService.getDtoHome(id) ;
    }
}
