package com.example.demo.Service.ServiceImpl;

import com.example.demo.Entity.Province;
import com.example.demo.Mapper.ProvinceMapper;
import com.example.demo.Service.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProvinceServiceImpl implements ProvinceService {
    @Autowired
    private ProvinceMapper provinceMapper;

    @Override
    public List<Province> getAllProvince() {
        return provinceMapper.getAllProvince();
    }
}
