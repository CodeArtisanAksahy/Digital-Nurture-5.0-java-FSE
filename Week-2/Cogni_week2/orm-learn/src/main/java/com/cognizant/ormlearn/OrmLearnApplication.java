package com.cognizant.ormlearn;

import com.cognizant.ormlearn.model.Country;
import com.cognizant.ormlearn.model.Department;
import com.cognizant.ormlearn.model.Employee;
import com.cognizant.ormlearn.model.Skill;
import com.cognizant.ormlearn.model.Stock;
import com.cognizant.ormlearn.repository.DepartmentRepository;
import com.cognizant.ormlearn.repository.EmployeeRepository;
import com.cognizant.ormlearn.repository.SkillRepository;
import com.cognizant.ormlearn.repository.StockRepository;
import com.cognizant.ormlearn.service.CountryService;
import com.cognizant.ormlearn.service.exception.CountryNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@SpringBootApplication
public class OrmLearnApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrmLearnApplication.class);

    private static CountryService countryService;
    private static StockRepository stockRepository;
    private static EmployeeRepository employeeRepository;
    private static DepartmentRepository departmentRepository;
    private static SkillRepository skillRepository;

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(OrmLearnApplication.class, args);

        // Get beans from context
        countryService = context.getBean(CountryService.class);
        stockRepository = context.getBean(StockRepository.class);
        employeeRepository = context.getBean(EmployeeRepository.class);
        departmentRepository = context.getBean(DepartmentRepository.class);
        skillRepository = context.getBean(SkillRepository.class);

        // ==================== COUNTRY TESTS ====================
        LOGGER.info("============================================================");
        LOGGER.info("         COUNTRY SERVICE TESTS");
        LOGGER.info("============================================================");

        // Hands-on 1: Get all countries
        testGetAllCountries();

        // Hands-on 6: Find country by code
        testFindCountryByCode();

        // Hands-on 7: Add a new country
        testAddCountry();

        // Hands-on 8: Update a country
        testUpdateCountry();

        // Hands-on 9: Delete a country
        testDeleteCountry();

        // Query methods: Find by name containing
        testFindByNameContaining();

        // Query methods: Find by name starting with
        testFindByNameStartingWith();

        // ==================== STOCK TESTS ====================
        LOGGER.info("============================================================");
        LOGGER.info("         STOCK REPOSITORY TESTS");
        LOGGER.info("============================================================");

        // Stock query: Facebook stocks in September 2019
        testFindFacebookStocksSeptember();

        // Stock query: Google stocks where close > 1250
        testFindGoogleStocksAbove1250();

        // Stock query: Top 3 stocks by volume
        testFindTop3ByVolume();

        // Stock query: Bottom 3 Netflix stocks by close price
        testFindLowestNetflixStocks();

        // ==================== RELATIONSHIP TESTS ====================
        LOGGER.info("============================================================");
        LOGGER.info("         RELATIONSHIP TESTS (Employee-Department-Skill)");
        LOGGER.info("============================================================");

        // Relationship: Employee with Department (ManyToOne)
        testGetEmployeeWithDepartment();

        // Relationship: Department with Employees (OneToMany)
        testGetDepartmentWithEmployees();

        // Relationship: Employee with Skills (ManyToMany)
        testGetEmployeeWithSkills();

        LOGGER.info("============================================================");
        LOGGER.info("         ALL TESTS COMPLETED SUCCESSFULLY!");
        LOGGER.info("============================================================");
    }

    /**
     * Hands-on 1: Get all countries and log them
     */
    private static void testGetAllCountries() {
        LOGGER.info("------------------------------------------------------------");
        LOGGER.info("TEST: Get All Countries");
        LOGGER.info("------------------------------------------------------------");
        try {
            List<Country> countries = countryService.getAllCountries();
            LOGGER.info("Total countries found: {}", countries.size());
            for (Country country : countries) {
                LOGGER.info("{}", country);
            }
        } catch (Exception e) {
            LOGGER.error("Error in testGetAllCountries: {}", e.getMessage());
        }
    }

    /**
     * Hands-on 6: Find country by code "IN"
     */
    private static void testFindCountryByCode() {
        LOGGER.info("------------------------------------------------------------");
        LOGGER.info("TEST: Find Country By Code 'IN'");
        LOGGER.info("------------------------------------------------------------");
        try {
            Country country = countryService.findCountryByCode("IN");
            LOGGER.info("Country found: {}", country);
        } catch (CountryNotFoundException e) {
            LOGGER.error("Country not found: {}", e.getMessage());
        } catch (Exception e) {
            LOGGER.error("Error in testFindCountryByCode: {}", e.getMessage());
        }
    }

    /**
     * Hands-on 7: Add a new country "ZZ" - "Test Country"
     */
    private static void testAddCountry() {
        LOGGER.info("------------------------------------------------------------");
        LOGGER.info("TEST: Add New Country 'ZZ' - 'Test Country'");
        LOGGER.info("------------------------------------------------------------");
        try {
            Country newCountry = new Country("ZZ", "Test Country");
            countryService.addCountry(newCountry);
            LOGGER.info("Country added successfully: {}", newCountry);

            // Verify the addition
            Country found = countryService.findCountryByCode("ZZ");
            LOGGER.info("Verification - Country retrieved: {}", found);
        } catch (CountryNotFoundException e) {
            LOGGER.error("Country not found after add: {}", e.getMessage());
        } catch (Exception e) {
            LOGGER.error("Error in testAddCountry: {}", e.getMessage());
        }
    }

    /**
     * Hands-on 8: Update country "ZZ" name to "Test Country Updated"
     */
    private static void testUpdateCountry() {
        LOGGER.info("------------------------------------------------------------");
        LOGGER.info("TEST: Update Country 'ZZ' to 'Test Country Updated'");
        LOGGER.info("------------------------------------------------------------");
        try {
            countryService.updateCountry("ZZ", "Test Country Updated");
            LOGGER.info("Country updated successfully");

            // Verify the update
            Country found = countryService.findCountryByCode("ZZ");
            LOGGER.info("Verification - Country after update: {}", found);
        } catch (CountryNotFoundException e) {
            LOGGER.error("Country not found for update: {}", e.getMessage());
        } catch (Exception e) {
            LOGGER.error("Error in testUpdateCountry: {}", e.getMessage());
        }
    }

    /**
     * Hands-on 9: Delete country "ZZ"
     */
    private static void testDeleteCountry() {
        LOGGER.info("------------------------------------------------------------");
        LOGGER.info("TEST: Delete Country 'ZZ'");
        LOGGER.info("------------------------------------------------------------");
        try {
            countryService.deleteCountry("ZZ");
            LOGGER.info("Country 'ZZ' deleted successfully");

            // Verify the deletion
            try {
                countryService.findCountryByCode("ZZ");
                LOGGER.warn("Country 'ZZ' still exists after deletion!");
            } catch (CountryNotFoundException e) {
                LOGGER.info("Verification - Country 'ZZ' no longer exists (as expected)");
            }
        } catch (Exception e) {
            LOGGER.error("Error in testDeleteCountry: {}", e.getMessage());
        }
    }

    /**
     * Query method: Find countries containing "ou" in their name
     */
    private static void testFindByNameContaining() {
        LOGGER.info("------------------------------------------------------------");
        LOGGER.info("TEST: Find Countries Containing 'ou'");
        LOGGER.info("------------------------------------------------------------");
        try {
            List<Country> countries = countryService.findByNameContaining("ou");
            LOGGER.info("Countries containing 'ou': {} results", countries.size());
            for (Country country : countries) {
                LOGGER.info("{}", country);
            }
        } catch (Exception e) {
            LOGGER.error("Error in testFindByNameContaining: {}", e.getMessage());
        }
    }

    /**
     * Query method: Find countries starting with "Z"
     */
    private static void testFindByNameStartingWith() {
        LOGGER.info("------------------------------------------------------------");
        LOGGER.info("TEST: Find Countries Starting With 'Z'");
        LOGGER.info("------------------------------------------------------------");
        try {
            List<Country> countries = countryService.findByNameStartingWith("Z");
            LOGGER.info("Countries starting with 'Z': {} results", countries.size());
            for (Country country : countries) {
                LOGGER.info("{}", country);
            }
        } catch (Exception e) {
            LOGGER.error("Error in testFindByNameStartingWith: {}", e.getMessage());
        }
    }

    /**
     * Stock query: Find Facebook stocks in September 2019
     */
    private static void testFindFacebookStocksSeptember() {
        LOGGER.info("------------------------------------------------------------");
        LOGGER.info("TEST: Facebook Stocks in September 2019");
        LOGGER.info("------------------------------------------------------------");
        try {
            LocalDate startDate = LocalDate.of(2019, 9, 1);
            LocalDate endDate = LocalDate.of(2019, 9, 30);
            List<Stock> stocks = stockRepository.findByCodeAndDateBetween("FB", startDate, endDate);
            LOGGER.info("Facebook stocks in Sept 2019: {} records", stocks.size());
            for (Stock stock : stocks) {
                LOGGER.info("{}", stock);
            }
        } catch (Exception e) {
            LOGGER.error("Error in testFindFacebookStocksSeptember: {}", e.getMessage());
        }
    }

    /**
     * Stock query: Find Google stocks where close > 1250
     */
    private static void testFindGoogleStocksAbove1250() {
        LOGGER.info("------------------------------------------------------------");
        LOGGER.info("TEST: Google Stocks with Close > 1250");
        LOGGER.info("------------------------------------------------------------");
        try {
            List<Stock> stocks = stockRepository.findByCodeAndCloseGreaterThan("GOOGL", new BigDecimal("1250"));
            LOGGER.info("Google stocks with close > 1250: {} records", stocks.size());
            for (Stock stock : stocks) {
                LOGGER.info("{}", stock);
            }
        } catch (Exception e) {
            LOGGER.error("Error in testFindGoogleStocksAbove1250: {}", e.getMessage());
        }
    }

    /**
     * Stock query: Find top 3 stocks by highest volume
     */
    private static void testFindTop3ByVolume() {
        LOGGER.info("------------------------------------------------------------");
        LOGGER.info("TEST: Top 3 Stocks by Volume");
        LOGGER.info("------------------------------------------------------------");
        try {
            List<Stock> stocks = stockRepository.findTop3ByOrderByVolumeDesc();
            LOGGER.info("Top 3 stocks by volume:");
            for (Stock stock : stocks) {
                LOGGER.info("{}", stock);
            }
        } catch (Exception e) {
            LOGGER.error("Error in testFindTop3ByVolume: {}", e.getMessage());
        }
    }

    /**
     * Stock query: Find bottom 3 Netflix stocks by lowest close price
     */
    private static void testFindLowestNetflixStocks() {
        LOGGER.info("------------------------------------------------------------");
        LOGGER.info("TEST: Bottom 3 Netflix Stocks by Lowest Close Price");
        LOGGER.info("------------------------------------------------------------");
        try {
            List<Stock> stocks = stockRepository.findTop3ByCodeOrderByCloseAsc("NFLX");
            LOGGER.info("Bottom 3 Netflix stocks by close price:");
            for (Stock stock : stocks) {
                LOGGER.info("{}", stock);
            }
        } catch (Exception e) {
            LOGGER.error("Error in testFindLowestNetflixStocks: {}", e.getMessage());
        }
    }

    /**
     * Relationship test: Get employee and verify department is loaded (ManyToOne)
     */
    private static void testGetEmployeeWithDepartment() {
        LOGGER.info("------------------------------------------------------------");
        LOGGER.info("TEST: Get Employee with Department (ManyToOne)");
        LOGGER.info("------------------------------------------------------------");
        try {
            Optional<Employee> result = employeeRepository.findById(1);
            if (result.isPresent()) {
                Employee employee = result.get();
                LOGGER.info("Employee: {}", employee);
                LOGGER.info("Employee's Department: {}", employee.getDepartment());
            } else {
                LOGGER.warn("Employee with id 1 not found");
            }
        } catch (Exception e) {
            LOGGER.error("Error in testGetEmployeeWithDepartment: {}", e.getMessage());
        }
    }

    /**
     * Relationship test: Get department and verify employees are loaded (OneToMany)
     */
    private static void testGetDepartmentWithEmployees() {
        LOGGER.info("------------------------------------------------------------");
        LOGGER.info("TEST: Get Department with Employees (OneToMany)");
        LOGGER.info("------------------------------------------------------------");
        try {
            Optional<Department> result = departmentRepository.findById(2);
            if (result.isPresent()) {
                Department department = result.get();
                LOGGER.info("Department: {}", department);
                List<Employee> employees = department.getEmployees();
                LOGGER.info("Employees in {} department: {} employees", department.getName(), employees.size());
                for (Employee emp : employees) {
                    LOGGER.info("  -> {}", emp);
                }
            } else {
                LOGGER.warn("Department with id 2 not found");
            }
        } catch (Exception e) {
            LOGGER.error("Error in testGetDepartmentWithEmployees: {}", e.getMessage());
        }
    }

    /**
     * Relationship test: Get employee and verify skills are loaded (ManyToMany)
     */
    private static void testGetEmployeeWithSkills() {
        LOGGER.info("------------------------------------------------------------");
        LOGGER.info("TEST: Get Employee with Skills (ManyToMany)");
        LOGGER.info("------------------------------------------------------------");
        try {
            Optional<Employee> result = employeeRepository.findById(1);
            if (result.isPresent()) {
                Employee employee = result.get();
                LOGGER.info("Employee: {}", employee);
                Set<Skill> skills = employee.getSkills();
                LOGGER.info("Skills of {}: {} skills", employee.getName(), skills.size());
                for (Skill skill : skills) {
                    LOGGER.info("  -> {}", skill);
                }
            } else {
                LOGGER.warn("Employee with id 1 not found");
            }
        } catch (Exception e) {
            LOGGER.error("Error in testGetEmployeeWithSkills: {}", e.getMessage());
        }
    }
}
