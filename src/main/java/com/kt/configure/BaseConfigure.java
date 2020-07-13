package com.kt.configure;

import java.util.ArrayList;
import java.util.List;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.gradle.api.Project;

@RequiredArgsConstructor(staticName = "of")
public class BaseConfigure {

  private List<Configurable> list = new ArrayList();

  @NonNull
  private Project project;


  public void apply() {
    for (Configurable c : list) {
      c.apply(project);
    }
  }

  public BaseConfigure add(Configurable configurable) {
    list.add(configurable);
    return this;
  }

}
