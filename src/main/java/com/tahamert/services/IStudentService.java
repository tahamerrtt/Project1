package com.tahamert.services;

import com.tahamert.dto.DtoStudent;
import com.tahamert.dto.DtoStudentIU;
import com.tahamert.entities.Student;

import java.util.List;

public interface IStudentService {
    public DtoStudent saveStudent(DtoStudentIU student);

    public List<DtoStudent> getAllStudents();

    public DtoStudent getStudentById(Integer id);

    public void deleteStudentById(Integer id);

    public DtoStudent updateStudent(Integer id ,DtoStudentIU dtoStudentIU);

    public DtoStudent findByName(String name);
}
