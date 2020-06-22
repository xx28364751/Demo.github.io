package com.example.demo.Entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @Description
 * @Author mpq
 * @Date 2020/6/18 13:56
 */
@Data
@NoArgsConstructor
public class Weather {
    private String cityid;
    private String date;
    private String week;
    private String update_time;
    private String city;
    private String country;
    private String wea;
    private String tem;
    private String tem1;
    private String tem2;
    private String win;
    private String win_speed;
    private String win_meter;
    private String humidity;
    private String visibility;
    private String pressure;
    private String air;
    private String air_pm25;
    private String air_level;
    private String air_tips;
}
