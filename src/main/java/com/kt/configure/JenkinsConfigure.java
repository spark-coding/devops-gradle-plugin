package com.kt.configure;

import lombok.Getter;
import org.gradle.api.Project;

import com.kt.extension.DevOpsExtension;
import com.kt.task.JenkinsTask;

@Getter
public class JenkinsConfigure implements Configurable, NameAware {

  private String name = "Jenkins";

  @Override
  public void apply(Project project) {
    var ext = project.getExtensions().getByType(DevOpsExtension.class);

    var task = project.getTasks()
        .create("deploy", JenkinsTask.class);

    task.setGroup("DevOps");
    task.dependsOn("build");

//    project.getTasks().create("release", task -> JenkinsTrigger.of(ext).run());
  }
}
