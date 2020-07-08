package com.kt;

import org.gradle.api.Plugin;
import org.gradle.api.Project;

import com.kt.extension.DevOpsPluginExtension;
import com.kt.trigger.JenkinsTask;

public class DevOpsPlugin implements Plugin<Project> {


  @Override
  public void apply(Project project) {
    project.getExtensions().create("kt", DevOpsPluginExtension.class);
    var task = project.getTasks().create("deploy", JenkinsTask.class);

    task.setGroup("GigaGenie DevOps");
    task.dependsOn("build");
    printLogo(project);

    var configure = new DevOpsConfigure(project, MavenPublishPom.of(project), MavenPublishRepository.kt());

    configure.configureRepository();
    configure.configureSpringBoot();
    configure.configurePublishing();
  }


  public void printLogo(Project project) {
    project.getLogger().lifecycle("=================================================");
    project.getLogger().lifecycle("Korea Telecom GigaGenie AI Platform DevOps Plugin");
    project.getLogger().lifecycle("=================================================");
  }
}


