package com.GetSet;

import com.google.gson.annotations.SerializedName;

public class usermedicine  {

    @SerializedName("status")
    String status;
    @SerializedName("c_id")
    String c_id;
    @SerializedName("m_id")
    String m_id;
    @SerializedName("m_desc")
    String m_desc;
    @SerializedName("medicine_list")
    String medicine_list;
    @SerializedName("m_date")
    String m_date;
    @SerializedName("month")
    String month;
    @SerializedName("d_name")
    String d_name;
    @SerializedName("d_id")
    String d_id;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getC_id() {
        return c_id;
    }

    public void setC_id(String c_id) {
        this.c_id = c_id;
    }

    public String getM_id() {
        return m_id;
    }

    public void setM_id(String m_id) {
        this.m_id = m_id;
    }

    public String getM_desc() {
        return m_desc;
    }

    public void setM_desc(String m_desc) {
        this.m_desc = m_desc;
    }

    public String getMedicine_list() {
        return medicine_list;
    }

    public void setMedicine_list(String medicine_list) {
        this.medicine_list = medicine_list;
    }

    public String getM_date() {
        return m_date;
    }

    public void setM_date(String m_date) {
        this.m_date = m_date;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getD_name() {
        return d_name;
    }

    public void setD_name(String d_name) {
        this.d_name = d_name;
    }

    public String getD_id() {
        return d_id;
    }

    public void setD_id(String d_id) {
        this.d_id = d_id;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @SerializedName("msg")
    String msg;

}
