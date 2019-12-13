package com.GetSet;

import com.google.gson.annotations.SerializedName;

public class appionmentdata {

    @SerializedName("d_a_id")
    String d_a_id;
    @SerializedName("d_id")
    String d_id;
    @SerializedName("c_id")
    String c_id;
    @SerializedName("a_status")
    String a_status;

    @SerializedName("u_phone_no")
    String u_phone_no;

    public String getU_phone_no() {
        return u_phone_no;
    }

    public void setU_phone_no(String u_phone_no) {
        this.u_phone_no = u_phone_no;
    }

    public String getU_fname() {
        return u_fname;
    }

    public void setU_fname(String u_fname) {
        this.u_fname = u_fname;
    }

    @SerializedName("u_fname")
    String u_fname;

    public String getD_a_id() {
        return d_a_id;
    }

    public void setD_a_id(String d_a_id) {
        this.d_a_id = d_a_id;
    }

    public String getD_id() {
        return d_id;
    }

    public void setD_id(String d_id) {
        this.d_id = d_id;
    }

    public String getC_id() {
        return c_id;
    }

    public void setC_id(String c_id) {
        this.c_id = c_id;
    }

    public String getA_status() {
        return a_status;
    }

    public void setA_status(String a_status) {
        this.a_status = a_status;
    }

    public String getA_date() {
        return a_date;
    }

    public void setA_date(String a_date) {
        this.a_date = a_date;
    }

    public String getA_time() {
        return a_time;
    }

    public void setA_time(String a_time) {
        this.a_time = a_time;
    }

    public String getA_cdate() {
        return a_cdate;
    }

    public void setA_cdate(String a_cdate) {
        this.a_cdate = a_cdate;
    }

    @SerializedName("a_date")
    String a_date;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @SerializedName("status")
    String status;
    @SerializedName("a_time")
    String a_time;
    @SerializedName("a_cdate")
    String a_cdate;

    @SerializedName("d_firstname")
    String d_firstname;
    @SerializedName("d_contact_info")
    String d_contact_info;

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
}
