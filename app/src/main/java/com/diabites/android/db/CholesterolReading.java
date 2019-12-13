package com.diabites.android.db;

import java.util.Date;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class CholesterolReading extends RealmObject {
    @PrimaryKey
    private long id;

    private double totalReading;
    private double LDLReading;
    private double HDLReading;
    private Date created;

    public CholesterolReading() {
    }

    public CholesterolReading(double totalReading, double LDLReading, double HDLReading, Date created) {
        // mg/dL
        // 0-200
        this.totalReading = totalReading;
        this.LDLReading = LDLReading;
        this.HDLReading = HDLReading;
        this.created = created;
    }

    public double getTotalReading() {
        return totalReading;
    }

    public void setTotalReading(double totalReading) {
        this.totalReading = totalReading;
    }

    public double getLDLReading() {
        return LDLReading;
    }

    public void setLDLReading(double LDLReading) {
        this.LDLReading = LDLReading;
    }

    public double getHDLReading() {
        return HDLReading;
    }

    public void setHDLReading(double HDLReading) {
        this.HDLReading = HDLReading;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
