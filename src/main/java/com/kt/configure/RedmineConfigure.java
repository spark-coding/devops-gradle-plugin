package com.kt.configure;

import lombok.Getter;
import org.gradle.api.Project;

@Getter
public class RedmineConfigure implements Configurable, NameAware{

  private String name = "Redmine";

  @Override
  public void apply(Project project) {

  }
}
