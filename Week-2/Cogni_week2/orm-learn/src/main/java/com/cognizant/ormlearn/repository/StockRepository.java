package com.cognizant.ormlearn.repository;

import com.cognizant.ormlearn.model.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface StockRepository extends JpaRepository<Stock, Integer> {
    // FB stocks in Sept 2019: find by code and date range
    List<Stock> findByCodeAndDateBetween(String code, LocalDate startDate, LocalDate endDate);

    // Google stocks where close > 1250
    List<Stock> findByCodeAndCloseGreaterThan(String code, BigDecimal price);

    // Top 3 by highest volume
    List<Stock> findTop3ByOrderByVolumeDesc();

    // Bottom 3 Netflix by lowest close
    List<Stock> findTop3ByCodeOrderByCloseAsc(String code);
}
