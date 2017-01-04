package com.app.weather.model;

import com.bluelinelabs.logansquare.annotation.JsonField;
import com.bluelinelabs.logansquare.annotation.JsonObject;

import java.io.Serializable;

/**
 *  @author Niranjan
 *  @since 12/28/16
 */
@JsonObject
public class Sys implements Serializable{
    @JsonField(name = "type")
    private int type;
    @JsonField(name = "id")
    private int id;
    @JsonField(name = "message")
    private double message;
    @JsonField(name = "country")
    private String country;
    @JsonField(name = "sunrise")
    private int sunrise;
    @JsonField(name = "sunset")
    private int sunset;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getMessage() {
        return message;
    }

    public void setMessage(double message) {
        this.message = message;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getSunrise() {
        return sunrise;
    }

    public void setSunrise(int sunrise) {
        this.sunrise = sunrise;
    }

    public int getSunset() {
        return sunset;
    }

    public void setSunset(int sunset) {
        this.sunset = sunset;
    }
}
