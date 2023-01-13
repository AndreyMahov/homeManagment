package com.mahov.homeManegment.services;

import com.mahov.homeManegment.domain.models.House;
import com.mahov.homeManegment.domain.requestDto.houseDto.HouseCreateDto;

import java.util.List;

public interface HomeService {
    List<House> getAll();

    House get(long id);

    void create(HouseCreateDto houseCreateDto);

    void updateOwner(long id, String ownerName);

    void delete(long id);
}
