package com.kt;

import org.gradle.api.Plugin;
import org.gradle.api.Project;

public class DevOpsPlugin implements Plugin<Project> {


  @Override
  public void apply(Project project) {
    var ext = project.getExtensions()
        .create("kt", DevOpsPluginExtension.class);

    var log = project.getLogger();
    log.lifecycle("- kt DevOps Plugin -");

    var configure = new DevOpsConfigure(project, MavenPublishPom.of(project), MavenPublishRepository.kt());

    configure.configureRepository();
    configure.configureSpringBoot();
    configure.configurePublishing();

    if (ext.isPublish()) {
      project.getRepositories().forEach(a -> log.lifecycle("- Artifact Repository : {}", a.getName()));
    }
  }
}
