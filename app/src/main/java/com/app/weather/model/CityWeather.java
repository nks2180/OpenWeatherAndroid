package com.app.weather.model;

import com.bluelinelabs.logansquare.annotation.JsonField;
import com.bluelinelabs.logansquare.annotation.JsonObject;

import java.util.List;

/**
 * Created by niranjan on 12/28/16.
 */

@JsonObject
public class CityWeather {

    @JsonField(name = "coord")
    private Coordinates coord;
    @JsonField(name = "base")
    private String base;
    @JsonField(name = "main")
    private Main main;
    @JsonField(name = "visibility")
    private int visibility;
    @JsonField(name = "wind")
    private Wind wind;
    @JsonField(name = "clouds")
    private Clouds clouds;
    @JsonField(name = "dt")
    private int dt;
    @JsonField(name = "sys")
    private Sys sys;
    @JsonField(name = "id")
    private int id;
    @JsonField(name = "name")
    private String name;
    @JsonField(name = "cod")
    private int cod;
    @JsonField(name = "weather")
    private List<Weather> weather;

    public Coordinates getCoord() {
        return coord;
    }

    public void setCoord(Coordinates coord) {
        this.coord = coord;
    }

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public Main getMain() {
        return main;
    }

    public void setMain(Main main) {
        this.main = main;
    }

    public int getVisibility() {
        return visibility;
    }

    public void setVisibility(int visibility) {
        this.visibility = visibility;
    }

    public Wind getWind() {
        return wind;
    }

    public void setWind(Wind wind) {
        this.wind = wind;
    }

    public Clouds getClouds() {
        return clouds;
    }

    public void setClouds(Clouds clouds) {
        this.clouds = clouds;
    }

    public int getDt() {
        return dt;
    }

    public void setDt(int dt) {
        this.dt = dt;
    }

    public Sys getSys() {
        return sys;
    }

    public void setSys(Sys sys) {
        this.sys = sys;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public List<Weather> getWeather() {
        return weather;
    }

    public void setWeather(List<Weather> weather) {
        this.weather = weather;
    }


}
