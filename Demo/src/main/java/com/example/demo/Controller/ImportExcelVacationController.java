package com.example.demo.Controller;

import com.example.demo.Entity.ChangeWorkDate;
import com.example.demo.Entity.VacationDate;
import com.example.demo.Service.ChangeWorkDateService;
import com.example.demo.Service.VacationDateService;
import com.example.demo.Util.ImportVacationDateExcel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.Date;
import java.util.List;

@Controller
public class ImportExcelVacationController {
    private final Logger log = LoggerFactory.getLogger(ImportExcelVacationController.class);

    @Autowired
    private VacationDateService vacationDateService;

    @Autowired
    private ChangeWorkDateService changeWorkDateService;

    /**
     * 跳转到导入Excel的页面：法定节假日
     */
    @RequestMapping(value = "/importexcelpagevacationdate")
    public ModelAndView upvacationdate() {
        ModelAndView mav = new ModelAndView("/jsp/upvacationdate.jsp");
        return mav;
    }

    /**
     * 跳转到导入Excel的页面：调休工作日
     */
    @RequestMapping(value = "/importexcelpageworkdate")
    public ModelAndView upworkdate() {
        ModelAndView mav = new ModelAndView("/jsp/upworkdate.jsp");
        return mav;
    }

    /**
     * 导入Excel中的日期数据
     */
    @RequestMapping(value = "/importExcel")
    public ModelAndView inputExcel(MultipartFile importExcel, String flag, HttpServletRequest request) {
        ModelAndView mav1 = new ModelAndView("/jsp/upvacationdate.jsp");
        ModelAndView mav2 = new ModelAndView("/jsp/upworkdate.jsp");
        ImportVacationDateExcel ivde = new ImportVacationDateExcel();
        String filetype = importExcel.getOriginalFilename();
        log.info("flag=" + flag + "文件名字为：" + importExcel.getOriginalFilename() + "文件大小为：" + importExcel.getSize());
        if (importExcel.isEmpty()) {
            log.info("导入文件为空");
            if (flag.equals("0")) {//导入节假日Date为空
                request.setAttribute("msg", "20");
                return mav1;
            } else {//导入调休日Date为空
                request.setAttribute("msg", "20");
                return mav2;
            }
        } else if (filetype.endsWith(".xlsx") || filetype.endsWith(".xls")) {
            try {
                List<Date> dates = ivde.loadexcel(importExcel);//导入文件
                HttpSession session = request.getSession();
                session.setAttribute("dates", dates);
                request.setAttribute("msg", "29");
                if (flag.equals("0")) {
                    mav1.addObject("dates", dates);
                } else {
                    mav2.addObject("dates", dates);
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                log.info("读取数据完毕");
            }
        } else {
            log.info("导入文件类型不是Excel");
            request.setAttribute("msg", "21");
        }
        if (flag.equals("0")) {
            return mav1;
        } else {
            return mav2;
        }
    }

    /**
     * 查询数据库所有法定节假日的日期数据
     */
    @RequestMapping(value = "/selectAllVacationDate")
    public ModelAndView selectAllVacationDate(HttpServletRequest request) {
        ModelAndView mav = new ModelAndView("/jsp/upvacationdate.jsp");
        HttpSession session = request.getSession();
        List<Date> list1 = (List<Date>) session.getAttribute("dates");
        mav.addObject("msg", "29");
        mav.addObject("dates", list1);
        List<VacationDate> list2 = vacationDateService.selectAllVacationDate();
        if (list2.size() == 0) {
            request.setAttribute("msgs", "30");
        }
        mav.addObject("dates2", list2);
        return mav;
    }

    /**
     * 查询数据库所有调休工作日的日期数据
     */
    @RequestMapping(value = "/selectAllChangeWorkDate")
    public ModelAndView selectAllChangeWorkDate(HttpServletRequest request) {
        ModelAndView mav = new ModelAndView("/jsp/upworkdate.jsp");
        HttpSession session = request.getSession();
        List<Date> list1 = (List<Date>) session.getAttribute("dates");
        mav.addObject("msg", "29");
        mav.addObject("dates", list1);
        List<ChangeWorkDate> list2 = changeWorkDateService.selectAllChangeWorkDate();
        if (list2.size() == 0) {
            request.setAttribute("msgs", "30");
        }
        mav.addObject("dates2", list2);
        return mav;
    }

    /**
     * 把从Excel中导出的法定节假日的日期，存到数据库中
     */
    @RequestMapping(value = "/updateVacationDate")
    public ModelAndView updateVacationDate(HttpServletRequest request) {
        ModelAndView mav = new ModelAndView("/jsp/upvacationdate.jsp");
        HttpSession session = request.getSession();
        List<Date> list = (List<Date>) session.getAttribute("dates");
        session.removeAttribute("dates");
        log.info("开始更新数据库...");
        vacationDateService.delete();//删除数据库原有数据
        vacationDateService.makezero_id();//自增id归零
        for (int i = 0; i < list.size(); i++) {
            vacationDateService.insert(list.get(i));
        }
        log.info("更新数据库数据完毕");
        mav.addObject("dates", list);
        request.setAttribute("msg", "28");
        session.setAttribute("dates", list);
        return mav;
    }

    /**
     * 把从Excel中导出的调休工作日的日期，存到数据库中
     */
    @RequestMapping(value = "/updateChangeWorkDate")
    public ModelAndView updateChangeWorkDate(HttpServletRequest request) {
        ModelAndView mav = new ModelAndView("/jsp/upworkdate.jsp");
        HttpSession session = request.getSession();
        List<Date> list = (List<Date>) session.getAttribute("dates");
        session.removeAttribute("dates");
        log.info("开始更新数据库...");
        changeWorkDateService.delete();//删除数据库原有数据
        changeWorkDateService.makezero_id();//自增id归零
        for (int i = 0; i < list.size(); i++) {
            changeWorkDateService.insert(list.get(i));
        }
        log.info("更新数据库数据完毕");
        mav.addObject("dates", list);
        request.setAttribute("msg", "28");
        session.setAttribute("dates", list);
        return mav;
    }
}
