package com.nal.service.customer;

import com.nal.model.Customer;
import com.nal.model.Province;
import com.nal.service.IGeneralService;

public interface ICustomerService extends IGeneralService<Customer> {
    Iterable<Customer> findAllByProvince(Province province);
}
