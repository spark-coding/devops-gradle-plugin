package com.kt;

import org.gradle.api.Plugin;
import org.gradle.api.Project;

import com.kt.configure.BaseConfigure2;
import com.kt.extension.BaseExtension;
import com.kt.task.JenkinsTask;

public class DevOpsPlugin implements Plugin<Project> {


  @Override
  public void apply(Project project) {
    project.getExtensions().create("devops", BaseExtension.class);
    var task = project.getTasks().create("deploy", JenkinsTask.class);

    task.setGroup("GigaGenie DevOps");
    task.dependsOn("build");
    printLogo(project);


    var configure =  kt();

    var configure = new BaseConfigure2(project, MavenPublishPom.of(project), MavenPublishRepository.kt());

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


