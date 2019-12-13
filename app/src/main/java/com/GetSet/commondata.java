package com.GetSet;

import com.google.gson.annotations.SerializedName;

public class commondata {

    @SerializedName("status")
    String status;

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

    @SerializedName("msg")
    String msg;

    public String getP_image_path() {
        return p_image_path;
    }

    public void setP_image_path(String p_image_path) {
        this.p_image_path = p_image_path;
    }

    @SerializedName("p_image_path")
    String p_image_path;


}
