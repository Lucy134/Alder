package com.alder.locpol.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.alder.locpol.model.User;

@Repository
	public interface UserRepository extends JpaRepository <User, String>{

	}

