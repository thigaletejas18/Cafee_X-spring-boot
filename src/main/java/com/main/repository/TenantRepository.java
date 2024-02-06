package com.main.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.main.entity.Ingredient;
import com.main.entity.Tenant;
import com.main.entity.UserInfo;

public interface TenantRepository extends JpaRepository<Tenant, Long> {

}
