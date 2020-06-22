package com.example.demo.Service;

import com.example.demo.Entity.User;
import com.example.demo.Util.BaseParam;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    User login(User user);
    int register(User user);
    //获取所有用户
    List<User> getAllUsers(BaseParam param);
    //查询数据总数
    Integer getAllUsersCounts(BaseParam param);
    //修改用户信息
    int updateUserInfo(User user);
}
