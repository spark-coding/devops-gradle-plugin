package com.kt;

import java.net.URI;

import org.gradle.api.Action;
import org.gradle.api.artifacts.repositories.MavenArtifactRepository;

public class RepositoryAction implements Action<MavenArtifactRepository> {

  final String url = "http://repo.chelsea.kt.co.kr/repository/maven-sw-public/";

  @Override
  public void execute(MavenArtifactRepository mavenArtifactRepository) {
    mavenArtifactRepository.setUrl(URI.create(url));
    mavenArtifactRepository.setName("kt");
  }
}
