package com.example.demo.Util;

import com.example.demo.Controller.UserController;
import com.example.demo.Entity.ChangeWorkDate;
import com.example.demo.Entity.VacationDate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class CheckdateIsVacationdate {
    private final Logger log = LoggerFactory.getLogger(CheckdateIsVacationdate.class);
    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    private int result = 0;//默认不是节假日

    public int check(List<VacationDate> list1, List<ChangeWorkDate> list2) throws ParseException {
        List<String> strings = new ArrayList<>();
        java.util.Date date = new java.util.Date();
        String now = sdf.format(date);
        log.info("当前时间：" + now);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(sdf.parse(now));
        if (calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY || calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
            result = 0;//result = 0说明是正常周六日
            for (int i = 0; i < list1.size(); i++) {
                String vacationdate = sdf.format(list1.get(i).getVacation_date());
                if (vacationdate.equals(now)) {
                    result = 11;//result = 11说明是法定节假日
                    break;
                }
            }
            for (int i = 0; i < list2.size(); i++) {
                String changeworkdate = sdf.format(list2.get(i).getChangeworkdate_date());
                if (changeworkdate.equals(now)) {
                    result = 12;//result = 12说明是调休工作日
                    break;
                }
            }
        } else {
            result = 1;//result = 1说明是正常工作日
            for (int i = 0; i < list1.size(); i++) {
                String vacationdate = sdf.format(list1.get(i).getVacation_date());
                if (vacationdate.equals(now)) {
                    result = 11;//result = 1说明是法定节假日
                    break;
                }
            }
            for (int i = 0; i < list2.size(); i++) {
                String changeworkdate = sdf.format(list2.get(i).getChangeworkdate_date());
                if (changeworkdate.equals(now)) {
                    result = 12;//result = 12说明是调休工作日
                    break;
                }
            }
        }
        return result;
    }
}
