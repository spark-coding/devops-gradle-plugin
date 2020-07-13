package com.kt.extension;

import groovy.lang.Closure;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.gradle.util.Configurable;

@Getter
@Setter
@ToString
public class Repository implements Configurable {

  private String name;

  private String url;

  private String username;

  private String password;

  private String token;

  @Override
  public Object configure(Closure closure) {
    return null;
  }
}
