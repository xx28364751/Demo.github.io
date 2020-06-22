package com.example.demo.Controller;

import com.example.demo.Entity.Menu;
import com.example.demo.Entity.User;
import com.example.demo.Param.UserParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class CommonController {
    private final Logger log = LoggerFactory.getLogger(CommonController.class);

    @ResponseBody
    @RequestMapping(value = "/hello")
    public String index() {
        return "Hello World";
    }

    /**
     * 默认URL访问登陆页
     */
    @RequestMapping(value = "/")
    public String login() {
        return "/jsp/login.jsp";
    }

    /**
     * 跳转注册页面
     */
    @RequestMapping(value = "/register")
    public String register() {
        return "/jsp/register.jsp";
    }

    /**
     * 跳转登录页面
     */
    @RequestMapping(value = "/loginpage")
    public String login2() {
        return "/jsp/login.jsp";
    }

    /**
     * 返回主页：默认
     */
    @RequestMapping(value = "/index")
    public ModelAndView start1(HttpServletRequest request) {
        ModelAndView mav = new ModelAndView("/jsp/index.jsp");
        HttpSession session = request.getSession();
        session.removeAttribute("dates");
        List<Menu> menuList = (List<Menu>) session.getAttribute("menuList");
        User user = (User) session.getAttribute("userInfo");
        mav.addObject("userInfo", user);
        mav.addObject("menuList", menuList);
        log.info("返回主页ing...");
        return mav;
    }

    /**
     * 返回主页2：修改信息
     */
    @RequestMapping(value = "/index2")
    public ModelAndView start2(User user, HttpServletRequest request) {
        ModelAndView mav = new ModelAndView("/jsp/index.jsp");
        HttpSession session = request.getSession();
        session.removeAttribute("dates");
        session.removeAttribute("userInfo");
        session.setAttribute("userInfo", user);
        mav.addObject("userInfo", user);
        return mav;
    }

    /**
     * 退出登录，清除登录信息
     */
    @RequestMapping(value = "/loginOut")
    public ModelAndView loginOut(HttpServletRequest request) {
        ModelAndView mav = new ModelAndView("/jsp/login.jsp");
        HttpSession session = request.getSession();
        session.removeAttribute("userInfo");
        log.info("退出登录ing...");
        mav.addObject("msg", "03");
        return mav;
    }
}
