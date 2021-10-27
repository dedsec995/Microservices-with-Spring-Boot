package com.dedsec995.speedtime.Model;


import com.google.gson.annotations.SerializedName;

import java.sql.Timestamp;

public class Post {

    private String vin;

    private String verified;

    private int speed;

    private String alert;

    private Timestamp timest;

    public Post(String vin, String verified, int speed, String alert, Timestamp timest) {
        this.vin = vin;
        this.verified = verified;
        this.speed = speed;
        this.alert = alert;
        this.timest = timest;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public String getVerified() {
        return verified;
    }

    public void setVerified(String verified) {
        this.verified = verified;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public String getAlert() {
        return alert;
    }

    public void setAlert(String alert) {
        this.alert = alert;
    }

    public Timestamp getTimest() {
        return timest;
    }

    public void setTimest(Timestamp timest) {
        this.timest = timest;
    }

    @Override
    public String toString() {
        return "Model{" +
                "vin='" + vin + '\'' +
                ", verified='" + verified + '\'' +
                ", speed=" + speed +
                ", alert='" + alert + '\'' +
                ", timest=" + timest +
                '}';
    }
}
