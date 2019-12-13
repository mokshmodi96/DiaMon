package com.GetSet;

import com.google.gson.annotations.SerializedName;

public class medicine {

    @SerializedName("status")
    String status;
    @SerializedName("m_name")
    String m_name;
    @SerializedName("m_company")
    String m_company;
    @SerializedName("m_price")
    String m_price;

    @SerializedName("m_drug_type")
    String m_drug_type;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getM_name() {
        return m_name;
    }

    public void setM_name(String m_name) {
        this.m_name = m_name;
    }

    public String getM_company() {
        return m_company;
    }

    public void setM_company(String m_company) {
        this.m_company = m_company;
    }

    public String getM_price() {
        return m_price;
    }

    public void setM_price(String m_price) {
        this.m_price = m_price;
    }

    public String getM_drug_type() {
        return m_drug_type;
    }

    public void setM_drug_type(String m_drug_type) {
        this.m_drug_type = m_drug_type;
    }

    public String getM_drug() {
        return m_drug;
    }

    public void setM_drug(String m_drug) {
        this.m_drug = m_drug;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @SerializedName("m_drug")
    String m_drug;
  @SerializedName("msg")
    String msg;




}
