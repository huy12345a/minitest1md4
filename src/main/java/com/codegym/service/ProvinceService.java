package com.codegym.service;
import com.codegym.excaption.ResourceNotFoundException;
import com.codegym.model.Province;
import com.codegym.repository.ProvinceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProvinceService {
    @Autowired
    private ProvinceRepository provinceRepository;

    public Province createProvince(Province province) {
        return provinceRepository.save(province);
    }

    public Province getProvince(Long id) {
        return provinceRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Province not found", message));
    }

    public Province updateProvince(Long id, Province provinceDetails) {
        Province province = getProvince(id);
        province.setName(provinceDetails.getName());
        return provinceRepository.save(province);
    }

    public void deleteProvince(Long id) {
        provinceRepository.deleteById(id);
    }

    public List<Province> getAllProvinces() {
        return provinceRepository.findAll();
    }
}
