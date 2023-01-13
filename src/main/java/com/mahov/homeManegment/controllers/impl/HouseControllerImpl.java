package com.mahov.homeManegment.controllers.impl;

import com.mahov.homeManegment.domain.models.House;
import com.mahov.homeManegment.domain.requestDto.houseDto.HouseCreateDto;
import com.mahov.homeManegment.services.HomeService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/houses")
public class HouseControllerImpl {

    private final HomeService homeService;

    public HouseControllerImpl(HomeService homeService) {
        this.homeService = homeService;
    }

    @GetMapping
    public List<House> getAll() {
        return homeService.getAll();
    }

    @GetMapping("/{id}")
    public House get(@PathVariable("id") Long id) {
        return homeService.get(id);
    }

    @PostMapping
    public void create(@RequestBody HouseCreateDto houseCreateDto) {
        homeService.create(houseCreateDto);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable("id") long id, @RequestBody String ownerName) {
        homeService.updateOwner(id, ownerName);
    }

    @DeleteMapping("/id")
    public void delete(@PathVariable("id") long id) {
        homeService.delete(id);
    }

    //todo метод добавления жильца в дом
}
