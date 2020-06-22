package com.example.demo.Entity;

public class Area {
    private long id;
    private String areaNo;
    private String areaName;
    private String cityNo;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAreaNo() {
        return areaNo;
    }

    public void setAreaNo(String areaNo) {
        this.areaNo = areaNo;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public String getCityNo() {
        return cityNo;
    }

    public void setCityNo(String cityNo) {
        this.cityNo = cityNo;
    }

    @Override
    public String toString() {
        return "Area{" +
                "id=" + id +
                ", areaNo='" + areaNo + '\'' +
                ", areaName='" + areaName + '\'' +
                ", cityNo='" + cityNo + '\'' +
                '}';
    }
}
