package com.main.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.main.entity.Site;
import com.main.entity.UserInfo;

public interface SiteRepository extends JpaRepository<Site, Long> {

}
