package com.mahov.homeManegment.domain.mapper;

import com.mahov.homeManegment.domain.models.House;
import com.mahov.homeManegment.domain.requestDto.houseDto.HouseCreateDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface HouseMapper {

    @Mapping(target = "address", source = "address")
    @Mapping(target = "ownerId",source = "ownerId")
    House toHouse(HouseCreateDto houseCreateDto);



}
