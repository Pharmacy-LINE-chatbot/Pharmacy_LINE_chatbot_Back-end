package com.example.phamacy_linechatbot_backend.DAO;

import com.example.phamacy_linechatbot_backend.entities.purchasingDetail;
import com.example.phamacy_linechatbot_backend.repository.drugRepository;
import com.example.phamacy_linechatbot_backend.repository.purchasingDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

@Repository
@Profile("db")
public class purchasingDetailDAOImpl implements purchasingDetailDAO{
    @Autowired
    purchasingDetailRepository repository;

    @Override
    public Integer getPurchasingDetailSize() {
        return Math.toIntExact(repository.count());
    }

    @Override
    public Page<purchasingDetail> getEvents(Integer pageSize, Integer page) {
        return repository.findAll(PageRequest.of(page - 1, pageSize));
    }

    @Override
    public purchasingDetail getEvent(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public purchasingDetail save(purchasingDetail event) {
        return repository.save(event);
    }

    @Override
    public Page<purchasingDetail> getEvent(String name, Pageable page) {
        return repository.findByNameContaining(name,page);
    }
}
