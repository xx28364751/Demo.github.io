package com.example.demo.Service;

import com.example.demo.Entity.Menu;
import com.example.demo.Util.BaseParam;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MenuService {
    //根据角色权限显示菜单
    List<Menu> getAllMenusByUser_role(int user_role);

    //查询菜单
    List<Menu> getAllMenus(BaseParam param);

    Integer getAllMenusCounts(BaseParam param);

    int addMenu(Menu menu);

    int deleteMenu(int menu_id);

    int updateMenu(Menu menu);

    Integer findMenusCounts(BaseParam param);
}
