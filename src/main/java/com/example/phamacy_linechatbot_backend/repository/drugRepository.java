package com.example.phamacy_linechatbot_backend.repository;

import com.example.phamacy_linechatbot_backend.entities.drug;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface drugRepository extends JpaRepository<drug,Long> {
    List<drug> findAll();
    Page<drug> findByName(String title, Pageable pageRequest);
    Page<drug> findByNameContaining(String title, Pageable pageRequest);
}
