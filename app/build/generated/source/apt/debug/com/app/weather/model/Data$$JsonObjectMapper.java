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
public final class Data$$JsonObjectMapper extends JsonMapper<Data> {
  @Override
  public Data parse(JsonParser jsonParser) throws IOException {
    Data instance = new Data();
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
  public void parseField(Data instance, String fieldName, JsonParser jsonParser) throws IOException {
    if ("id".equals(fieldName)) {
      instance.setId(jsonParser.getValueAsInt());
    } else if ("name".equals(fieldName)) {
      instance.setName(jsonParser.getValueAsString(null));
    } else if ("state".equals(fieldName)) {
      instance.setState(jsonParser.getValueAsInt());
    }
  }

  @Override
  public void serialize(Data object, JsonGenerator jsonGenerator, boolean writeStartAndEnd) throws IOException {
    if (writeStartAndEnd) {
      jsonGenerator.writeStartObject();
    }
    jsonGenerator.writeNumberField("id", object.getId());
    if (object.getName() != null) {
      jsonGenerator.writeStringField("name", object.getName());
    }
    jsonGenerator.writeNumberField("state", object.getState());
    if (writeStartAndEnd) {
      jsonGenerator.writeEndObject();
    }
  }
}
