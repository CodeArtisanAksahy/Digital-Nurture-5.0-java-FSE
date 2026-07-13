package com.example.di;

import java.util.Arrays;
import java.util.List;

/**
 * Exercise 11: Dependency Injection — Demo / Test Class
 * 
 * Demonstrates:
 *   1. Creating a concrete repository implementation
 *   2. Injecting it into CustomerService via the constructor
 *   3. Using the service to query customers
 *   4. Swapping to a completely different implementation without
 *      changing CustomerService at all
 */
public class DependencyInjectionTest {

    public static void main(String[] args) {

        System.out.println("==============================================");
        System.out.println("  Exercise 11: Dependency Injection Pattern   ");
        System.out.println("==============================================\n");

        // -------------------------------------------------------
        // STEP 1: Create the concrete dependency (repository)
        // -------------------------------------------------------
        System.out.println("--- Step 1: Create the repository implementation ---");
        CustomerRepository repository = new CustomerRepositoryImpl();

        // -------------------------------------------------------
        // STEP 2: Inject the dependency into the service
        // -------------------------------------------------------
        System.out.println("\n--- Step 2: Inject repository into CustomerService ---");
        CustomerService service = new CustomerService(repository);

        // -------------------------------------------------------
        // STEP 3: Use the service — it delegates to the injected repo
        // -------------------------------------------------------
        System.out.println("\n--- Step 3: Use the service to find customers ---");

        System.out.println("\nLooking up individual customers:");
        System.out.println("  Customer 1: " + service.getCustomer(1));
        System.out.println("  Customer 3: " + service.getCustomer(3));
        System.out.println("  Customer 9: " + service.getCustomer(9));  // not found

        System.out.println("\nFetching all customers:");
        List<String> allCustomers = service.getAllCustomers();
        for (String customer : allCustomers) {
            System.out.println("  • " + customer);
        }

        // -------------------------------------------------------
        // STEP 4: Swap to a different implementation at runtime
        // -------------------------------------------------------
        System.out.println("\n==============================================");
        System.out.println("  Demonstrating Implementation Swapping       ");
        System.out.println("==============================================\n");

        System.out.println("--- Creating an alternative 'stub' repository ---");

        // An inline alternative implementation (e.g., for testing or a different data source)
        CustomerRepository stubRepository = new CustomerRepository() {
            @Override
            public String findCustomerById(int id) {
                return "[STUB] Premium Customer #" + id;
            }

            @Override
            public List<String> findAllCustomers() {
                return Arrays.asList(
                    "[STUB] VIP Customer A",
                    "[STUB] VIP Customer B"
                );
            }
        };

        // Inject the STUB into the SAME service class — no changes needed!
        System.out.println("\n--- Injecting stub repository into a new CustomerService ---");
        CustomerService stubService = new CustomerService(stubRepository);

        System.out.println("\nLooking up customer 1 via stub:");
        System.out.println("  " + stubService.getCustomer(1));

        System.out.println("\nFetching all customers via stub:");
        List<String> stubCustomers = stubService.getAllCustomers();
        for (String customer : stubCustomers) {
            System.out.println("  • " + customer);
        }

        // -------------------------------------------------------
        // Summary
        // -------------------------------------------------------
        System.out.println("\n==============================================");
        System.out.println("  Key Takeaways                               ");
        System.out.println("==============================================");
        System.out.println("  1. CustomerService depends on the INTERFACE,");
        System.out.println("     not a concrete class.");
        System.out.println("  2. The dependency is provided via the");
        System.out.println("     constructor (Constructor Injection).");
        System.out.println("  3. We swapped from CustomerRepositoryImpl");
        System.out.println("     to a stub WITHOUT changing CustomerService.");
        System.out.println("  4. This makes code loosely coupled, testable,");
        System.out.println("     and easy to extend.");
        System.out.println("==============================================");
    }
}
