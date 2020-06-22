package com.example.demo.Entity;

public class City {
    private long id;
    private String cityNo;
    private String cityName;
    private String provinceNo;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCityNo() {
        return cityNo;
    }

    public void setCityNo(String cityNo) {
        this.cityNo = cityNo;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getProvinceNo() {
        return provinceNo;
    }

    public void setProvinceNo(String provinceNo) {
        this.provinceNo = provinceNo;
    }

    @Override
    public String toString() {
        return "City{" +
                "id=" + id +
                ", cityNo='" + cityNo + '\'' +
                ", cityName='" + cityName + '\'' +
                ", provinceNo='" + provinceNo + '\'' +
                '}';
    }
}
