package com.codegym.controller;

import com.codegym.model.Tour;
import com.codegym.service.ITourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
@RequestMapping("/tours")
public class TourController {
    @Autowired
    private ITourService tourService;

    @GetMapping
    public String tours(Model model) {
        Iterable<Tour> tours = tourService.getTours();
        model.addAttribute("tours", tours);
        return "/tour/list";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("tour", new Tour());
        return "/tour/create";
    }

    @PostMapping("/save")
    public String save(Tour tour) {
        tourService.save(tour);
        return "redirect:/tours";
    }

    @GetMapping("/{id}/edit")
    public String update(@PathVariable Long id, Model model) {
        Optional<Tour> tour = tourService.getTour(id);
        model.addAttribute("tour", tour.get());
        return "/tour/update";
    }

    @PostMapping("/update")
    public String update(Tour tour) {
        tourService.save(tour);
        return "redirect:/tours";
    }

    @GetMapping("/{id}/delete")
    public String delete(@PathVariable Long id, Model model) {
        Optional<Tour> tour = tourService.getTour(id);
        model.addAttribute("tour", tour.get());
        return "/tour/delete";
    }

    @PostMapping("/delete")
    public String delete(Tour tour) {
        tourService.deleteTour(tour.getId());
//        redirect.addFlashAttribute("success", "Removed customer successfully!");
        return "redirect:/tours";
    }

    @GetMapping("/{id}/view")
    public String view(@PathVariable Long id, Model model) {
      Optional<Tour> tour = tourService.getTour(id);
        model.addAttribute("tour",tour.get());
        return "/tour/view";
    }

}
