
package com.alder.locpol.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.alder.locpol.model.BoardBill;


@Repository
	public interface BBRepository extends JpaRepository <BoardBill, String>{

	}

