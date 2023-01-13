package com.mahov.homeManegment.services.impl;

import com.mahov.homeManegment.domain.mapper.HouseMapper;
import com.mahov.homeManegment.domain.models.House;
import com.mahov.homeManegment.domain.models.User;
import com.mahov.homeManegment.domain.requestDto.houseDto.HouseCreateDto;
import com.mahov.homeManegment.repositories.HomeRepository;
import com.mahov.homeManegment.repositories.RoleRepository;
import com.mahov.homeManegment.repositories.UserRepository;
import com.mahov.homeManegment.services.HomeService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class HomeServiceImpl implements HomeService {

    private final HomeRepository homeRepository;
    private final UserRepository userRepository;

    private final RoleRepository roleRepository;
    private final HouseMapper houseMapper;

    public HomeServiceImpl(HomeRepository homeRepository, UserRepository userRepository, RoleRepository roleRepository, HouseMapper houseMapper) {
        this.homeRepository = homeRepository;
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.houseMapper = houseMapper;
    }

    @Override
    public List<House> getAll() {
        return homeRepository.findAll();
    }

    @Override
    public House get(long id) {
        return homeRepository.findById(id).orElseThrow(RuntimeException::new);
    }

    @Override
    public void create(HouseCreateDto houseCreateDto) {
        homeRepository.save(houseMapper.toHouse(houseCreateDto));
    }

    @Override
    public void updateOwner(long id, String ownerName) {
        User newOwner = userRepository.findByName(ownerName).orElseThrow(RuntimeException::new);
        House updateHouse = homeRepository.findById(id).orElseThrow(RuntimeException::new);
        long countPreviousOwnerHouses = homeRepository.findAllByOwnerId(updateHouse.getOwnerId())
                .stream().count();
        Optional<User> previousOwner = userRepository.findById(updateHouse.getOwnerId());

        updateHouse.setOwnerId(newOwner.getId());
        homeRepository.save(updateHouse);

    }


    @Override
    public void delete(long id) {
        homeRepository.deleteById(id);
    }
}
