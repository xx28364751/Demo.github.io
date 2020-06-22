package com.example.demo.Util;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class ImportVacationDateExcel {
    private final Logger log = LoggerFactory.getLogger(ImportVacationDateExcel.class);
    private ExcelDateTransform edt = new ExcelDateTransform();

    public List<Date> loadexcel(MultipartFile importExcel) {
        List<String> content = new ArrayList();//保存Excel中的数据
        List<Date> dates = null;//保存格式转化后的日期
        Workbook wb = null;
        try {
            wb = WorkbookFactory.create(importExcel.getInputStream());
        } catch (Exception e) {
            e.printStackTrace();
        }
        Sheet sheet = wb.getSheetAt(0);//获取第一张表
        int r = sheet.getLastRowNum() + 1;//获取总行数
        log.info("读入Excel的信息..." + "总行数：" + r);
        for (int i = 1; i < r; i++) {
            content.add(sheet.getRow(i).getCell(0).toString());
        }
        dates = edt.VacationDate(content);
        return dates;
    }
}
