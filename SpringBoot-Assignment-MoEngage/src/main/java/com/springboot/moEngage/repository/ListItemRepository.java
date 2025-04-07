package com.springboot.moEngage.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.moEngage.entities.ListItem;

@Repository
public interface ListItemRepository extends JpaRepository<ListItem, Long>{

}
