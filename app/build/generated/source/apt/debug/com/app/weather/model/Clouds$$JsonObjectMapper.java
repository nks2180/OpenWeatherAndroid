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
public final class Clouds$$JsonObjectMapper extends JsonMapper<Clouds> {
  @Override
  public Clouds parse(JsonParser jsonParser) throws IOException {
    Clouds instance = new Clouds();
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
  public void parseField(Clouds instance, String fieldName, JsonParser jsonParser) throws IOException {
    if ("all".equals(fieldName)) {
      instance.setAll(jsonParser.getValueAsInt());
    }
  }

  @Override
  public void serialize(Clouds object, JsonGenerator jsonGenerator, boolean writeStartAndEnd) throws IOException {
    if (writeStartAndEnd) {
      jsonGenerator.writeStartObject();
    }
    jsonGenerator.writeNumberField("all", object.getAll());
    if (writeStartAndEnd) {
      jsonGenerator.writeEndObject();
    }
  }
}
