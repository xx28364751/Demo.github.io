package com.example.demo.Entity;

import java.sql.Date;

public class ChangeWorkDate {
    private int changeworkdate_id;
    private Date changeworkdate_date;

    public int getChangeworkdate_id() {
        return changeworkdate_id;
    }

    public void setChangeworkdate_id(int changeworkdate_id) {
        this.changeworkdate_id = changeworkdate_id;
    }

    public Date getChangeworkdate_date() {
        return changeworkdate_date;
    }

    public void setChangeworkdate_date(Date changeworkdate_date) {
        this.changeworkdate_date = changeworkdate_date;
    }

    @Override
    public String toString() {
        return "ChangeWorkDate{" +
                "changeworkdate_id=" + changeworkdate_id +
                ", changeworkdate_date=" + changeworkdate_date +
                '}';
    }
}
