package com.app.weather.model;

import com.bluelinelabs.logansquare.annotation.JsonField;
import com.bluelinelabs.logansquare.annotation.JsonObject;

import java.io.Serializable;

/**
 *  @author Niranjan
 *  @since 12/28/16
 */
@JsonObject
public class Coordinates implements Serializable{
    @JsonField(name = "lon")
    private double lon;
    @JsonField(name = "lat")
    private double lat;

    public double getLon() {
        return lon;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }
}
