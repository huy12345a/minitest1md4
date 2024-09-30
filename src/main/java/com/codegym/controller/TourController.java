package com.codegym.controller;

import com.codegym.model.Tour;
import com.codegym.service.TourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tours")
public class TourController {
    @Autowired
    private TourService tourService;

    @PostMapping
    public ResponseEntity<Tour> createTour(@RequestBody Tour tour) {
        Tour createdTour = tourService.createTour(tour);
        return ResponseEntity.status(201).body(createdTour);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Tour> getTour(@PathVariable Long id) {
        Tour tour = tourService.getTour(id);
        return ResponseEntity.ok(tour);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Tour> updateTour(@PathVariable Long id, @RequestBody Tour tour) {
        Tour updatedTour = tourService.updateTour(id, tour);
        return ResponseEntity.ok(updatedTour);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTour(@PathVariable Long id) {
        tourService.deleteTour(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<Tour>> getAllTours() {
        List<Tour> tours = tourService.getAllTours();
        return ResponseEntity.ok(tours);
    }

    @GetMapping("/view")
    public String showTours(Model model) {
        List<Tour> tours = tourService.getAllTours();
        model.addAttribute("tours", tours);
        return "tours"; // Trả về tên tệp HTML (tours.html)
    }

    @GetMapping("/form")
    public String showTourForm(@RequestParam(required = false) Long id, Model model) {
        Tour tour = (id != null) ? tourService.getTour(id) : new Tour();
        model.addAttribute("tour", tour);
        return "tour-form"; // Tệp HTML cho form
    }
}

