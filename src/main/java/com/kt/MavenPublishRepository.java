package com.kt;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class MavenPublishRepository {

  private String url;

  private String username;

  private String password;

  public static MavenPublishRepository kt() {
    return MavenPublishRepository.builder()
        .url("http://repo.chelsea.kt.co.kr/repository/maven-sw-release/")
        .username("geniecube")
        .password("new1234!")
        .build();
  }
}
