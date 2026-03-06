package com.tahamert.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class DtoStudentIU {

    @NotEmpty(message = "First name can not be empty!")
    @NotNull(message = "Can not be null!")
    @NotBlank(message = "Can not be blank!")
    private String firstName;

    private String lastName;
    private Date birthOfDate;


}
