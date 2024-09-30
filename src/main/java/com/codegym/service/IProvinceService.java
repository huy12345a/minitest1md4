package com.codegym.service;

import com.codegym.model.Province;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface IProvinceService {
    Iterable<Province> getAllProvinces();

    Optional<Province> getProvinceById(Long id);

    void saveProvince(Province province);

    void deleteProvince(Long id);

    Page<Province> getPageProvinces(Pageable pageable);
}
