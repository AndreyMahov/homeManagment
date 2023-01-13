package com.mahov.homeManegment.domain.requestDto.houseDto;

import lombok.Data;

@Data
public class HouseCreateDto {

    private String address;

    private Long ownerId;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Long getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Long ownerId) {
        this.ownerId = ownerId;
    }
}
