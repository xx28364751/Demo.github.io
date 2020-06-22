package com.example.demo.Controller;

import com.example.demo.Entity.ChangeWorkDate;
import com.example.demo.Entity.VacationDate;
import com.example.demo.Service.ChangeWorkDateService;
import com.example.demo.Service.VacationDateService;
import com.example.demo.Util.CheckdateIsVacationdate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class CheckVacationDateController {
    private Map<String, Object> map = new HashMap<String, Object>();
    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    @Autowired
    private VacationDateService vacationDateService;

    @Autowired
    private ChangeWorkDateService changeWorkDateService;

    /**
     * 判断今天是否是节假日
     */
    @ResponseBody
    @RequestMapping(value = "/checkdateIsvacationdate")
    public Map<String, Object> checkdateIsvacationdate() throws ParseException {
        CheckdateIsVacationdate civ = new CheckdateIsVacationdate();
        List<VacationDate> list1 = vacationDateService.selectAllVacationDate();//休息日
        List<ChangeWorkDate> list2 = changeWorkDateService.selectAllChangeWorkDate();//调休日
        int result = civ.check(list1, list2);//异常捕获throws ParseException
        if (result == 0) {//正常周末
            map.put("re", "0");
        } else if (result == 1) {//正常工作日
            map.put("re", "1");
        } else if (result == 11) {//法定节假日
            map.put("re", "11");
        } else {//调休工作日
            map.put("re", "12");
        }
        return map;
    }
}
