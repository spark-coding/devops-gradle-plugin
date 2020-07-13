package com.kt.configure.repository;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.gradle.api.Action;
import org.gradle.api.credentials.PasswordCredentials;

@RequiredArgsConstructor(staticName = "of")
public class CredentialsAction implements Action<PasswordCredentials> {

  @NonNull
  private String username;

  @NonNull
  private String password;

  @Override
  public void execute(PasswordCredentials passwordCredentials) {
    passwordCredentials.setUsername(username);
    passwordCredentials.setPassword(password);
  }
}
