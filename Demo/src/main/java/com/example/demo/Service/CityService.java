package com.example.demo.Service;

import com.example.demo.Entity.City;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CityService {
    //查询所有城市
    public List<City> getAllCity();

    //根据省编码查询市
    public List<City> getCityByProId(String proId);
}
