package com.GetSet;

import com.google.gson.annotations.SerializedName;

public class medical {

    @SerializedName("status")
    String status;
    @SerializedName("m_s_name")
    String m_s_name;
    @SerializedName("m_id")
    String m_id;
    @SerializedName("m_s_email")
    String m_s_email;

    @SerializedName("m_s_address")
    String m_s_address;
    @SerializedName("m_s_phone_no")
    String m_s_phone_no;
    @SerializedName("m_s_city")
    String m_s_city;
    @SerializedName("m_s_pincode")
    String m_s_pincode;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getM_s_name() {
        return m_s_name;
    }

    public void setM_s_name(String m_s_name) {
        this.m_s_name = m_s_name;
    }

    public String getM_id() {
        return m_id;
    }

    public void setM_id(String m_id) {
        this.m_id = m_id;
    }

    public String getM_s_email() {
        return m_s_email;
    }

    public void setM_s_email(String m_s_email) {
        this.m_s_email = m_s_email;
    }

    public String getM_s_address() {
        return m_s_address;
    }

    public void setM_s_address(String m_s_address) {
        this.m_s_address = m_s_address;
    }

    public String getM_s_phone_no() {
        return m_s_phone_no;
    }

    public void setM_s_phone_no(String m_s_phone_no) {
        this.m_s_phone_no = m_s_phone_no;
    }

    public String getM_s_city() {
        return m_s_city;
    }

    public void setM_s_city(String m_s_city) {
        this.m_s_city = m_s_city;
    }

    public String getM_s_pincode() {
        return m_s_pincode;
    }

    public void setM_s_pincode(String m_s_pincode) {
        this.m_s_pincode = m_s_pincode;
    }

    public String getM_s_regno() {
        return m_s_regno;
    }

    public void setM_s_regno(String m_s_regno) {
        this.m_s_regno = m_s_regno;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getM_s_starttime() {
        return m_s_starttime;
    }

    public void setM_s_starttime(String m_s_starttime) {
        this.m_s_starttime = m_s_starttime;
    }

    public String getM_s_endtime() {
        return m_s_endtime;
    }

    public void setM_s_endtime(String m_s_endtime) {
        this.m_s_endtime = m_s_endtime;
    }

    public String getM_s_status() {
        return m_s_status;
    }

    public void setM_s_status(String m_s_status) {
        this.m_s_status = m_s_status;
    }

    @SerializedName("m_s_regno")
    String m_s_regno;
  @SerializedName("msg")
    String msg;


    @SerializedName("m_s_starttime")
    String m_s_starttime;
    @SerializedName("m_s_endtime")
    String m_s_endtime;
    @SerializedName("m_s_status")
    String m_s_status;

}
