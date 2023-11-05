package com.spring.test.Repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.test.Model.Users;

@Repository
public interface UserRepo extends JpaRepository<Users, Integer> {

	
	Optional<Users> findByEmail(String email);

	Boolean existsByEmail(String email);
}
