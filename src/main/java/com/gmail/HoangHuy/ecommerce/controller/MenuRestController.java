package com.gmail.HoangHuy.ecommerce.controller;

import com.gmail.HoangHuy.ecommerce.model.Perfume;
import com.gmail.HoangHuy.ecommerce.dto.PerfumeSearchFilterDto;
import com.gmail.HoangHuy.ecommerce.service.PerfumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/rest")
public class MenuRestController {

    private final PerfumeService perfumeService;

    @Autowired
    public MenuRestController(PerfumeService perfumeService) {
        this.perfumeService = perfumeService;
    }

    @PostMapping("/menu/search")
    public ResponseEntity<?> findProductsByFilterParams(@RequestBody PerfumeSearchFilterDto filterDto) {
        List<Perfume> filter = perfumeService.filter(filterDto.getPerfumers(), filterDto.getGenders(), filterDto.getPrices());

        return new ResponseEntity<>(filter, HttpStatus.OK);
    }

    @PostMapping("/menu/gender")
    public ResponseEntity<?> findByPerfumeGender(@RequestBody PerfumeSearchFilterDto filterDto) {
        List<Perfume> gender = perfumeService.findByPerfumeGenderOrderByPriceDesc(filterDto.getPerfumeGender());

        return new ResponseEntity<>(gender, HttpStatus.OK);
    }

    @PostMapping("/menu/perfumer")
    public ResponseEntity<?> findByPerfumer(@RequestBody PerfumeSearchFilterDto filterDto) {
        List<Perfume> perfumer = perfumeService.findByPerfumerOrderByPriceDesc(filterDto.getPerfumer());

        return new ResponseEntity<>(perfumer, HttpStatus.OK);
    }
}
