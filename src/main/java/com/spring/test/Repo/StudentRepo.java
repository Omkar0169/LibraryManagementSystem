package com.spring.test.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.test.Model.Student;

@Repository
public interface StudentRepo extends JpaRepository<Student, Integer> {

}
