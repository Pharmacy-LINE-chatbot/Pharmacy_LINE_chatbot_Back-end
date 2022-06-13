package com.example.phamacy_linechatbot_backend.repository;


import com.example.phamacy_linechatbot_backend.entities.purchasingDetail;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface purchasingDetailRepository extends JpaRepository<purchasingDetail,Long> {
    List<purchasingDetail> findAll();
    Page<purchasingDetail> findByName(String title, Pageable pageRequest);
    Page<purchasingDetail> findByNameContaining(String title, Pageable pageRequest);
}
