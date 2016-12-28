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
public final class Main$$JsonObjectMapper extends JsonMapper<Main> {
  @Override
  public Main parse(JsonParser jsonParser) throws IOException {
    Main instance = new Main();
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
  public void parseField(Main instance, String fieldName, JsonParser jsonParser) throws IOException {
    if ("humidity".equals(fieldName)) {
      instance.setHumidity(jsonParser.getValueAsInt());
    } else if ("pressure".equals(fieldName)) {
      instance.setPressure(jsonParser.getValueAsInt());
    } else if ("temp".equals(fieldName)) {
      instance.setTemp(jsonParser.getValueAsDouble());
    } else if ("temp_max".equals(fieldName)) {
      instance.setTempMax(jsonParser.getValueAsDouble());
    } else if ("temp_min".equals(fieldName)) {
      instance.setTempMin(jsonParser.getValueAsDouble());
    }
  }

  @Override
  public void serialize(Main object, JsonGenerator jsonGenerator, boolean writeStartAndEnd) throws IOException {
    if (writeStartAndEnd) {
      jsonGenerator.writeStartObject();
    }
    jsonGenerator.writeNumberField("humidity", object.getHumidity());
    jsonGenerator.writeNumberField("pressure", object.getPressure());
    jsonGenerator.writeNumberField("temp", object.getTemp());
    jsonGenerator.writeNumberField("temp_max", object.getTempMax());
    jsonGenerator.writeNumberField("temp_min", object.getTempMin());
    if (writeStartAndEnd) {
      jsonGenerator.writeEndObject();
    }
  }
}
