package com.kt.trigger;

import com.cdancy.jenkins.rest.JenkinsClient;
import lombok.Builder;
import lombok.RequiredArgsConstructor;

import com.kt.extension.DevOpsPluginExtension;


@RequiredArgsConstructor(staticName = "of")
public class JenkinsTrigger implements Trigger {

  private final DevOpsPluginExtension extension;

  @Override
  public void run() {
    JenkinsClient client = JenkinsClient.builder()
        .endPoint(extension.getJenkins().getUrl())
        .token(extension.getJenkins().getToken())
        .build();

    client.api().jobsApi().build(null, extension.getJenkins().getJobName());
  }



}
