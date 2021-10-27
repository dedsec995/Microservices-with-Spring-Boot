package com.dedsec995.speedtime.Model;

public class MaunalPost {
    public MaunalPost(String vin_number, String speed) {
        this.vin_number = vin_number;
        this.speed = speed;
    }

    String vin_number;

    String speed;

    public String getVin_number() {
        return vin_number;
    }

    public void setVin_number(String vin_number) {
        this.vin_number = vin_number;
    }

    public String getSpeed() {
        return speed;
    }

    public void setSpeed(String speed) {
        this.speed = speed;
    }
}
