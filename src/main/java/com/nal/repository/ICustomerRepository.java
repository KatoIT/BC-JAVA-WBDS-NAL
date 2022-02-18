package com.nal.repository;

import com.nal.model.Customer;

public interface ICustomerRepository extends IGeneralRepository<Customer> {
    boolean insertWithStoredProcedure(Customer customer);
}
