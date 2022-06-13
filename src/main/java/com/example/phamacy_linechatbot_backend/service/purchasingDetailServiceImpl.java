package com.example.phamacy_linechatbot_backend.service;

import com.example.phamacy_linechatbot_backend.DAO.drugDAO;
import com.example.phamacy_linechatbot_backend.DAO.purchasingDetailDAO;
import com.example.phamacy_linechatbot_backend.entities.purchasingDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class purchasingDetailServiceImpl implements purchasingDetailService {
    @Autowired
    purchasingDetailDAO purchasingDetailDAO;

    @Override
    public Integer getpurchasingDetailSize() {
        return purchasingDetailDAO.getPurchasingDetailSize();
    }

    @Override
    public Page<purchasingDetail> getEvents(Integer pageSize, Integer page) {
        return purchasingDetailDAO.getEvents(pageSize,page);
    }

    @Override
    public purchasingDetail getEvent(Long id) {
        return purchasingDetailDAO.getEvent(id);
    }

    @Override
    public purchasingDetail save(purchasingDetail event) {
        return purchasingDetailDAO.save(event);
    }

    @Override
    public Page<purchasingDetail> getEvent(String name, Pageable page) {
        return purchasingDetailDAO.getEvent(name,page);
    }
}
