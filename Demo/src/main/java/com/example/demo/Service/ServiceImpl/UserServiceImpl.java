package com.example.demo.Service.ServiceImpl;

import com.example.demo.Entity.User;
import com.example.demo.Mapper.UserMapper;
import com.example.demo.Service.UserService;
import com.example.demo.Util.BaseParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User login(User user) {
        return userMapper.login(user);
    }

    @Override
    public int register(User user) {
        return userMapper.register(user);
    }

    @Override
    public List<User> getAllUsers(BaseParam param) {
        return userMapper.getAllUsers(param);
    }

    @Override
    public Integer getAllUsersCounts(BaseParam param) {
        return userMapper.getAllUsersCounts(param);
    }

    @Override
    public int updateUserInfo(User user) {
        return userMapper.updateUserInfo(user);
    }
}
