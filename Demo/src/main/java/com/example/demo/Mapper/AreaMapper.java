package com.example.demo.Mapper;

import com.example.demo.Entity.Area;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface AreaMapper {
    @Select("select * from common_area")
    public List<Area> getAllArea();

    @Select("select * from common_area where cityNo = #{cityNo}")
    public List<Area> getAreaByCityNo(String cityNo);

    @Select("select areaName from common_area where areaNo = #{areaNo}")
    public String getAreaByAreaNo(String areaNo);

    @Select("select number from weather_citynum where name = #{name}")
    public Integer getAreaNumberByAreaName(String name);
}
