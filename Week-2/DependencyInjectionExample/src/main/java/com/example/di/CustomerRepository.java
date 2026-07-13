package com.example.di;

import java.util.List;

/**
 * Repository interface for Customer data access.
 * 
 * This is the ABSTRACTION that both the service layer and
 * concrete repositories depend on. By coding to this interface,
 * we can swap implementations (in-memory, database, API-backed)
 * without changing the service layer at all.
 */
public interface CustomerRepository {

    /**
     * Find a customer by their unique ID.
     * @param id the customer ID
     * @return the customer name, or a "not found" message
     */
    String findCustomerById(int id);

    /**
     * Retrieve all customers in the repository.
     * @return list of all customer names
     */
    List<String> findAllCustomers();
}
