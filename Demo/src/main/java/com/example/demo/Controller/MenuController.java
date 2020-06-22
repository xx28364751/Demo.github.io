package com.example.demo.Controller;

import cn.hutool.http.HttpRequest;
import com.example.demo.Entity.EnumEntity;
import com.example.demo.Entity.Menu;
import com.example.demo.Entity.User;
import com.example.demo.Param.MenuParam;
import com.example.demo.Service.LogService;
import com.example.demo.Service.MenuService;
import com.example.demo.Util.IPUtil;
import com.example.demo.Util.Page;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class MenuController {
    private final Logger log = LoggerFactory.getLogger(MenuController.class);

    @Autowired
    private MenuService menuService;

    @Autowired
    private LogService logService;

    /**
     * 查询Menu信息，结果分页
     */
    @RequestMapping(value = "/getAllMenus")
    public ModelAndView getAllMenus(MenuParam param) {
        ModelAndView mav = new ModelAndView("/jsp/menupage.jsp");
        List<Menu> menuList = menuService.getAllMenus(param);
        Integer totalpage = menuService.getAllMenusCounts(param);
        mav.addObject("menuList", menuList);
        param.setBeginLine((param.getCurrentPage() - 1) * param.getPageSize());
        Page p = new Page(totalpage, param);
        p.setList(menuList);
        p.setCurrentPage(param.getCurrentPage());
        mav.addObject("page", p);
        return mav;
    }

    /**
     * 跳转添加Menu页面
     */
    @RequestMapping(value = "/addMenupage")
    public ModelAndView toaddMenupage() {
        ModelAndView mav = new ModelAndView("/jsp/menuadd.jsp");
        return mav;
    }

    /**
     * 添加Menu
     */
    @RequestMapping(value = "/addMenu")
    @ResponseBody
    public Map<String, Object> addMenu(HttpServletRequest request, MenuParam param) {
        Map<String, Object> map = new HashMap<String, Object>();
        Menu menu = new Menu();
        menu.setMenu_id(param.getMenu_id());
        menu.setMenu_href(param.getMenu_href());
        menu.setMenu_title(param.getMenu_title());
        menu.setMenu_role(param.getMenu_role());
        menu.setMenu_remark(param.getMenu_remark());
        int result = menuService.addMenu(menu);
        if (result != 0) {
            map.put("re", "40");
            String username = ((User) request.getSession().getAttribute("userInfo")).getUser_name();
            logService.addLog(username, EnumEntity.OperationTypeEnum.ADD, "添加菜单", IPUtil.getIpAddr(request), EnumEntity.StatusEnum.SUCCESS);
        }
        return map;
    }

    /**
     * 删除Menu
     */
    @RequestMapping(value = "/deleteMenu")
    @ResponseBody
    public Map<String, Object> deleteMenu(HttpServletRequest request, Integer menu_id) {
        String username = ((User) request.getSession().getAttribute("userInfo")).getUser_name();
        Map<String, Object> map = new HashMap<String, Object>();
        int result = menuService.deleteMenu(menu_id);
        if (result != 0) {
            map.put("re", "41");
            logService.addLog(username, EnumEntity.OperationTypeEnum.DELETE, "删除菜单", IPUtil.getIpAddr(request), EnumEntity.StatusEnum.SUCCESS);
        } else {
            map.put("re", "42");
            logService.addLog(username, EnumEntity.OperationTypeEnum.DELETE, "删除菜单", IPUtil.getIpAddr(request), EnumEntity.StatusEnum.FAILURE);
        }
        return map;
    }

    /**
     * 跳转到修改Menu页面
     */
    @RequestMapping(value = "/toUpdateMenu")
    public ModelAndView toUpdateMenu(Menu menu) {
        ModelAndView mav = new ModelAndView("/jsp/menuadd.jsp");
        mav.addObject("menu", menu);
        mav.addObject("flag", 2);
        return mav;
    }

    /**
     * 修改Menu
     */
    @RequestMapping(value = "/updateMenu")
    @ResponseBody
    public Map<String, Object> updateMenu(HttpServletRequest request, Menu menu) {
        String username = ((User) request.getSession().getAttribute("userInfo")).getUser_name();
        Map<String, Object> map = new HashMap<String, Object>();
        int result = menuService.updateMenu(menu);
        if (result != 0) {
            map.put("re", "11");
            logService.addLog(username, EnumEntity.OperationTypeEnum.UPDATE, "修改菜单", IPUtil.getIpAddr(request), EnumEntity.StatusEnum.SUCCESS);
        } else {
            map.put("re", "12");
            logService.addLog(username, EnumEntity.OperationTypeEnum.UPDATE, "修改菜单", IPUtil.getIpAddr(request), EnumEntity.StatusEnum.FAILURE);
        }
        return map;
    }
}
