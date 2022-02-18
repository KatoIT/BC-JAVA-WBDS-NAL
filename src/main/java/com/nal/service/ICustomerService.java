package com.nal.service;

import com.nal.model.Customer;

public interface ICustomerService extends IGeneralService<Customer> {
    boolean insertWithStoredProcedure(Customer customer);
}
