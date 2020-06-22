package com.example.demo.Service.ServiceImpl;

import com.example.demo.Entity.VacationDate;
import com.example.demo.Mapper.VacationDateMapper;
import com.example.demo.Service.VacationDateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

@Service
public class VacationDateServiceImpl implements VacationDateService {

    @Autowired
    private VacationDateMapper checkVacationServiceMapper;

    @Override
    public int delete() {
        return checkVacationServiceMapper.delete();
    }

    @Override
    public int insert(Date date) {
        return checkVacationServiceMapper.insert(date);
    }

    @Override
    public List<VacationDate> selectAllVacationDate() {
        return checkVacationServiceMapper.selectAllVacationDate();
    }

    @Override
    public int makezero_id() {
        return checkVacationServiceMapper.makezero_id();
    }
}
