package com.kt.extension;

import groovy.lang.Closure;
import lombok.Getter;
import org.gradle.util.ConfigureUtil;

@Getter
public class BaseExtension {

  private Repository repository;

  private SpringBoot springBoot;

  private Publish publish;

  private Jenkins jenkins;

  public void setRepository(Closure c) {
    var r = new Repository();
    ConfigureUtil.configure(c, r);
  }

  public void setSpringBoot(Closure c) {
    var s = new SpringBoot();
    ConfigureUtil.configure(c, s);
  }

  public void setPublish(Closure c) {
    var p = new Publish();
    ConfigureUtil.configure(c, p);
  }

  public void setJenkins(Closure c) {
    var j = new Jenkins();
    ConfigureUtil.configure(c, j);
  }
}
