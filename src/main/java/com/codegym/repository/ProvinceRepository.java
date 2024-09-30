package com.codegym.repository;
import com.codegym.model.Province;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface ProvinceRepository extends JpaRepository<Province, Long> {
    @Transactional
    @Query(value = "SELECT p.name, COUNT(t.id) FROM Province p LEFT JOIN Tour t ON p.id = t.province.id GROUP BY p.name")
    List<Object[]> countToursByProvince();
    Page<Province> findAllByOrderByNameAsc(Pageable pageable);
}


