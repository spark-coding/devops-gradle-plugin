package com.kt.configure;

import org.springframework.boot.gradle.plugin.SpringBootPlugin;

import io.spring.gradle.dependencymanagement.DependencyManagementPlugin;
import io.spring.gradle.dependencymanagement.dsl.DependencyManagementExtension;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.gradle.api.Project;
import org.gradle.api.plugins.GroovyPlugin;

import com.kt.extension.DevOpsExtension;

import static java.lang.String.format;

@Getter
@RequiredArgsConstructor
public class SpringConfigure implements Configurable, NameAware {

  private final String name = "SpringBoot";

  private final String springBom = "org.springframework.boot:spring-boot-starter-parent:2.3.1.RELEASE";

  @Override
  public void apply(Project project) {
    var ext = project.getExtensions().getByType(DevOpsExtension.class);


    project.getPluginManager()
        .apply(GroovyPlugin.class);

    project.getPluginManager()
        .apply(SpringBootPlugin.class);

    project.getPluginManager()
        .apply(DependencyManagementPlugin.class);

    project.getExtensions().configure(DependencyManagementExtension.class, dme ->
      dme.imports(importsHandler ->
          importsHandler.mavenBom(springBom)
      )
    );
  }

}
