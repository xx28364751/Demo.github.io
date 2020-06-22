package com.example.demo.Mapper;

import com.example.demo.Entity.ChangeWorkDate;
import org.apache.ibatis.annotations.*;

import java.sql.Date;
import java.util.List;

@Mapper
public interface ChangeWorkDateMapper {
    @Delete("delete from changeworkdate")
    int delete();

    @Insert("insert into changeworkdate (changeworkdate_date) values (#{date})")
    int insert(Date date);

    @Select("select * from changeworkdate")
    List<ChangeWorkDate> selectAllChangeWorkDate();

    @Update("truncate table changeworkdate")
    int makezero_id();
}
