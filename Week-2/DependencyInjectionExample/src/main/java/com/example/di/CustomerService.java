package com.example.di;

import java.util.List;

/**
 * Service class that provides business logic for customer operations.
 * 
 * KEY DESIGN DECISION — Constructor Injection:
 *   This class declares its dependency as the CustomerRepository INTERFACE,
 *   and receives the concrete implementation through the constructor.
 *   It never creates its own repository instance (no "new" keyword for deps).
 * 
 * Benefits:
 *   1. Loose coupling  — Service doesn't know or care which implementation it uses.
 *   2. Testability     — You can inject a mock/stub repository for unit tests.
 *   3. Flexibility     — Swap implementations (DB, cache, API) without changing this class.
 *   4. Single Responsibility — This class focuses on business logic, not on wiring.
 */
public class CustomerService {

    // Dependency declared as the INTERFACE type, not the concrete class
    private final CustomerRepository customerRepository;

    /**
     * Constructor Injection: the dependency is provided from outside.
     * 
     * @param customerRepository the repository implementation to use
     */
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
        System.out.println("[CustomerService] Created with repository: "
                + customerRepository.getClass().getSimpleName());
    }

    /**
     * Get a single customer by ID.
     * Delegates to the injected repository.
     */
    public String getCustomer(int id) {
        System.out.println("[CustomerService] Looking up customer with ID: " + id);
        return customerRepository.findCustomerById(id);
    }

    /**
     * Get all customers.
     * Delegates to the injected repository.
     */
    public List<String> getAllCustomers() {
        System.out.println("[CustomerService] Fetching all customers...");
        return customerRepository.findAllCustomers();
    }
}
