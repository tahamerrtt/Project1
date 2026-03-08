package com.tahamert.repository;

import com.tahamert.entities.Home;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.swing.*;

@Repository
public interface HomeRepository extends JpaRepository<Home, Long> {
}
