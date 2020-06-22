package com.example.demo.Controller;

import com.example.demo.Entity.EnumEntity;
import com.example.demo.Entity.Log;
import com.example.demo.Entity.Menu;
import com.example.demo.Entity.User;
import com.example.demo.Param.UserParam;
import com.example.demo.Service.LogService;
import com.example.demo.Service.MenuService;
import com.example.demo.Service.UserService;
import com.example.demo.Util.IPUtil;
import com.example.demo.Util.Page;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class UserController {
    private final Logger log = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @Autowired
    private MenuService menuService;

    @Autowired
    private LogService logService;

    /**
     * 用户登录
     */
    @RequestMapping(value = "/login")
    public ModelAndView login(User user, HttpServletRequest request) {
        ModelAndView mav = new ModelAndView("/jsp/index.jsp");
        ModelAndView mav2 = new ModelAndView("/jsp/login.jsp");
        log.info("登录用户为:" + user.getUser_name() + ",密码:" + user.getUser_pwd());
        User user2 = userService.login(user);
        if (user2 == null) {
            log.info("帐号或密码错误");
            mav2.addObject("msg", "02");
            logService.addLog(user2.getUser_name(), EnumEntity.OperationTypeEnum.LOGIN, "帐号或密码错误", IPUtil.getIpAddr(request), EnumEntity.StatusEnum.FAILURE);
            return mav2;
        } else {
            log.info("登录成功，用户信息为:" + user2.toString());
            List<Menu> menuList = menuService.getAllMenusByUser_role(user2.getUser_role());
            HttpSession session = request.getSession();
            Log log = new Log();
            session.setAttribute("userInfo", user2);
            session.setAttribute("menuList", menuList);
            mav.addObject("userInfo", user2);
            mav.addObject("menuList", menuList);
            mav.addObject("msg", "01");
            logService.addLog(user2.getUser_name(), EnumEntity.OperationTypeEnum.LOGIN, "登陆成功", IPUtil.getIpAddr(request), EnumEntity.StatusEnum.SUCCESS);
            return mav;
        }
    }

    /**
     * 用户注册
     */
    @RequestMapping(value = "/registerUser")
    public ModelAndView register(User user) {
        ModelAndView mav = new ModelAndView("/jsp/login.jsp");
        ModelAndView maverr = new ModelAndView("/jsp/register.jsp");
        user.setUser_role(0);//默认角色权限为0
        log.info("注册用户为：" + user.toString());
        int result = userService.register(user);
        if (result == 1) {
            log.info("注册成功");
            mav.addObject("msg", "04");
            return mav;
        } else {
            log.info("注册失败");
            mav.addObject("msg", "05");
            return maverr;
        }
    }

    /**
     * 查询用户信息，结果分页
     */
    @RequestMapping(value = "/getAllUsers")
    public ModelAndView getAllUsers(UserParam param) {
        ModelAndView mav = new ModelAndView("/jsp/userInfopage.jsp");
        log.info("param参数为：" + param.toString());
        List<User> userList = userService.getAllUsers(param);//查询所有用户
        log.info("查询用户结果为：" + userList);
        Integer totalpage = userService.getAllUsersCounts(param);//查询所有用户条数
        log.info("查询用户条数为：" + totalpage);
        mav.addObject("userList", userList);
        param.setBeginLine((param.getCurrentPage() - 1) * param.getPageSize());
        log.info("当前页为：" + param.getCurrentPage() + "起始行为：" + param.getBeginLine());
        Page p = new Page(totalpage, param);
        p.setList(userList);
        p.setCurrentPage(param.getCurrentPage());
        log.info("分页信息为：" + p.toString());
        mav.addObject("page", p);
        return mav;
    }

    /**
     * 跳转到修改用户信息页面
     */
    @RequestMapping(value = "/updateUser")
    public ModelAndView updateUserPage(User userInfo, String flag, HttpServletRequest request) {
        CommonController cc = new CommonController();
        ModelAndView mav = null;
        if (userInfo.getUser_name() == null) {
            mav = new ModelAndView("/jsp/updateUserInfo.jsp");
            HttpSession session = request.getSession();
            User user = (User) session.getAttribute("userInfo");
            mav.addObject("userInfo", user);
            return mav;
        }
        if (flag.equals("1")) {//等于 1 就是修改信息
            userService.updateUserInfo(userInfo);
            mav = cc.start2(userInfo, request);
            mav.addObject("msg", "11");
            logService.addLog(userInfo.getUser_name(), EnumEntity.OperationTypeEnum.UPDATE, "修改密码", IPUtil.getIpAddr(request), EnumEntity.StatusEnum.SUCCESS);
            log.info("修改完毕");
            return mav;
        } else {
            mav = cc.start2(userInfo, request);
            return mav;
        }
    }
}
