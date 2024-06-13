package com.practice_thyme_leaf_1.servcie;

import com.practice_thyme_leaf_1.model.Customer;

import java.util.List;

public interface ICustomerService {
    List<Customer> getAllCustomers();

    void saveCustomer(Customer customer);

    Customer getCustomerById(int id);

    void updateCustomer(int id, Customer customer);

    void deleteCustomer(int id);
}
