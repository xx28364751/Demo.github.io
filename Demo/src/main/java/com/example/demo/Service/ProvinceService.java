package com.example.demo.Service;

import com.example.demo.Entity.Province;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProvinceService {
    //查询所有省份
    public List<Province> getAllProvince();
}
