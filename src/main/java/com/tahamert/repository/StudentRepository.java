package com.tahamert.repository;

import com.tahamert.dto.DtoStudent;
import com.tahamert.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
    @Query("SELECT s FROM Student s WHERE s.firstName = :firstName")
    Optional<Student> findByName(String firstName);



}

