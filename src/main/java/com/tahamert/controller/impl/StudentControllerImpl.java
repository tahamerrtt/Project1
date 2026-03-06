package com.tahamert.controller.impl;

import com.tahamert.controller.IStudentController;
import com.tahamert.dto.DtoStudent;
import com.tahamert.dto.DtoStudentIU;
import com.tahamert.entities.Student;
import com.tahamert.services.IStudentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@RestController
@RequestMapping("/rest/api/student")
public class StudentControllerImpl implements IStudentController   {

    @Autowired
    private IStudentService studentService;

    @PostMapping(path = "/save")
    @Override
    public DtoStudent saveStudent(@RequestBody @Valid   DtoStudentIU dtoStudentIU) {
        return  studentService.saveStudent(dtoStudentIU);
    }

    @GetMapping(path = "/list")
    @Override
    public List<DtoStudent> getAllStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping(path = "/list/{id}")
    @Override
    public DtoStudent getStudentById(@PathVariable(name = "id") Integer id) {
        return studentService.getStudentById(id);
    }

    @DeleteMapping(path = "/delete/{id}")
    @Override
    public void deleteStudentById(@PathVariable(name= "id") Integer id) {
        studentService.deleteStudentById(id);
    }

    @PutMapping(path = "/update/{id}")
    @Override
    public DtoStudent updateStudent(@PathVariable(name = "id") Integer id, @RequestBody DtoStudentIU dtoStudentIU) {
        return studentService.updateStudent(id, dtoStudentIU);
    }

    @GetMapping(path = "/list/name/{firstName}")
    @Override
    public DtoStudent findByName(@PathVariable(name="firstName")String firstName) {
        return studentService.findByName(firstName);
    }


}
