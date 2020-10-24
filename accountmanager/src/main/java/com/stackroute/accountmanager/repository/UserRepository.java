package com.stackroute.accountmanager.repository;

import com.stackroute.accountmanager.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, String>{

	public Optional<User> findByUserId(String id);

}
