package com.codegym.service;

import com.codegym.model.Tour;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface ITourService {
    Iterable<Tour> getTours();

    Optional<Tour> getTour(Long id);

    void save(Tour tour);

    void deleteTour(Long id);

    Page<Tour> getTours(Pageable pageable);
}
