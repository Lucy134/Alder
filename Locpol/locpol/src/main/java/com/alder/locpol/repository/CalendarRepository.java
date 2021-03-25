package com.alder.locpol.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.alder.locpol.model.CalItem;

@Repository
public interface CalendarRepository extends JpaRepository <CalItem, Long> {

}
