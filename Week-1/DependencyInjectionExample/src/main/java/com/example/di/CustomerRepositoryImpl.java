package com.example.di;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Concrete implementation of CustomerRepository.
 * 
 * Simulates a database using an in-memory HashMap.
 * In a real application, this would connect to a database,
 * call a REST API, read from a file, etc.
 * 
 * Because the service layer depends on the CustomerRepository
 * INTERFACE (not this class), we can replace this implementation
 * without touching any service code.
 */
public class CustomerRepositoryImpl implements CustomerRepository {

    // Simulated database using a HashMap
    private final Map<Integer, String> customerDatabase;

    public CustomerRepositoryImpl() {
        customerDatabase = new HashMap<>();

        // Pre-load some customers to simulate existing data
        customerDatabase.put(1, "Alice Johnson");
        customerDatabase.put(2, "Bob Smith");
        customerDatabase.put(3, "Charlie Brown");
        customerDatabase.put(4, "Diana Prince");
        customerDatabase.put(5, "Edward Norton");

        System.out.println("[CustomerRepositoryImpl] Initialized with "
                + customerDatabase.size() + " customers (in-memory store).");
    }

    @Override
    public String findCustomerById(int id) {
        String customer = customerDatabase.get(id);
        if (customer != null) {
            return customer;
        }
        return "Customer with ID " + id + " not found";
    }

    @Override
    public List<String> findAllCustomers() {
        return new ArrayList<>(customerDatabase.values());
    }
}
