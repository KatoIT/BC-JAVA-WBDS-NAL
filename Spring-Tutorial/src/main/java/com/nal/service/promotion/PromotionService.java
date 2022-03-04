package com.nal.service.promotion;

import com.nal.model.Promotion;
import com.nal.repository.IPromotionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class PromotionService implements IPromotionService {
    @Autowired
    private IPromotionRepository productRepository;

    @Override
    public Iterable<Promotion> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Optional<Promotion> findById(Long id) {
        return productRepository.findById(id);
    }

    @Override
    public void save(Promotion product) {
        productRepository.save(product);
    }

    @Override
    public void remove(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public Iterable<Promotion> findAllByDiscount(Double discount) {
        return productRepository.findAllByDiscount(discount);
    }

    @Override
    public Iterable<Promotion> findAllByStartDay(LocalDate startDay) {
        return productRepository.findAllByStartDay(startDay);
    }

    @Override
    public Iterable<Promotion> findAllByEndDay(LocalDate endDay) {
        return productRepository.findAllByEndDay(endDay);
    }
}
