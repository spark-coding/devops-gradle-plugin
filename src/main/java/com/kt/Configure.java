package com.kt;

public interface Configure {

  String bom = "org.springframework.boot:spring-boot-starter-parent:2.3.1.RELEASE";

  void configureSpringBoot();

  void configurePublishing();

  void configureRepository();

  void configureDependency();

  void configureDocumentation();
}
