package com.example.demo.Entity;

public class Province {
    private long id;
    private String provinceNo;
    private String provinceName;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getProvinceNo() {
        return provinceNo;
    }

    public void setProvinceNo(String provinceNo) {
        this.provinceNo = provinceNo;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    @Override
    public String toString() {
        return "Province{" +
                "id=" + id +
                ", provinceNo='" + provinceNo + '\'' +
                ", provinceName='" + provinceName + '\'' +
                '}';
    }
}
