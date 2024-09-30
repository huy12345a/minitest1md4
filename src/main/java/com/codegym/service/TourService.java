package com.codegym.service;


import com.codegym.excaption.ResourceNotFoundException;
import com.codegym.model.Tour;
import com.codegym.repository.TourRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TourService {
    @Autowired
    private TourRepository tourRepository;

    public Tour createTour(Tour tour) {
        return tourRepository.save(tour);
    }

    public Tour getTour(Long id) {
        return tourRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Tour not found", message));
    }

    public Tour updateTour(Long id, Tour tourDetails) {
        Tour tour = getTour(id);
        tour.setCode(tourDetails.getCode());
        tour.setDestination(tourDetails.getDestination());
        tour.setStart(tourDetails.getStart());
        tour.setImg(tourDetails.getImg());
        return tourRepository.save(tour);
    }

    public void deleteTour(Long id) {
        tourRepository.deleteById(id);
    }

    public List<Tour> getAllTours() {
        return tourRepository.findAll();
    }
}

