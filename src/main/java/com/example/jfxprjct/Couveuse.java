package com.example.jfxprjct;

import java.util.Date;

public class Couveuse{
    String id;
    int  temperature;
    int humidite;
    Date datIncuvation;

    public Couveuse(String id, int temperature, int humidite, Date datIncuvation) {
        this.id = id;
        this.temperature = temperature;
        this.humidite = humidite;
        this.datIncuvation = datIncuvation;
    }

    public String getId() {
        return id;
    }

    public int getTemperature() {
        return temperature;
    }

    public int getHumidite() {
        return humidite;
    }

    public Date getDatIncuvation() {
        return datIncuvation;
    }
}
