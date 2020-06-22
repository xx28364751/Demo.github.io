package com.example.demo.Service;

import com.example.demo.Entity.Area;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AreaService {
    //查询所有县
    public List<Area> getAllArea();

    //根据城市编号获取区域列表
    public List<Area> getAreaByCityNo(String cityNo);

    //根据区域编号获取区域名字
    public String getAreaByAreaNo(String areaNo);

    //根据区域名字获取区域编号--weather用
    public Integer getAreaNumberByAreaName(String name);
}
