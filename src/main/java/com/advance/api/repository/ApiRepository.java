package com.advance.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.advance.api.entity.ApiEntity;

public interface ApiRepository extends JpaRepository<ApiEntity, Integer> {

}
