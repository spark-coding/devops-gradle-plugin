package com.kt;

import org.springframework.boot.gradle.plugin.SpringBootPlugin;

import io.spring.gradle.dependencymanagement.DependencyManagementPlugin;
import io.spring.gradle.dependencymanagement.dsl.DependencyManagementExtension;
import lombok.RequiredArgsConstructor;
import org.gradle.api.Project;
import org.gradle.api.publish.maven.plugins.MavenPublishPlugin;
import org.gradle.plugins.signing.SigningPlugin;

@RequiredArgsConstructor
public class DevOpsConfigure implements Configure {

  private final Project project;

  private final MavenPublishPom pom;

  private final MavenPublishRepository repository;

  @Override
  public void configureSpringBoot() {
    project.getPluginManager()
        .apply(SpringBootPlugin.class);

    project.getPluginManager()
        .apply(DependencyManagementPlugin.class);

    project.getExtensions()
        .configure(DependencyManagementExtension.class, e -> e.imports(h -> h.mavenBom(bom)));
  }

  @Override
  public void configurePublishing() {
    project.getPluginManager().apply(SigningPlugin.class);
    project.getPluginManager().apply(MavenPublishPlugin.class);
  }

  @Override
  public void configureRepository() {
    project.getRepositories().mavenLocal();
    project.getRepositories().maven(new RepositoryAction());
    project.getRepositories().mavenCentral();
  }

  @Override
  public void configureDependency() {

  }

  @Override
  public void configureDocumentation() {

  }
}
