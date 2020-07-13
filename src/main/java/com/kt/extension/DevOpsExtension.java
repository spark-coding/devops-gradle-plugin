package com.kt.extension;



import javax.inject.Inject;

import groovy.lang.Closure;
import lombok.Getter;
import org.gradle.api.Action;
import org.gradle.api.model.ObjectFactory;
import org.gradle.util.ConfigureUtil;

@Getter
public class DevOpsExtension {

  private Repository repository;

  private SpringBoot springBoot;

  private Publish publish;

  private Jenkins jenkins;

  @Inject
  public DevOpsExtension(ObjectFactory factory) {
    repository = factory.newInstance(Repository.class);
    springBoot = factory.newInstance(SpringBoot.class);
  }

  public void setRepository(Closure closure) {
    ConfigureUtil.configure(closure, repository);
  }

//  public void setRepository(Action<? super Repository> action) {
//    action.execute(repository);
//  }

  public void setSpringBoot(Action<? super SpringBoot> action) {
    action.execute(springBoot);
  }

  public void setPublish(Closure c) {
//    ConfigureUtil.configure(c, publish);
    c.setResolveStrategy(Closure.DELEGATE_FIRST);
    c.setDelegate(publish);
  }

  public void setJenkins(Closure c) {
//    ConfigureUtil.configure(c, jenkins);
    c.setResolveStrategy(Closure.DELEGATE_FIRST);
    c.setDelegate(jenkins);
  }
}
