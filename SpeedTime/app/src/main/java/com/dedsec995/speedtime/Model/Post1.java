package com.dedsec995.speedtime.Model;

public class Post1 {
    private String vin;

    private String frequency;

    private String same_vin;

    public Post1(String vin, String frequency, String same_vin) {
        this.vin = vin;
        this.frequency = frequency;
        this.same_vin = same_vin;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public String getFrequency() {
        return frequency;
    }

    public void setFrequency(String frequency) {
        this.frequency = frequency;
    }

    public String getSame_vin() {
        return same_vin;
    }

    public void setSame_vin(String same_vin) {
        this.same_vin = same_vin;
    }
}
