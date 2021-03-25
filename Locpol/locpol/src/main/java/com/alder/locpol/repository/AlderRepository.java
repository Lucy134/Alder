package com.alder.locpol.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.alder.locpol.model.Alderman;

@Repository
public interface AlderRepository extends JpaRepository <Alderman, String>{

	@Query("FROM Alderman a INNER JOIN User u ON a.ward = u.ward WHERE u.email=?1")
	List<Alderman> searchAlderman(String email);

}
