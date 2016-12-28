package com.app.weather.utils;

/**
 * Created by niranjan on 12/28/16.
 */

public class Constants {
   public static String DEFAULT_ICON_STR =  "http://openweathermap.org/img/w/";  // https://openweathermap.org/weather-conditions    http://openweathermap.org/api
   public static String API_KEY  = "ff48573957bf4a69793c6d9e4d89ddcc";

    public static int ONE_KELVIN_TO_CELSIUS  = -273;

    public static String DEFAULT_CITIES_JSON  = "{\"message\":\"accurate\",\"cod\":\"200\",\"count\":4,\"list\":[{\"id\":1273294,\"name\":\"Delhi\",\"coord\":{\"lon\":77.216667,\"lat\":28.666668},\"main\":{\"temp\":14,\"pressure\":1017,\"humidity\":67,\"temp_min\":14,\"temp_max\":14},\"dt\":1482946200,\"wind\":{\"speed\":1.21,\"deg\":27.5051},\"sys\":{\"country\":\"IN\"},\"clouds\":{\"all\":0},\"weather\":[{\"id\":711,\"main\":\"Smoke\",\"description\":\"smoke\",\"icon\":\"50n\"}]},{\"id\":4321929,\"name\":\"Delhi\",\"coord\":{\"lon\":-91.493172,\"lat\":32.457642},\"main\":{\"temp\":17.8,\"pressure\":1019,\"humidity\":93,\"temp_min\":16,\"temp_max\":21},\"dt\":1482946500,\"wind\":{\"speed\":2.81,\"deg\":213.505},\"sys\":{\"country\":\"US\"},\"clouds\":{\"all\":90},\"weather\":[{\"id\":701,\"main\":\"Mist\",\"description\":\"mist\",\"icon\":\"50d\"}]},{\"id\":5114824,\"name\":\"Delhi\",\"coord\":{\"lon\":-74.915993,\"lat\":42.278141},\"main\":{\"temp\":-1,\"pressure\":1018,\"humidity\":63,\"temp_min\":-1,\"temp_max\":-1},\"dt\":1482946500,\"wind\":{\"speed\":6.7,\"deg\":320,\"gust\":8.7},\"sys\":{\"country\":\"US\"},\"clouds\":{\"all\":90},\"weather\":[{\"id\":804,\"main\":\"Clouds\",\"description\":\"overcast clouds\",\"icon\":\"04d\"}]},{\"id\":5342522,\"name\":\"Delhi\",\"coord\":{\"lon\":-120.778542,\"lat\":37.432159},\"main\":{\"temp\":3.34,\"pressure\":1027,\"humidity\":70,\"temp_min\":2,\"temp_max\":7},\"dt\":1482946500,\"wind\":{\"speed\":2.6,\"deg\":340},\"sys\":{\"country\":\"US\"},\"clouds\":{\"all\":1},\"weather\":[{\"id\":701,\"main\":\"Mist\",\"description\":\"mist\",\"icon\":\"50d\"}]}]}";

    public static String DEFAULT_CURRENT_LOCATION_JSON  = "{\"coord\":{\"lon\":37.62,\"lat\":55.75},\"weather\":[{\"id\":600,\"main\":\"Snow\",\"description\":\"light snow\",\"icon\":\"13d\"},{\"id\":701,\"main\":\"Mist\",\"description\":\"mist\",\"icon\":\"50d\"}],\"base\":\"stations\",\"main\":{\"temp\":272.15,\"pressure\":1010,\"humidity\":92,\"temp_min\":272.15,\"temp_max\":272.15},\"visibility\":9000,\"wind\":{\"speed\":3,\"deg\":330},\"clouds\":{\"all\":75},\"dt\":1482930000,\"sys\":{\"type\":1,\"id\":7323,\"message\":0.0141,\"country\":\"RU\",\"sunrise\":1482904769,\"sunset\":1482930220},\"id\":524901,\"name\":\"Moscow\",\"cod\":200}";


    //  http://api.openweathermap.org/data/2.5/weather?q=newyork,ny&units=imperial
  //  http://openweathermap.org/data/2.5/find
  //  http://api.openweathermap.org/data/2.5/find?q=Delhi&cnt=10&APPID=ff48573957bf4a69793c6d9e4d89ddcc
}
