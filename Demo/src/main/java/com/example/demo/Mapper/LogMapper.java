package com.example.demo.Mapper;

import com.example.demo.Entity.Log;
import com.example.demo.Param.LogParam;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;

@Mapper
public interface LogMapper {
    @SelectProvider(type = LogSQL.class, method = "getAllLogs")
    List<Log> getAllLogs(LogParam logParam);

    @SelectProvider(type = LogSQL.class, method = "getAllLogsCounts")
    Integer getAllLogsCounts(LogParam logParam);

    @Insert("insert into log (operator,operateType,content,ip,status,createTime) values (#{operator},#{operateType},#{content},#{ip},#{status},#{createTime})")
    int addLog(Log log);
}
