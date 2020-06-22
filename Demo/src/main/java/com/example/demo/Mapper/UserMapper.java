package com.example.demo.Mapper;

import com.example.demo.Entity.User;
import com.example.demo.Util.BaseParam;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface UserMapper {
    @Select("select * from user where user_name=#{user_name} and user_pwd=#{user_pwd}")
    User login(User user);

    @Insert("insert into user(user_name,user_pwd,user_telphone) values(#{user_name},#{user_pwd},#{user_telphone})")
    int register(User user);

    @Select("select * from user limit #{beginLine},#{pageSize}")
    List<User> getAllUsers(BaseParam param);

    @Select("select count(*) from user")
    Integer getAllUsersCounts(BaseParam param);

    @Update("update user set user_name=#{user_name},user_pwd=#{user_pwd},user_telphone=#{user_telphone} where user_id=#{user_id}")
    int updateUserInfo(User user);
}
