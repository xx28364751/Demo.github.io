package com.example.demo.Mapper;

import com.example.demo.Entity.VacationDate;
import org.apache.ibatis.annotations.*;

import java.sql.Date;
import java.util.List;

@Mapper
public interface VacationDateMapper {
    @Delete("delete from vacationdate")
    int delete();

    @Insert("insert into vacationdate (vacation_date) values (#{date})")
    int insert(Date date);

    @Select("select * from vacationdate")
    List<VacationDate> selectAllVacationDate();

    @Update("truncate table vacationdate")
    int makezero_id();
}
