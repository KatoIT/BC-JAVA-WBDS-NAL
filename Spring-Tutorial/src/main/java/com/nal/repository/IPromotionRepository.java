package com.nal.repository;

import com.nal.model.Promotion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface IPromotionRepository extends JpaRepository<Promotion, Long> {
    Iterable<Promotion> findAllByDiscount(Double discount);
    Iterable<Promotion> findAllByStartDay(LocalDate startDay);
    Iterable<Promotion> findAllByEndDay(LocalDate endDay);
}
