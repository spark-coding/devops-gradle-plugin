package com.kt.configure;

import org.gradle.api.Project;

public interface Configurable {

  String getName();

  void apply(Project project);
}
