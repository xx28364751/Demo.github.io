package com.example.demo.Service.ServiceImpl;

import com.example.demo.Entity.ChangeWorkDate;
import com.example.demo.Mapper.ChangeWorkDateMapper;
import com.example.demo.Service.ChangeWorkDateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

@Service
public class ChangeWorkDateServiceImpl implements ChangeWorkDateService {

    @Autowired
    private ChangeWorkDateMapper changeWorkDateMapper;

    @Override
    public int delete() {
        return changeWorkDateMapper.delete();
    }

    @Override
    public int insert(Date date) {
        return changeWorkDateMapper.insert(date);
    }

    @Override
    public List<ChangeWorkDate> selectAllChangeWorkDate() {
        return changeWorkDateMapper.selectAllChangeWorkDate();
    }

    @Override
    public int makezero_id() {
        return changeWorkDateMapper.makezero_id();
    }
}
