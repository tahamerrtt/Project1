package com.tahamert.controller;

import com.tahamert.dto.DtoStudent;
import com.tahamert.dto.DtoStudentIU;
import com.tahamert.entities.Student;

import java.util.List;

public interface IStudentController {

    public DtoStudent saveStudent(DtoStudentIU dtoStudentIU);
    public List<DtoStudent> getAllStudents();
    public DtoStudent getStudentById(Integer id);
    public void deleteStudentById(Integer id);
    public DtoStudent updateStudent(Integer id,DtoStudentIU dtoStudentIU);
    public DtoStudent findByName(String Firstname);

}
