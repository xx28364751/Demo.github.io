package com.example.demo.Controller;

import com.example.demo.Entity.Log;
import com.example.demo.Param.LogParam;
import com.example.demo.Service.ServiceImpl.LogServiceImpl;
import com.example.demo.Util.Page;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class LogController {
    private static final Logger logger = LoggerFactory.getLogger(LogController.class);
    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    @Autowired
    private LogServiceImpl logService;

    /**
     * 查询操作日志，结果并分页
     */
    @RequestMapping(value = "/getAllLogs")
    public ModelAndView toencryptAnddecrypt(LogParam logParam) {
        ModelAndView mav = new ModelAndView("/jsp/logs.jsp");
        List<Log> logList = logService.getAllLogs(logParam);
        Integer totalpage = logService.getAllLogsCounts(logParam);
        logParam.setStartDate(sdf.format(new Date()));
        logParam.setEndDate(sdf.format(new Date()));
        Page page = new Page(0, logParam);
        page = new Page(totalpage, logParam);
        page.setList(logList);
        mav.addObject("page", page);
        return mav;
    }
}
