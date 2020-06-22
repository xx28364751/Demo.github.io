package com.example.demo.Service.ServiceImpl;

import com.example.demo.Entity.Area;
import com.example.demo.Mapper.AreaMapper;
import com.example.demo.Service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AreaServiceImpl implements AreaService {
    @Autowired
    private AreaMapper areaMapper;

    @Override
    public List<Area> getAllArea() {
        return areaMapper.getAllArea();
    }

    @Override
    public List<Area> getAreaByCityNo(String cityNo) {
        return areaMapper.getAreaByCityNo(cityNo);
    }

    @Override
    public String getAreaByAreaNo(String areaNo) {
        return areaMapper.getAreaByAreaNo(areaNo);
    }

    @Override
    public Integer getAreaNumberByAreaName(String name) {
        return areaMapper.getAreaNumberByAreaName(name);
    }
}
