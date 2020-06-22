package com.example.demo.Mapper;

import com.example.demo.Entity.Menu;
import com.example.demo.Util.BaseParam;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface MenuMapper {
    //根据角色权限显示菜单
    @Select("select * from menu where menu_role<=#{user_role}")
    List<Menu> getAllMenusByUser_role(int user_role);

    @Select("select * from menu limit #{beginLine},#{pageSize}")
    List<Menu> getAllMenus(BaseParam param);

    @Select("select count(*) from menu")
    Integer getAllMenusCounts(BaseParam param);

    @Insert("insert into menu (menu_id,menu_href,menu_title,menu_role,menu_remark) values(#{menu_id},#{menu_href},#{menu_title},#{menu_role},#{menu_remark})")
    int addMenu(Menu menu);

    @Delete("delete from menu where menu_id=#{menu_id}")
    int deleteMenu(int menu_id);

    @Update("update menu set menu_href=#{menu_href},menu_title=#{menu_title},menu_role=#{menu_role},menu_remark=#{menu_remark} where menu_id=#{menu_id}")
    int updateMenu(Menu menu);

    @Select("select count(*) from menu where menu_id like '%${menu_id}%' and menu_href like '%${menu_href}%' and menu_title like '%${menu_title}%' and menu_role like '%${menu_role}%'")
    Integer findMenusCounts(BaseParam param);
}
