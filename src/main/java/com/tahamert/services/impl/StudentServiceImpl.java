package com.tahamert.services.impl;

import com.tahamert.dto.DtoStudent;
import com.tahamert.dto.DtoStudentIU;
import com.tahamert.entities.Student;
import com.tahamert.repository.StudentRepository;
import com.tahamert.services.IStudentService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements IStudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public DtoStudent saveStudent(DtoStudentIU dtoStudentIU) {
        DtoStudent response = new DtoStudent();
        Student student = new Student();
        BeanUtils.copyProperties(dtoStudentIU, student);
        Student dbStudent = studentRepository.save(student);
        BeanUtils.copyProperties(dbStudent, response);
        return response;


    }

    @Override
    public List<DtoStudent> getAllStudents() {
        List<DtoStudent> dtoList = new ArrayList<>();
        List<Student> studentList = studentRepository.findAll();
        for (Student student : studentList) {
            DtoStudent dtoStudent = new DtoStudent();
            BeanUtils.copyProperties(student, dtoStudent);
            dtoList.add(dtoStudent);
        }
        return dtoList;
    }

    @Override
    public DtoStudent getStudentById(Integer id) {
        DtoStudent response = new DtoStudent();
        Optional<Student> studentOptional = studentRepository.findById(id);
        if (studentOptional.isPresent()) {
            Student student = studentOptional.get();
            BeanUtils.copyProperties(student, response);
            return response;

        }
        return null;

    }

    @Override
    public void deleteStudentById(Integer id) {
        if (studentRepository.existsById(id)) {
            studentRepository.deleteById(id);
        }
        else{
            throw new EntityNotFoundException("Student with id " + id + " not found");
        }
    }

    @Override
    public DtoStudent updateStudent(Integer id, DtoStudentIU dtoStudentIU) {
        Optional<Student> studentOptional = studentRepository.findById(id);
        if (studentOptional.isPresent()) {
            Student student = studentOptional.get();
            BeanUtils.copyProperties(dtoStudentIU, student);
            studentRepository.save(student);
            DtoStudent response = new DtoStudent();
            BeanUtils.copyProperties(student, response);
            return response;
        }

        return null;

    }

    @Override
    public DtoStudent findByName(String name) {
        DtoStudent response = new DtoStudent();
        Optional<Student> studentOptional = studentRepository.findByName(name);
        if (studentOptional.isPresent()) {
            Student student = studentOptional.get();
            BeanUtils.copyProperties(student, response);
            return response;
        }


        return null;
    }


}
