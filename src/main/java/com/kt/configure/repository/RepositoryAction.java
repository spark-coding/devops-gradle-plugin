package com.kt.configure.repository;

import java.net.URI;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.gradle.api.Action;
import org.gradle.api.Project;
import org.gradle.api.artifacts.repositories.MavenArtifactRepository;

import com.kt.extension.BaseExtension;


@RequiredArgsConstructor(staticName = "of")
public class RepositoryAction implements Action<MavenArtifactRepository> {

  @NonNull
  private Project project;

  @Override
  public void execute(MavenArtifactRepository mavenArtifactRepository) {
    var ext = project.getExtensions().getByType(BaseExtension.class);

    mavenArtifactRepository.setUrl(URI.create(ext.getRepository().getUrl()));
    mavenArtifactRepository.setName(ext.getRepository().getName());
    mavenArtifactRepository.credentials(CredentialsAction.of(ext.getRepository().getUsername(),
        ext.getRepository().getPassword()));
  }

}
