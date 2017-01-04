package com.app.weather.model;

import com.bluelinelabs.logansquare.annotation.JsonField;
import com.bluelinelabs.logansquare.annotation.JsonObject;

import java.io.Serializable;

/**
 *  @author Niranjan
 *  @since 12/28/16
 */
@JsonObject
public class Main implements Serializable{
    @JsonField(name = "temp")
    private double temp;
    @JsonField(name = "pressure")
    private int pressure;
    @JsonField(name = "humidity")
    private int humidity;
    @JsonField(name = "temp_min")
    private double tempMin;
    @JsonField(name = "temp_max")
    private double tempMax;

    public double getTemp() {
        return temp;
    }

    public void setTemp(double temp) {
        this.temp = temp;
    }

    public int getPressure() {
        return pressure;
    }

    public void setPressure(int pressure) {
        this.pressure = pressure;
    }

    public int getHumidity() {
        return humidity;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }

    public double getTempMin() {
        return tempMin;
    }

    public void setTempMin(double tempMin) {
        this.tempMin = tempMin;
    }

    public double getTempMax() {
        return tempMax;
    }

    public void setTempMax(double tempMax) {
        this.tempMax = tempMax;
    }
}
