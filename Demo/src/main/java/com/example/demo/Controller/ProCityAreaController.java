package com.example.demo.Controller;

import com.example.demo.Dto.ProCityArea;
import com.example.demo.Entity.Area;
import com.example.demo.Entity.City;
import com.example.demo.Entity.Province;
import com.example.demo.Entity.User;
import com.example.demo.Service.AreaService;
import com.example.demo.Service.CityService;
import com.example.demo.Service.ProvinceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class ProCityAreaController {
    private final Logger log = LoggerFactory.getLogger(ProCityAreaController.class);

    @Autowired
    private ProvinceService provinceService;

    @Autowired
    private CityService cityService;

    @Autowired
    private AreaService areaService;

    /**
     * 跳转到地区页面
     */
    @RequestMapping(value = "/areapage")
    public ModelAndView toProCityAreapage(HttpServletRequest request) {
        ModelAndView mav = new ModelAndView("/jsp/areapage.jsp");
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("userInfo");
        mav.addObject("userInfo", user);
        return mav;
    }

    /**
     * 保存个人地区信息
     */
    @RequestMapping(value = "/saveProCityArea")
    public ModelAndView saveProCityArea(int user_id, ProCityArea proCityArea) {
        ModelAndView mav = new ModelAndView("/jsp/areapage.jsp");
        log.info("用户ID为：" + user_id + "，用户地区信息为：" + proCityArea.toString());
        //插入数据库操作//暂无
        return mav;
    }

    /**
     * 查询省份信息列表
     */
    @RequestMapping("/getProvinceList")
    @ResponseBody
    public List<Province> getProvinceList() {
        List<Province> provonceList = provinceService.getAllProvince();
        return provonceList;
    }

    /**
     * 根据省的编号获得市
     */
    @RequestMapping("/getCityByProNo")
    @ResponseBody
    public List<City> getCityByProNo(String provinceNo, HttpServletResponse response) {
        List<City> cityList = new ArrayList<>();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("proId", provinceNo);
        try {
            cityList = cityService.getCityByProId(provinceNo);
        } catch (Exception e) {
            log.error("getCityByProNo Exception:", e);
        }
        return cityList;
    }

    /**
     * 根据市的编号获取区域
     */
    @RequestMapping("/getAreaByCityNo")
    @ResponseBody
    public List<Area> getAreaByCityNo(String cityNo, HttpServletResponse response) {
        List<Area> areaList = new ArrayList<>();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("cityNo", cityNo);
        try {
            areaList = areaService.getAreaByCityNo(cityNo);
        } catch (Exception e) {
            log.error("getCityByProNo Exception:", e);
        }
        return areaList;
    }

    /**
     * 根据省的编号获得市--Ajax
     */
    @RequestMapping(value = "/getAllProvince_ajax")
    @ResponseBody
    public List<Province> getAllProvince_ajax(HttpServletRequest request, HttpServletResponse response) {
        return provinceService.getAllProvince();
    }

    /**
     * 根据省的编号获得市--Ajax
     */
    @RequestMapping(value = "/getCityByProNo_ajax")
    @ResponseBody
    public List<City> getCityByProNo_ajax(String provNo, HttpServletRequest request, HttpServletResponse response) {
        return cityService.getCityByProId(provNo);
    }

    /**
     * 根据市的编号获取区域--Ajax
     */
    @RequestMapping(value = "/getAreaByCityNo_ajax")
    @ResponseBody
    public List<Area> getAreaByCityNo_ajax(String cityCode, HttpServletRequest request, HttpServletResponse response) {
        return areaService.getAreaByCityNo(cityCode);
    }
}