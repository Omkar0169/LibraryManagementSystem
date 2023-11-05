package com.spring.test.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.test.Model.Books;

@Repository
public interface BookRepo extends JpaRepository<Books, Integer> {

}
