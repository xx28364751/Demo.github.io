package com.example.demo.Entity;

public class Msg {
    private int msg_id;
    private String msg_info;
    private String msg_code;
    private String msg_remark;

    public int getMsg_id() {
        return msg_id;
    }

    public void setMsg_id(int msg_id) {
        this.msg_id = msg_id;
    }

    public String getMsg_info() {
        return msg_info;
    }

    public void setMsg_info(String msg_info) {
        this.msg_info = msg_info;
    }

    public String getMsg_code() {
        return msg_code;
    }

    public void setMsg_code(String msg_code) {
        this.msg_code = msg_code;
    }

    public String getMsg_remark() {
        return msg_remark;
    }

    public void setMsg_remark(String msg_remark) {
        this.msg_remark = msg_remark;
    }

    @Override
    public String toString() {
        return "Msg{" +
                "msg_id=" + msg_id +
                ", msg_info='" + msg_info + '\'' +
                ", msg_code='" + msg_code + '\'' +
                ", msg_remark='" + msg_remark + '\'' +
                '}';
    }
}
