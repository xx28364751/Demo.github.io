package com.example.demo.Service.ServiceImpl;

import com.example.demo.Entity.City;
import com.example.demo.Mapper.CityMapper;
import com.example.demo.Service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityServiceImpl implements CityService {
    @Autowired
    private CityMapper cityMapper;

    @Override
    public List<City> getAllCity() {
        return cityMapper.getAllCity();
    }

    @Override
    public List<City> getCityByProId(String proId) {
        return cityMapper.getCityByProId(proId);
    }
}
