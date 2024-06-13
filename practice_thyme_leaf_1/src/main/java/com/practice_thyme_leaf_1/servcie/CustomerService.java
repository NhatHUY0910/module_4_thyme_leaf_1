package com.practice_thyme_leaf_1.servcie;

import com.practice_thyme_leaf_1.model.Customer;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CustomerService implements ICustomerService {
    private static final Map<Integer, Customer> customers;

    static {
        customers = new HashMap<>();
        customers.put(1, new Customer(1, "An", "AnCodegym@gmail.com", "Viet Nam"));
        customers.put(2, new Customer(2, "Tri", "TriCodegym@gmail.com", "Italia"));
        customers.put(3, new Customer(3, "Sanh", "SanhCodegym@gmail.com", "America"));
        customers.put(4, new Customer(4, "Duc", "DucCodegym@gmail.com", "Germany"));
        customers.put(5, new Customer(5, "Truong", "TruongCodegym@gmail.com", "Africa"));
        customers.put(6, new Customer(6, "Quy", "QuyCodegym@gmail.com", "Hue Castle"));
    }

    @Override
    public List<Customer> getAllCustomers() {
        return new ArrayList<>(customers.values());
    }

    @Override
    public void saveCustomer(Customer customer) {
        customers.put(customer.getId(), customer);
    }

    @Override
    public Customer getCustomerById(int id) {
        return customers.get(id);
    }

    @Override
    public void updateCustomer(int id, Customer customer) {
        customers.put(id, customer);
    }

    @Override
    public void deleteCustomer(int id) {
        customers.remove(id);
    }
}
