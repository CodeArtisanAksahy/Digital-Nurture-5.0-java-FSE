package com.cognizant.ormlearn.repository;

import com.cognizant.ormlearn.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface CountryRepository extends JpaRepository<Country, String> {
    // Search by containing text, ordered by name ascending
    List<Country> findByNameContainingOrderByNameAsc(String name);

    // Find countries starting with a letter
    List<Country> findByNameStartingWith(String prefix);
}
