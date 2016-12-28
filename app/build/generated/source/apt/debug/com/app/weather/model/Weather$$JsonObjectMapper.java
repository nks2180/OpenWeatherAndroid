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
public final class Weather$$JsonObjectMapper extends JsonMapper<Weather> {
  @Override
  public Weather parse(JsonParser jsonParser) throws IOException {
    Weather instance = new Weather();
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
  public void parseField(Weather instance, String fieldName, JsonParser jsonParser) throws IOException {
    if ("description".equals(fieldName)) {
      instance.setDescription(jsonParser.getValueAsString(null));
    } else if ("icon".equals(fieldName)) {
      instance.setIcon(jsonParser.getValueAsString(null));
    } else if ("id".equals(fieldName)) {
      instance.setId(jsonParser.getValueAsInt());
    } else if ("main".equals(fieldName)) {
      instance.setMain(jsonParser.getValueAsString(null));
    }
  }

  @Override
  public void serialize(Weather object, JsonGenerator jsonGenerator, boolean writeStartAndEnd) throws IOException {
    if (writeStartAndEnd) {
      jsonGenerator.writeStartObject();
    }
    if (object.getDescription() != null) {
      jsonGenerator.writeStringField("description", object.getDescription());
    }
    if (object.getIcon() != null) {
      jsonGenerator.writeStringField("icon", object.getIcon());
    }
    jsonGenerator.writeNumberField("id", object.getId());
    if (object.getMain() != null) {
      jsonGenerator.writeStringField("main", object.getMain());
    }
    if (writeStartAndEnd) {
      jsonGenerator.writeEndObject();
    }
  }
}
