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
public final class Sys$$JsonObjectMapper extends JsonMapper<Sys> {
  @Override
  public Sys parse(JsonParser jsonParser) throws IOException {
    Sys instance = new Sys();
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
  public void parseField(Sys instance, String fieldName, JsonParser jsonParser) throws IOException {
    if ("country".equals(fieldName)) {
      instance.setCountry(jsonParser.getValueAsString(null));
    } else if ("id".equals(fieldName)) {
      instance.setId(jsonParser.getValueAsInt());
    } else if ("message".equals(fieldName)) {
      instance.setMessage(jsonParser.getValueAsDouble());
    } else if ("sunrise".equals(fieldName)) {
      instance.setSunrise(jsonParser.getValueAsInt());
    } else if ("sunset".equals(fieldName)) {
      instance.setSunset(jsonParser.getValueAsInt());
    } else if ("type".equals(fieldName)) {
      instance.setType(jsonParser.getValueAsInt());
    }
  }

  @Override
  public void serialize(Sys object, JsonGenerator jsonGenerator, boolean writeStartAndEnd) throws IOException {
    if (writeStartAndEnd) {
      jsonGenerator.writeStartObject();
    }
    if (object.getCountry() != null) {
      jsonGenerator.writeStringField("country", object.getCountry());
    }
    jsonGenerator.writeNumberField("id", object.getId());
    jsonGenerator.writeNumberField("message", object.getMessage());
    jsonGenerator.writeNumberField("sunrise", object.getSunrise());
    jsonGenerator.writeNumberField("sunset", object.getSunset());
    jsonGenerator.writeNumberField("type", object.getType());
    if (writeStartAndEnd) {
      jsonGenerator.writeEndObject();
    }
  }
}
