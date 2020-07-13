package com.kt.trigger;

import com.cdancy.jenkins.rest.JenkinsClient;
import lombok.RequiredArgsConstructor;

import com.kt.extension.BaseExtension;


@RequiredArgsConstructor(staticName = "of")
public class JenkinsTrigger implements Trigger {

  private final BaseExtension extension;

  @Override
  public void run() {
    JenkinsClient client = JenkinsClient.builder()
        .endPoint(extension.getJenkins().getUrl())
        .token(extension.getJenkins().getToken())
        .build();

    client.api().jobsApi().build(null, extension.getJenkins().getJobName());
  }

}
