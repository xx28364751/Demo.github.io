package com.example.demo.Mapper;

import com.example.demo.Entity.City;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CityMapper {
    @Select("select * from common_city")
    public List<City> getAllCity();

    @Select("select * from common_city where provinceNo = #{proId}")
    public List<City> getCityByProId(String proId);
}
