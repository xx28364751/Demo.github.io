package com.example.demo.Service;

import com.example.demo.Entity.VacationDate;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

@Service
public interface VacationDateService {
    //先删除数据库信息
    int delete();
    //再向数据库中插入值
    int insert(Date date);
    //查询数据库
    List<VacationDate> selectAllVacationDate();
    //归零自增id
    int makezero_id();
}
