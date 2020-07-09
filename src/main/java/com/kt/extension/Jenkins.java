package com.kt.extension;

import lombok.Data;

@Data
public class Jenkins {

  private boolean enabled;

  private String url;

  private String token;

  private String jobName;
}
