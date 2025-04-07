package com.springboot.moEngage.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.moEngage.entities.ResponseCodes;

@Repository
public interface ResponseCodeRepository extends JpaRepository<ResponseCodes, String> {
	 List<ResponseCodes> findByCodeStartingWith(String prefix);
}
