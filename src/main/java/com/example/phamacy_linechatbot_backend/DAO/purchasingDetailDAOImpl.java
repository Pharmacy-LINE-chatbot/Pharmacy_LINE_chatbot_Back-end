package com.example.phamacy_linechatbot_backend.DAO;

import com.example.phamacy_linechatbot_backend.entities.purchasingDetail;
import com.example.phamacy_linechatbot_backend.repository.purchasingDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

@Repository
public class purchasingDetailDAOImpl implements purchasingDetailDAO{
    @Autowired
    purchasingDetailRepository purchasingDetailrepository;

    @Override
    public Integer getPurchasingDetailSize() {
        return Math.toIntExact(purchasingDetailrepository.count());
    }

    @Override
    public Page<purchasingDetail> getEvents(Integer pageSize, Integer page) {
        return purchasingDetailrepository.findAll(PageRequest.of(page - 1, pageSize));
    }

    @Override
    public purchasingDetail getEvent(Long id) {
        return purchasingDetailrepository.findById(id).orElse(null);
    }

    @Override
    public purchasingDetail save(purchasingDetail event) {
        return purchasingDetailrepository.save(event);
    }

    @Override
    public Page<purchasingDetail> getEvent(String name, Pageable page) {
        return purchasingDetailrepository.findByCustomerNameContaining(name,page);
    }
}
