package com.kt;

import org.gradle.api.Plugin;
import org.gradle.api.Project;
import org.gradle.api.plugins.JavaPlugin;

import com.kt.configure.BaseConfigure;
import com.kt.configure.SpringConfigure;
import com.kt.configure.repository.RepositoryConfigure;
import com.kt.extension.DevOpsExtension;

public class DevOpsPlugin implements Plugin<Project> {

  @Override
  public void apply(Project project) {

    var logger = project.getLogger();

    try {
      logger.lifecycle(" * DevOps Plugin");

      project.getPluginManager()
          .apply(JavaPlugin.class);

      var ext = project.getExtensions().create("devops", DevOpsExtension.class, project.getObjects());
//      var ext = project.getExtensions().getByType(DevOpsExtension.class);

      project.afterEvaluate(a -> {
        var config = BaseConfigure.of(project)
            .add(new RepositoryConfigure());

        if (ext.getSpringBoot().isEnabled()) {
          config.add(new SpringConfigure());
        }

//      if (ext.getPublish().isEnabled()) {
//        config.add(new PublishConfigure());
//      }
//
//      if(ext.getJenkins().isEnabled()) {
//        config.add(new JenkinsConfigure());
//      }

        config.apply();
      });

    }catch (Exception e) {

      e.printStackTrace();
    }

  }
}


