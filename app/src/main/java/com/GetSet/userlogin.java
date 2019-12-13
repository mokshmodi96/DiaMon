package com.GetSet;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class userlogin{

    @SerializedName("status")
    String status;
    @SerializedName("msg")
    String msg;
    @SerializedName("u_id")
    String u_id;
    @SerializedName("u_fname")
    String u_fname;
    @SerializedName("u_lname")
    String u_lname;
    @SerializedName("u_email")
    String u_email;

    public String getP_r_status() {
        return p_r_status;
    }

    public void setP_r_status(String p_r_status) {
        this.p_r_status = p_r_status;
    }

    @SerializedName("p_r_status")
    String p_r_status;

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

    public String getU_id() {
        return u_id;
    }

    public void setU_id(String u_id) {
        this.u_id = u_id;
    }

    public String getU_fname() {
        return u_fname;
    }

    public void setU_fname(String u_fname) {
        this.u_fname = u_fname;
    }

    public String getU_lname() {
        return u_lname;
    }

    public void setU_lname(String u_lname) {
        this.u_lname = u_lname;
    }

    public String getU_email() {
        return u_email;
    }

    public void setU_email(String u_email) {
        this.u_email = u_email;
    }

    public String getU_phone_no() {
        return u_phone_no;
    }

    public void setU_phone_no(String u_phone_no) {
        this.u_phone_no = u_phone_no;
    }

    public String getU_gender() {
        return u_gender;
    }

    public void setU_gender(String u_gender) {
        this.u_gender = u_gender;
    }

    public String getU_pic() {
        return u_pic;
    }

    public void setU_pic(String u_pic) {
        this.u_pic = u_pic;
    }

    public String getU_status() {
        return u_status;
    }

    public void setU_status(String u_status) {
        this.u_status = u_status;
    }

    @SerializedName("u_phone_no")
    String u_phone_no;
    @SerializedName("u_gender")
    String u_gender;
    @SerializedName("u_pic")
    String u_pic;
    @SerializedName("u_status")
    String u_status;



}
