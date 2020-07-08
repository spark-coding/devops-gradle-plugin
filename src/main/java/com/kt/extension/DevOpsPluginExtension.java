package com.kt.extension;

import groovy.lang.Closure;
import lombok.Getter;
import lombok.Setter;
import org.gradle.util.ConfigureUtil;

@Getter
@Setter
public class DevOpsPluginExtension {

  private boolean publish;

  private JenkinsExtension jenkins;

  public void setJenkins(Closure c) {
    var j = new JenkinsExtension();
    ConfigureUtil.configure(c, j);
  }

}
