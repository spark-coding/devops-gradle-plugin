package com.kt;

import java.net.URI;

import javax.annotation.Nullable;

import org.gradle.api.Action;
import org.gradle.api.artifacts.repositories.MavenArtifactRepository;
import org.gradle.api.artifacts.repositories.PasswordCredentials;
import org.gradle.api.credentials.Credentials;

public class RepositoryAction implements Action<MavenArtifactRepository> {

  final String url = "http://repo.chelsea.kt.co.kr/repository/maven-sw-public/";

  @Override
  public void execute(MavenArtifactRepository mavenArtifactRepository) {
    mavenArtifactRepository.setUrl(URI.create(url));
    mavenArtifactRepository.setName("kt");

//    Credentials credentials = authenticationSupport().
//
//    mavenArtifactRepository.authentication(auth -> {
//      auth.create(, ).
//    });
  }
}
