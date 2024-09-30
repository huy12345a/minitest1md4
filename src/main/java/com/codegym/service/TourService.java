package com.codegym.service;

import com.codegym.model.Tour;
import com.codegym.repository.TourRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TourService implements ITourService {
    @Autowired
    private TourRepository tourRepository;

    @Override
    public Iterable<Tour> getTours() {
        return tourRepository.findAll();
    }

    @Override
    public Optional<Tour> getTour(Long id) {
        return tourRepository.findById(id);
    }

    @Override
    public void save(Tour tour) {
        tourRepository.save(tour);
    }

    @Override
    public void deleteTour(Long id) {
        tourRepository.deleteById(id);
    }

    @Override
    public Page<Tour> getTours(Pageable pageable) {
        return tourRepository.findAll(pageable);
    }
}

