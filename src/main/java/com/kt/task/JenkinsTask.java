package com.kt.task;

import org.gradle.api.DefaultTask;
import org.gradle.api.tasks.TaskAction;

import com.kt.extension.BaseExtension;
import com.kt.trigger.JenkinsTrigger;

public class JenkinsTask extends DefaultTask {

  @TaskAction
  public void execute() {
    var ext = getProject().getExtensions().getByType(BaseExtension.class);
    JenkinsTrigger.of(ext).run();
  }

}
