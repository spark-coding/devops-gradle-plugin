package com.kt.configure;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.gradle.api.Project;
import org.gradle.api.publish.maven.plugins.MavenPublishPlugin;
import org.gradle.plugins.signing.SigningPlugin;

import com.kt.MavenPublishPom;
import com.kt.MavenPublishRepository;
import com.kt.RepositoryAction;
import com.kt.extension.BaseExtension;

@RequiredArgsConstructor
public class BaseConfigure2 implements Configure {

  @NonNull
  private Project project;

  private MavenPublishPom pom;

  private MavenPublishRepository repository;

  @Override
  public void configureSpringBoot() {

  }

  @Override
  public void configurePublishing() {
    project.getPluginManager().apply(SigningPlugin.class);
    project.getPluginManager().apply(MavenPublishPlugin.class);

    var ext = project.getExtensions().getByType(BaseExtension.class);

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
  public void configureUnitTest() {

  }

  @Override
  public void configureDependency() {

  }

  @Override
  public void configureDocumentation() {

  }
}
