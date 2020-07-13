package com.kt.configure;

import org.gradle.api.Project;

public interface Configurable {

  void apply(Project project);
}
