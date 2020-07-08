package com.kt.trigger;

import org.gradle.api.DefaultTask;
import org.gradle.api.tasks.TaskAction;

import com.kt.extension.DevOpsPluginExtension;

public class JenkinsTask extends DefaultTask {

  @TaskAction
  public void execute() {
    var ext = getProject().getExtensions().getByType(DevOpsPluginExtension.class);
    JenkinsTrigger.of(ext).run();
  }

}
