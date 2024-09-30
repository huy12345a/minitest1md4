package com.codegym.controller;

import com.codegym.model.Province;
import com.codegym.service.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/provinces")
public class ProvinceController {
    @Autowired
    private ProvinceService provinceService;

    @PostMapping
    public ResponseEntity<Province> createProvince(@RequestBody Province province) {
        Province createdProvince = provinceService.createProvince(province);
        return ResponseEntity.status(201).body(createdProvince);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Province> getProvince(@PathVariable Long id) {
        Province province = provinceService.getProvince(id);
        return ResponseEntity.ok(province);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Province> updateProvince(@PathVariable Long id, @RequestBody Province province) {
        Province updatedProvince = provinceService.updateProvince(id, province);
        return ResponseEntity.ok(updatedProvince);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProvince(@PathVariable Long id) {
        provinceService.deleteProvince(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<Province>> getAllProvinces() {
        List<Province> provinces = provinceService.getAllProvinces();
        return ResponseEntity.ok(provinces);
    }

    @GetMapping("/view")
    public String showProvinces(Model model) {
        List<Province> provinces = provinceService.getAllProvinces();
        model.addAttribute("provinces", provinces);
        return "provinces"; // Trả về tên tệp HTML (provinces.html)
    }

    @GetMapping("/form")
    public String showProvinceForm(@RequestParam(required = false) Long id, Model model) {
        Province province = (id != null) ? provinceService.getProvince(id) : new Province();
        model.addAttribute("province", province);
        return "province-form";
    }
}

