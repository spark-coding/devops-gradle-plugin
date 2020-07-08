package com.kt;

import org.springframework.boot.gradle.plugin.SpringBootPlugin;

import io.spring.gradle.dependencymanagement.DependencyManagementPlugin;
import io.spring.gradle.dependencymanagement.dsl.DependencyManagementExtension;
import lombok.RequiredArgsConstructor;
import org.gradle.api.Project;
import org.gradle.api.publish.maven.plugins.MavenPublishPlugin;
import org.gradle.plugins.signing.SigningPlugin;

import com.kt.extension.DevOpsPluginExtension;
import com.kt.trigger.JenkinsTrigger;

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

    var ext = project.getExtensions().getByType(DevOpsPluginExtension.class);

    var log = project.getLogger();

//    project.getTasks().create("release", task -> JenkinsTrigger.of(ext).run());

    if (ext.isPublish()) {
      project.getRepositories().forEach(a -> log.lifecycle("- Artifact Repository : {}", a.getName()));
    }
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
