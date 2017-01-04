package com.app.weather.model;

import com.bluelinelabs.logansquare.annotation.JsonField;
import com.bluelinelabs.logansquare.annotation.JsonObject;

import java.io.Serializable;
import java.util.List;

/**
 *  @author Niranjan
 *  @since 12/28/16
 */

@JsonObject
public class CityResponse implements Serializable{


    @JsonField(name = "message")
    private String message;
    @JsonField(name = "cod")
    private String cod;
    @JsonField(name = "count")
    private int count;
    @JsonField(name = "list")
    private List<CityWeather> list;


    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<CityWeather> getList() {
        return list;
    }

    public void setList(List<CityWeather> list) {
        this.list = list;
    }
}
