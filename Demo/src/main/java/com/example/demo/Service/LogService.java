package com.example.demo.Service;

import com.example.demo.Entity.EnumEntity;
import com.example.demo.Entity.Log;
import com.example.demo.Param.LogParam;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface LogService {
    List<Log> getAllLogs(LogParam logParam);

    Integer getAllLogsCounts(LogParam logParam);

    int addLog(String username, EnumEntity.OperationTypeEnum operateType, String content, String ip, EnumEntity.StatusEnum status);
}
