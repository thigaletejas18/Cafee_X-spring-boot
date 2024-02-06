package com.main.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.main.entity.Ingredient;
import com.main.entity.UserInfo;

public interface UserInfoRepository extends JpaRepository<UserInfo, Long> {

	Optional<UserInfo> findByEmail(String email);
	
	public List<UserInfo> findBySiteId(long id);
}
