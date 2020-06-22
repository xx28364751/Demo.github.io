package com.example.demo.Service.ServiceImpl;

import com.example.demo.Entity.EnumEntity;
import com.example.demo.Entity.Log;
import com.example.demo.Mapper.LogMapper;
import com.example.demo.Param.LogParam;
import com.example.demo.Service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class LogServiceImpl implements LogService {
    @Autowired
    private LogMapper logMapper;

    @Override
    public List<Log> getAllLogs(LogParam logParam) {
        return logMapper.getAllLogs(logParam);
    }

    @Override
    public Integer getAllLogsCounts(LogParam logParam) {
        return logMapper.getAllLogsCounts(logParam);
    }

    @Override
    public int addLog(String username, EnumEntity.OperationTypeEnum operateType, String content, String ip, EnumEntity.StatusEnum status) {
        Log log = new Log();
        log.setOperator(username);
        log.setOperateType(operateType.getValue());
        log.setContent(content);
        log.setIp(ip);
        log.setStatus(status.getValue());
        log.setCreateTime(new Date());
        return logMapper.addLog(log);
    }
}
