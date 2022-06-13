package com.example.phamacy_linechatbot_backend.service;

import com.example.phamacy_linechatbot_backend.entities.drug;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface drugService {
    Integer getDrugSize();

    Page<drug> getEvents(Integer pageSize, Integer page);

    drug getEvent(Long id);

    drug save(drug event);
    Page<drug> getEvent(String name, Pageable page);
}
