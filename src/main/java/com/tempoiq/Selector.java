package com.tempoiq;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import com.tempoiq.json.QueryModule;

public abstract class Selector {
  public enum Type {
    DEVICES,
    SENSORS
  }

  public static AttributeKeySelector attributeKey(String key) {
    return new AttributeKeySelector(key);
  }

  public static AttributesSelector attributes(String key, String value) {
    return new AttributesSelector(key, value);
  }

  public static KeySelector key(String key) {
    return new KeySelector(key);
  }

  public static OrSelector or(Selector... children) {
    return new OrSelector(children);
  }

  public static AndSelector and(Selector... children) {
    return new AndSelector(children);
  }

  public static AllSelector all() {
    return new AllSelector();
  }
}
