package com.example.demo.Entity;

import com.example.demo.Util.BaseParam;
import lombok.Data;
import org.springframework.util.StringUtils;

import java.util.Date;

@Data
public class Log extends BaseParam {
    private Long id;
    private String operator;
    private EnumEntity.OperationTypeEnum operateType;
    private String content;
    private String ip;
    private EnumEntity.StatusEnum status;
    private Date createTime;
    private String startDate;
    private String endDate;

    public String getOperateType() {
        if (!StringUtils.isEmpty(operateType)) {
            return operateType.getValue();
        }
        return null;
    }

    public void setOperateType(String operateType) {
        if (!StringUtils.isEmpty(operateType)) {
            this.operateType = EnumEntity.OperationTypeEnum.getOperationType(operateType);
        }
    }

    public String getStatus() {
        if (!StringUtils.isEmpty(status)) {
            return status.getValue();
        }
        return null;
    }

    public void setStatus(String status) {
        if (!StringUtils.isEmpty(status)) {
            this.status = EnumEntity.StatusEnum.getStatus(status);
        }
    }
}
