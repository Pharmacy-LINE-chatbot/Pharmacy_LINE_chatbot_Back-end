package com.example.phamacy_linechatbot_backend.service;

import com.example.phamacy_linechatbot_backend.entities.purchasingDetail;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface purchasingDetailService {
    Integer getPurchasingDetailSize();

    Page<purchasingDetail> getEvents(Integer pageSize, Integer page);

    purchasingDetail getEvent(Long id);

    purchasingDetail save(purchasingDetail event);
    Page<purchasingDetail> getEvent(String name, Pageable page);
}
