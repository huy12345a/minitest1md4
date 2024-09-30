package com.codegym.repository;

import com.codegym.model.Tour;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TourRepository extends JpaRepository<Tour, Long> {
    List<Tour> findByDestinationContaining(String destination);
}

