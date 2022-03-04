package com.nal.service.promotion;

import com.nal.model.Promotion;
import com.nal.service.IGeneralService;

import java.time.LocalDate;

public interface IPromotionService extends IGeneralService<Promotion> {
    Iterable<Promotion> findAllByDiscount(Double discount);
    Iterable<Promotion> findAllByStartDay(LocalDate startDay);
    Iterable<Promotion> findAllByEndDay(LocalDate endDay);
}
