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
public final class CityResponse$$JsonObjectMapper extends JsonMapper<CityResponse> {
  private static final JsonMapper<CityWeather> COM_APP_WEATHER_MODEL_CITYWEATHER__JSONOBJECTMAPPER = LoganSquare.mapperFor(CityWeather.class);

  @Override
  public CityResponse parse(JsonParser jsonParser) throws IOException {
    CityResponse instance = new CityResponse();
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
  public void parseField(CityResponse instance, String fieldName, JsonParser jsonParser) throws IOException {
    if ("cod".equals(fieldName)) {
      instance.setCod(jsonParser.getValueAsString(null));
    } else if ("count".equals(fieldName)) {
      instance.setCount(jsonParser.getValueAsInt());
    } else if ("list".equals(fieldName)) {
      if (jsonParser.getCurrentToken() == JsonToken.START_ARRAY) {
        ArrayList<CityWeather> collection1 = new ArrayList<CityWeather>();
        while (jsonParser.nextToken() != JsonToken.END_ARRAY) {
          CityWeather value1;
          value1 = COM_APP_WEATHER_MODEL_CITYWEATHER__JSONOBJECTMAPPER.parse(jsonParser);
          collection1.add(value1);
        }
        instance.setList(collection1);
      } else {
        instance.setList(null);
      }
    } else if ("message".equals(fieldName)) {
      instance.setMessage(jsonParser.getValueAsString(null));
    }
  }

  @Override
  public void serialize(CityResponse object, JsonGenerator jsonGenerator, boolean writeStartAndEnd) throws IOException {
    if (writeStartAndEnd) {
      jsonGenerator.writeStartObject();
    }
    if (object.getCod() != null) {
      jsonGenerator.writeStringField("cod", object.getCod());
    }
    jsonGenerator.writeNumberField("count", object.getCount());
    final List<CityWeather> lslocallist = object.getList();
    if (lslocallist != null) {
      jsonGenerator.writeFieldName("list");
      jsonGenerator.writeStartArray();
      for (CityWeather element1 : lslocallist) {
        if (element1 != null) {
          COM_APP_WEATHER_MODEL_CITYWEATHER__JSONOBJECTMAPPER.serialize(element1, jsonGenerator, true);
        }
      }
      jsonGenerator.writeEndArray();
    }
    if (object.getMessage() != null) {
      jsonGenerator.writeStringField("message", object.getMessage());
    }
    if (writeStartAndEnd) {
      jsonGenerator.writeEndObject();
    }
  }
}
