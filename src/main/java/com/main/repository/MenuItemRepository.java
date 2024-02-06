package com.main.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.main.entity.Ingredient;
import com.main.entity.MenuItem;

public interface MenuItemRepository extends JpaRepository<MenuItem, Long> {

	public List<MenuItem> findBySiteId(long id);
}
