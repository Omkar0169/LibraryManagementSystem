package com.spring.test.Repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.test.Model.Roles;

@Repository
public interface RoleRepo  extends JpaRepository<Roles, Integer>{

	Optional<Roles> findByName(String name);
}
