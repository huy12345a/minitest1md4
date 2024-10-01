package com.codegym.repository;

import com.codegym.model.Province;
import com.codegym.model.Tour;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TourRepository extends JpaRepository<Tour, Long> {
    Iterable<Tour> findAllByProvince(Province province);

    Page<Tour> findAll(Pageable pageable);
}

