package com.GetSet;

import com.google.gson.annotations.SerializedName;

public class prescdata {

    @SerializedName("status")
    String status;
    @SerializedName("msg")
    String msg;
    @SerializedName("d_id")
    String d_id;

    @SerializedName("u_id")
    String u_id;
    @SerializedName("pre_detail")
    String pre_detail;
    @SerializedName("pre_pic")
    String pre_pic;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getD_id() {
        return d_id;
    }

    public void setD_id(String d_id) {
        this.d_id = d_id;
    }

    public String getU_id() {
        return u_id;
    }

    public void setU_id(String u_id) {
        this.u_id = u_id;
    }

    public String getPre_detail() {
        return pre_detail;
    }

    public void setPre_detail(String pre_detail) {
        this.pre_detail = pre_detail;
    }

    public String getPre_pic() {
        return pre_pic;
    }

    public void setPre_pic(String pre_pic) {
        this.pre_pic = pre_pic;
    }

    public String getPre_date() {
        return pre_date;
    }

    public void setPre_date(String pre_date) {
        this.pre_date = pre_date;
    }

    public String getD_firstname() {
        return d_firstname;
    }

    public void setD_firstname(String d_firstname) {
        this.d_firstname = d_firstname;
    }

    public String getD_contact_info() {
        return d_contact_info;
    }

    public void setD_contact_info(String d_contact_info) {
        this.d_contact_info = d_contact_info;
    }

    public String getC_r_id() {
        return c_r_id;
    }

    public void setC_r_id(String c_r_id) {
        this.c_r_id = c_r_id;
    }

    public String getU_fname() {
        return u_fname;
    }

    public void setU_fname(String u_fname) {
        this.u_fname = u_fname;
    }

    public String getU_phone_no() {
        return u_phone_no;
    }

    public void setU_phone_no(String u_phone_no) {
        this.u_phone_no = u_phone_no;
    }

    @SerializedName("pre_date")
    String pre_date;
    @SerializedName("d_firstname")
    String d_firstname;
    @SerializedName("d_contact_info")
    String d_contact_info;
    @SerializedName("c_r_id")
    String c_r_id;


    @SerializedName("u_fname")
    String u_fname;
    @SerializedName("u_phone_no")
    String u_phone_no;


}
