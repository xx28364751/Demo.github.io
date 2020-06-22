package com.example.demo.Service.ServiceImpl;

import com.example.demo.Entity.Menu;
import com.example.demo.Mapper.MenuMapper;
import com.example.demo.Service.MenuService;
import com.example.demo.Util.BaseParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuServiceImpl implements MenuService {
    @Autowired
    private MenuMapper menuMapper;


    @Override
    public List<Menu> getAllMenusByUser_role(int user_role) {
        return menuMapper.getAllMenusByUser_role(user_role);
    }

    @Override
    public List<Menu> getAllMenus(BaseParam param) {
        return menuMapper.getAllMenus(param);
    }

    @Override
    public Integer getAllMenusCounts(BaseParam param) {
        return menuMapper.getAllMenusCounts(param);
    }

    @Override
    public int addMenu(Menu menu) {
        return menuMapper.addMenu(menu);
    }

    @Override
    public int deleteMenu(int menu_id) {
        return menuMapper.deleteMenu(menu_id);
    }

    @Override
    public int updateMenu(Menu menu) {
        return menuMapper.updateMenu(menu);
    }

    @Override
    public Integer findMenusCounts(BaseParam param) {
        return null;
    }
}
