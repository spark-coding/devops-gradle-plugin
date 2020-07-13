package com.kt.configure.repository;

import lombok.Getter;
import org.gradle.api.Project;

import com.kt.configure.Configurable;

@Getter
public class RepositoryConfigure implements Configurable {

  private String name = "Repository";

  @Override
  public void apply(Project project) {
    project.getRepositories().mavenLocal();
    project.getRepositories().maven(RepositoryAction.of(project));
    project.getRepositories().mavenCentral();
  }
}
