package com.example.demo.Param;

import com.example.demo.Util.BaseParam;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class ProCityAreaParam extends BaseParam {
    private String provinceNo;
    private String cityNo;
    private String areaNo;

    public String getProvinceNo() {
        return provinceNo;
    }

    public void setProvinceNo(String provinceNo) {
        this.provinceNo = provinceNo;
    }

    public String getCityNo() {
        return cityNo;
    }

    public void setCityNo(String cityNo) {
        this.cityNo = cityNo;
    }

    public String getAreaNo() {
        return areaNo;
    }

    public void setAreaNo(String areaNo) {
        this.areaNo = areaNo;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
