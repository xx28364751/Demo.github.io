package com.example.demo.Mapper;

import com.example.demo.Param.LogParam;
import org.apache.commons.lang3.StringUtils;

public class LogSQL {
    public String getAllLogs(LogParam logParam) {
        StringBuilder sqlbuilder = new StringBuilder("select * from log where 1=1");
        if (StringUtils.isNotEmpty(logParam.getOperator())) {
            sqlbuilder.append(" and operator=#{operator}");
        }
        if (StringUtils.isNotEmpty(logParam.getOperateType())) {
            sqlbuilder.append(" and operateType=#{operateType}");
        }
        if (StringUtils.isNotEmpty(logParam.getStartDate())) {
            String startDate = logParam.getStartDate() + " 00:00:00";
            sqlbuilder.append(" and createTime>='" + startDate + "'");
        }
        if (StringUtils.isNotEmpty(logParam.getEndDate())) {
            String endDate = logParam.getEndDate() + " 23:59:59";
            sqlbuilder.append(" and createTime<='" + endDate + "'");
        }
        sqlbuilder.append(" order by createTime desc limit #{beginLine},#{pageSize}");
        return sqlbuilder.toString();
    }

    public String getAllLogsCounts(LogParam logParam) {
        StringBuilder sqlbuilder = new StringBuilder("select count(id) from log where 1=1");
        if (StringUtils.isNotEmpty(logParam.getOperator())) {
            sqlbuilder.append(" and operator=#{operator}");
        }
        if (StringUtils.isNotEmpty(logParam.getOperateType())) {
            sqlbuilder.append(" and operateType=#{operateType}");
        }
        if (StringUtils.isNotEmpty(logParam.getStartDate())) {
            String startDate = logParam.getStartDate() + " 00:00:00";
            sqlbuilder.append(" and createTime>='" + startDate + "'");
        }
        if (StringUtils.isNotEmpty(logParam.getEndDate())) {
            String endDate = logParam.getEndDate() + " 23:59:59";
            sqlbuilder.append(" and createTime<='" + endDate + "'");
        }
        return sqlbuilder.toString();
    }
}
