package com.example.demo.Util;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class ExcelDateTransform {
    private StringchangeInteger si = new StringchangeInteger();
    private List<Date> list = new ArrayList<>();
    private Date date;
    private int day;
    private int month;
    private int year;

    public List<Date> VacationDate(List<String> content) {
        for (int i = 0; i < content.size(); i++) {
            String str = content.get(i);
            if(str.length()==10) {//十月以下
                day = Integer.parseInt(str.substring(0, 2));
                System.out.println(content);
                month = si.trans((str.substring(3, 4)));
                year = Integer.parseInt(str.substring(6, 10));
                String string = year + "-" + month + "-" + day;
                list.add(date.valueOf(string));
            }else{//十月以上
                day = Integer.parseInt(str.substring(0, 2));
                month = si.trans((str.substring(4, 5)));
                year = Integer.parseInt(str.substring(7, 11));
                String string = year + "-1" + month + "-" + day;
                list.add(date.valueOf(string));
            }
        }
        return list;
    }
}
