package com.kt;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.gradle.api.Project;

@Getter
@Setter
@Builder
public class MavenPublishPom {

  private String groupId;

  private String artifactId;

  private String version;

  public static MavenPublishPom of(Project project){
    return MavenPublishPom.builder()
        .groupId(project.getGroup().toString())
        .artifactId(project.getName())
        .version(project.getVersion().toString())
        .build();
  }
}
