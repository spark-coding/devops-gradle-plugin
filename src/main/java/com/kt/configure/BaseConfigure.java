package com.kt.configure;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.gradle.api.Project;

public abstract class BaseConfigure<T extends Configurable> {

  @NonNull
  private Project project;

  public void apply() {
    configurable.config(project);
  }

}
