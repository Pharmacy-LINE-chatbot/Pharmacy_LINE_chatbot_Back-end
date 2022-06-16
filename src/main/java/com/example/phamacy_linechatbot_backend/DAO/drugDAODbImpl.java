package com.example.phamacy_linechatbot_backend.DAO;

import com.example.phamacy_linechatbot_backend.entities.drug;
import com.example.phamacy_linechatbot_backend.repository.drugRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

@Repository
@Profile("db")
public class drugDAODbImpl implements drugDAO{
    @Autowired
    drugRepository repository;

    @Override
    public Integer getDrugSize() {
        return Math.toIntExact(repository.count());
    }

    @Override
    public Page<drug> getEvents(Integer pageSize, Integer page) {
        return repository.findAll(PageRequest.of(page - 1, pageSize));
    }

    @Override
    public drug getEvent(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public drug save(drug event) {
        return repository.save(event);
    }

    @Override
    public Page<drug> getEvent(String name, Pageable page) {
        return repository.findByNameContaining(name,page);
    }

    @Override
    public void delete(drug event) {
        repository.delete(event);
    }
}
