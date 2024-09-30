package com.codegym.service;
import com.codegym.excaption.ResourceNotFoundException;
import com.codegym.model.Province;
import com.codegym.repository.ProvinceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProvinceService implements IProvinceService {
 @Autowired
 private ProvinceRepository provinceRepository;
    @Override
    public Iterable<Province> getAllProvinces() {
        return provinceRepository.findAll() ;
    }

    @Override
    public Optional<Province> getProvinceById(Long id) {
        return provinceRepository.findById(id);
    }

    @Override
    public void saveProvince(Province province) {
        provinceRepository.save(province);
    }

    @Override
    public void deleteProvince(Long id) {
        provinceRepository.deleteById(id);
    }

    @Override
    public Page<Province> getPageProvinces(Pageable pageable) {
        return provinceRepository.findAll(pageable);
    }
}
