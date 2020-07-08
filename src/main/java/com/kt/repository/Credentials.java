package com.kt.repository;

import javax.annotation.Nullable;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.gradle.api.artifacts.repositories.PasswordCredentials;

@Getter
@RequiredArgsConstructor
public class Credentials implements PasswordCredentials {

  private final String username;

  private final String password;


  @Override
  public void setUsername(@Nullable String s) {

  }

  @Override
  public void setPassword(@Nullable String s) {

  }

  public static Credentials kt() {
    return new Credentials("geniecube", "new1234!");
  }
}
