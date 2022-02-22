package com.nal.service;

import com.nal.model.Blog;
import com.nal.repository.IGeneralRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CustomerService implements IGeneralService<Blog>{
    @Autowired
    private IGeneralRepository<Blog> customerRepository;

    @Override
    public List<Blog> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public Blog findById(Long id) {
        return customerRepository.findById(id);
    }

    @Override
    public void save(Blog blog) {
        customerRepository.save(blog);
    }

    @Override
    public void remove(Long id) {
        customerRepository.remove(id);
    }
}
