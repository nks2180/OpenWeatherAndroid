package com.app.weather.model;

import com.bluelinelabs.logansquare.JsonMapper;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;

@SuppressWarnings("unsafe,unchecked")
public final class Coordinates$$JsonObjectMapper extends JsonMapper<Coordinates> {
  @Override
  public Coordinates parse(JsonParser jsonParser) throws IOException {
    Coordinates instance = new Coordinates();
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
  public void parseField(Coordinates instance, String fieldName, JsonParser jsonParser) throws IOException {
    if ("lat".equals(fieldName)) {
      instance.setLat(jsonParser.getValueAsDouble());
    } else if ("lon".equals(fieldName)) {
      instance.setLon(jsonParser.getValueAsDouble());
    }
  }

  @Override
  public void serialize(Coordinates object, JsonGenerator jsonGenerator, boolean writeStartAndEnd) throws IOException {
    if (writeStartAndEnd) {
      jsonGenerator.writeStartObject();
    }
    jsonGenerator.writeNumberField("lat", object.getLat());
    jsonGenerator.writeNumberField("lon", object.getLon());
    if (writeStartAndEnd) {
      jsonGenerator.writeEndObject();
    }
  }
}
