package com.kt;

import javax.swing.Spring;

import org.gradle.api.Plugin;
import org.gradle.api.Project;

import com.kt.configure.BaseConfigure;
import com.kt.configure.JenkinsConfigure;
import com.kt.configure.PublishConfigure;
import com.kt.configure.SpringConfigure;
import com.kt.configure.repository.RepositoryConfigure;
import com.kt.extension.BaseExtension;
import com.kt.task.JenkinsTask;

public class DevOpsPlugin implements Plugin<Project> {

  @Override
  public void apply(Project project) {
    project.getExtensions().create("devops", BaseExtension.class);

    printLogo(project);

    BaseConfigure.of(project)
        .add(new SpringConfigure())
        .add(new PublishConfigure())
        .add(new JenkinsConfigure())
        .add(new RepositoryConfigure())
        .apply();
  }


  public void printLogo(Project project) {
    var logger = project.getLogger();
    logger.lifecycle(" * DevOps Plugin");
  }
}


