package com.example.demo.Controller;

import cn.hutool.http.HttpRequest;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.demo.Entity.User;
import com.example.demo.Entity.Weather;
import com.example.demo.Service.AreaService;
import com.google.gson.Gson;
import org.apache.commons.lang3.StringUtils;
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
import java.util.Map;

/**
 * @Description
 * @Author mpq
 * @Date 2020/6/18 13:05
 */
@Controller
public class WeatherController {
    private static final Logger logger = LoggerFactory.getLogger(WeatherController.class);

    private Gson gson = new Gson();
    private final static String URL = "https://yiketianqi.com/api?";
    private final static String VERSION = "v61";
    private final static String APPID = "21334444";
    private final static String APPSECRET = "PcODzXy1";

    @Autowired
    private AreaService areaService;

    /**
     * 跳转到天气预报页面
     */
    @RequestMapping(value = "/weather")
    public ModelAndView toProCityAreapage(HttpServletRequest request) {
        ModelAndView mav = new ModelAndView("/jsp/weather.jsp");
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("userInfo");
        mav.addObject("userInfo", user);
        return mav;
    }

    /**
     * 根据城市ID查询天气预报
     */
    @ResponseBody
    @RequestMapping(value = "/getWeatherInfoByAreaId")
    public Map<String, Object> getWeatherInfoByCityId(String areaCode) {
        Map<String, Object> map = new HashMap<String, Object>();
        String name = "";
        if (areaCode != null && StringUtils.isNotBlank(areaCode)) {
            name = areaService.getAreaByAreaNo(areaCode);
            if (name != null && StringUtils.isNotBlank(name)) {
                name = name.substring(0, name.length() - 1);
            }
        }
        Integer cityId = areaService.getAreaNumberByAreaName(name);
        System.out.println(cityId);
        if (cityId != null) {
            HttpRequest request = HttpRequest.get(URL + "version=" + VERSION + "&appid=" + APPID + "&appsecret=" + APPSECRET + "&cityid=" + cityId);
            String result = request.execute().body();
            JSONObject jsonObject = JSON.parseObject(result);
            Weather weather = gson.fromJson(jsonObject.toString(), Weather.class);
            map.put("data", weather);
            map.put("re", "51");
        } else {
            map.put("re", "50");
        }
        return map;
    }
}
