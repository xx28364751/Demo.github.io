package com.example.demo.Entity;

import java.sql.Date;

public class VacationDate {
    private int vacation_id;
    private Date vacation_date;

    public int getVacation_id() {
        return vacation_id;
    }

    public void setVacation_id(int vacation_id) {
        this.vacation_id = vacation_id;
    }

    public Date getVacation_date() {
        return vacation_date;
    }

    public void setVacation_date(Date vacation_date) {
        this.vacation_date = vacation_date;
    }

    @Override
    public String toString() {
        return "CheckVacationService{" +
                "vacation_id=" + vacation_id +
                ", vacation_date=" + vacation_date +
                '}';
    }
}
