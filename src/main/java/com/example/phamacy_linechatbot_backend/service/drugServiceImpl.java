package com.example.phamacy_linechatbot_backend.service;

import com.example.phamacy_linechatbot_backend.DAO.drugDAO;
import com.example.phamacy_linechatbot_backend.entities.drug;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class drugServiceImpl implements drugService{
    @Autowired
    drugDAO drugDAO;

    @Override
    public Integer getDrugSize() {
        return drugDAO.getDrugSize();
    }

    @Override
    public Page<drug> getEvents(Integer pageSize, Integer page) {
        return drugDAO.getEvents(pageSize,page);
    }

    @Override
    public drug getEvent(Long id) {
        return drugDAO.getEvent(id);
    }

    @Override
    public drug save(drug event) {
        return drugDAO.save(event);
    }

    @Override
    public Page<drug> getEvent(String name, Pageable page) {
        return drugDAO.getEvent(name,page);
    }
}
