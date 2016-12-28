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
public final class Wind$$JsonObjectMapper extends JsonMapper<Wind> {
  @Override
  public Wind parse(JsonParser jsonParser) throws IOException {
    Wind instance = new Wind();
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
  public void parseField(Wind instance, String fieldName, JsonParser jsonParser) throws IOException {
    if ("deg".equals(fieldName)) {
      instance.setDeg(jsonParser.getValueAsInt());
    } else if ("speed".equals(fieldName)) {
      instance.setSpeed(jsonParser.getValueAsDouble());
    }
  }

  @Override
  public void serialize(Wind object, JsonGenerator jsonGenerator, boolean writeStartAndEnd) throws IOException {
    if (writeStartAndEnd) {
      jsonGenerator.writeStartObject();
    }
    jsonGenerator.writeNumberField("deg", object.getDeg());
    jsonGenerator.writeNumberField("speed", object.getSpeed());
    if (writeStartAndEnd) {
      jsonGenerator.writeEndObject();
    }
  }
}
