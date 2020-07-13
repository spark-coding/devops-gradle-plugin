package com.kt.configure;

import lombok.Getter;
import org.gradle.api.Project;
import org.gradle.api.publish.maven.plugins.MavenPublishPlugin;
import org.gradle.plugins.signing.SigningPlugin;

import com.kt.extension.DevOpsExtension;

@Getter
public class PublishConfigure implements Configurable, NameAware {

  private String name = "Publish";

  @Override
  public void apply(Project project) {
    project.getPluginManager().apply(SigningPlugin.class);
    project.getPluginManager().apply(MavenPublishPlugin.class);

    var ext = project.getExtensions().getByType(DevOpsExtension.class);
    var log = project.getLogger();

    if (ext.getPublish().isEnabled()) {
      project.getRepositories().forEach(a -> log.lifecycle("- Artifact Repository : {}", a.getName()));
    }
  }
}
