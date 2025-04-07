package com.springboot.moEngage.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.moEngage.entities.ListEntity;

@Repository
public interface ListRepository extends JpaRepository<ListEntity, Long> {

}
