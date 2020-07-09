package com.kt.trigger;

import lombok.RequiredArgsConstructor;

import com.kt.extension.BaseExtension;

@RequiredArgsConstructor(staticName = "of")
public class SlackTrigger implements Trigger{

  private final BaseExtension extension;

  @Override
  public void run() {

  }
}
