package com.example.jfxprjct;

import java.util.Date;

public class Couveuse{
    int id;
    int  temperature;
    int humidite;
    String datIncuvation;

    public Couveuse(int id, int temperature, int humidite, String datIncuvation) {
        this.id = id;
        this.temperature = temperature;
        this.humidite = humidite;
        this.datIncuvation = datIncuvation;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    public void setHumidite(int humidite) {
        this.humidite = humidite;
    }

    public void setDatIncuvation(String datIncuvation) {
        this.datIncuvation = datIncuvation;
    }

    public int getTemperature() {
        return temperature;
    }

    public int getHumidite() {
        return humidite;
    }

    public String getDatIncuvation() {
        return datIncuvation;
    }
}
