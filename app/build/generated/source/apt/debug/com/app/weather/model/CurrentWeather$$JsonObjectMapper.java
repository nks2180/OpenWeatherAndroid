package com.app.weather.model;

import com.bluelinelabs.logansquare.JsonMapper;
import com.bluelinelabs.logansquare.LoganSquare;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unsafe,unchecked")
public final class CurrentWeather$$JsonObjectMapper extends JsonMapper<CityWeather> {
  private static final JsonMapper<Coordinates> COM_APP_WEATHER_MODEL_COORDINATES__JSONOBJECTMAPPER = LoganSquare.mapperFor(Coordinates.class);

  private static final JsonMapper<Sys> COM_APP_WEATHER_MODEL_SYS__JSONOBJECTMAPPER = LoganSquare.mapperFor(Sys.class);

  private static final JsonMapper<Wind> COM_APP_WEATHER_MODEL_WIND__JSONOBJECTMAPPER = LoganSquare.mapperFor(Wind.class);

  private static final JsonMapper<Weather> COM_APP_WEATHER_MODEL_WEATHER__JSONOBJECTMAPPER = LoganSquare.mapperFor(Weather.class);

  private static final JsonMapper<Clouds> COM_APP_WEATHER_MODEL_CLOUDS__JSONOBJECTMAPPER = LoganSquare.mapperFor(Clouds.class);

  private static final JsonMapper<Main> COM_APP_WEATHER_MODEL_MAIN__JSONOBJECTMAPPER = LoganSquare.mapperFor(Main.class);

  @Override
  public CityWeather parse(JsonParser jsonParser) throws IOException {
    CityWeather instance = new CityWeather();
    if (jsonParser.getCurrentToken() == null) {
      jsonParser.nextToken();
    }
    if (jsonParser.getCurrentToken() != JsonToken.START_OBJECT) {
      jsonParser.skipChildren();
      return null;
    }
    while (jsonParser.nextToken() != JsonToken.END_OBJECT) {
      String fieldName = jsonParser.getCurrentName();
      jsonParser.nextToken();
      parseField(instance, fieldName, jsonParser);
      jsonParser.skipChildren();
    }
    return instance;
  }

  @Override
  public void parseField(CityWeather instance, String fieldName, JsonParser jsonParser) throws IOException {
    if ("base".equals(fieldName)) {
      instance.setBase(jsonParser.getValueAsString(null));
    } else if ("clouds".equals(fieldName)) {
      instance.setClouds(COM_APP_WEATHER_MODEL_CLOUDS__JSONOBJECTMAPPER.parse(jsonParser));
    } else if ("cod".equals(fieldName)) {
      instance.setCod(jsonParser.getValueAsInt());
    } else if ("coord".equals(fieldName)) {
      instance.setCoord(COM_APP_WEATHER_MODEL_COORDINATES__JSONOBJECTMAPPER.parse(jsonParser));
    } else if ("dt".equals(fieldName)) {
      instance.setDt(jsonParser.getValueAsInt());
    } else if ("id".equals(fieldName)) {
      instance.setId(jsonParser.getValueAsInt());
    } else if ("main".equals(fieldName)) {
      instance.setMain(COM_APP_WEATHER_MODEL_MAIN__JSONOBJECTMAPPER.parse(jsonParser));
    } else if ("name".equals(fieldName)) {
      instance.setName(jsonParser.getValueAsString(null));
    } else if ("sys".equals(fieldName)) {
      instance.setSys(COM_APP_WEATHER_MODEL_SYS__JSONOBJECTMAPPER.parse(jsonParser));
    } else if ("visibility".equals(fieldName)) {
      instance.setVisibility(jsonParser.getValueAsInt());
    } else if ("weather".equals(fieldName)) {
      if (jsonParser.getCurrentToken() == JsonToken.START_ARRAY) {
        ArrayList<Weather> collection1 = new ArrayList<Weather>();
        while (jsonParser.nextToken() != JsonToken.END_ARRAY) {
          Weather value1;
          value1 = COM_APP_WEATHER_MODEL_WEATHER__JSONOBJECTMAPPER.parse(jsonParser);
          collection1.add(value1);
        }
        instance.setWeather(collection1);
      } else {
        instance.setWeather(null);
      }
    } else if ("wind".equals(fieldName)) {
      instance.setWind(COM_APP_WEATHER_MODEL_WIND__JSONOBJECTMAPPER.parse(jsonParser));
    }
  }

  @Override
  public void serialize(CityWeather object, JsonGenerator jsonGenerator, boolean writeStartAndEnd) throws IOException {
    if (writeStartAndEnd) {
      jsonGenerator.writeStartObject();
    }
    if (object.getBase() != null) {
      jsonGenerator.writeStringField("base", object.getBase());
    }
    if (object.getClouds() != null) {
      jsonGenerator.writeFieldName("clouds");
      COM_APP_WEATHER_MODEL_CLOUDS__JSONOBJECTMAPPER.serialize(object.getClouds(), jsonGenerator, true);
    }
    jsonGenerator.writeNumberField("cod", object.getCod());
    if (object.getCoord() != null) {
      jsonGenerator.writeFieldName("coord");
      COM_APP_WEATHER_MODEL_COORDINATES__JSONOBJECTMAPPER.serialize(object.getCoord(), jsonGenerator, true);
    }
    jsonGenerator.writeNumberField("dt", object.getDt());
    jsonGenerator.writeNumberField("id", object.getId());
    if (object.getMain() != null) {
      jsonGenerator.writeFieldName("main");
      COM_APP_WEATHER_MODEL_MAIN__JSONOBJECTMAPPER.serialize(object.getMain(), jsonGenerator, true);
    }
    if (object.getName() != null) {
      jsonGenerator.writeStringField("name", object.getName());
    }
    if (object.getSys() != null) {
      jsonGenerator.writeFieldName("sys");
      COM_APP_WEATHER_MODEL_SYS__JSONOBJECTMAPPER.serialize(object.getSys(), jsonGenerator, true);
    }
    jsonGenerator.writeNumberField("visibility", object.getVisibility());
    final List<Weather> lslocalweather = object.getWeather();
    if (lslocalweather != null) {
      jsonGenerator.writeFieldName("weather");
      jsonGenerator.writeStartArray();
      for (Weather element1 : lslocalweather) {
        if (element1 != null) {
          COM_APP_WEATHER_MODEL_WEATHER__JSONOBJECTMAPPER.serialize(element1, jsonGenerator, true);
        }
      }
      jsonGenerator.writeEndArray();
    }
    if (object.getWind() != null) {
      jsonGenerator.writeFieldName("wind");
      COM_APP_WEATHER_MODEL_WIND__JSONOBJECTMAPPER.serialize(object.getWind(), jsonGenerator, true);
    }
    if (writeStartAndEnd) {
      jsonGenerator.writeEndObject();
    }
  }
}
