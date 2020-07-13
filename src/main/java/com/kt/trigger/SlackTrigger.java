package com.kt.trigger;

import lombok.RequiredArgsConstructor;

import com.kt.extension.DevOpsExtension;

@RequiredArgsConstructor(staticName = "of")
public class SlackTrigger implements Trigger{

  private final DevOpsExtension extension;

  @Override
  public void run() {

  }
}
