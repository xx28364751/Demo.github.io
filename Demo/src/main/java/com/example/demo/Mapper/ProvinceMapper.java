package com.example.demo.Mapper;

import com.example.demo.Entity.Province;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ProvinceMapper {
    @Select("select * from common_province")
    public List<Province> getAllProvince();
}
