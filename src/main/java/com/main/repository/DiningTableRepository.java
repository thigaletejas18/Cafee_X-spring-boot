package com.main.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.main.entity.DiningTable;
import com.main.entity.Ingredient;

public interface DiningTableRepository extends JpaRepository<DiningTable, Long> {

	public List<DiningTable> findBySiteId(long id);
}
