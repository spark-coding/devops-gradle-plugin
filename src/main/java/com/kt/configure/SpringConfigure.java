package com.kt.configure;

import org.springframework.boot.gradle.plugin.SpringBootPlugin;

import io.spring.gradle.dependencymanagement.DependencyManagementPlugin;
import io.spring.gradle.dependencymanagement.dsl.DependencyManagementExtension;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.gradle.api.Project;
import org.gradle.api.plugins.GroovyPlugin;
import org.gradle.api.plugins.JavaPlugin;

import com.kt.extension.BaseExtension;

import static java.lang.String.format;

@Getter
@RequiredArgsConstructor
public class SpringConfigure implements Configurable, NameAware {

  private final String name = "SpringBoot";

  private final String springBom = "org.springframework.boot:spring-boot-starter-parent:{}";

  @Override
  public void apply(Project project) {
    var ext = project.getExtensions().getByType(BaseExtension.class);

    project.getPluginManager()
        .apply(JavaPlugin.class);

    project.getPluginManager()
        .apply(GroovyPlugin.class);

    project.getPluginManager()
        .apply(SpringBootPlugin.class);

    project.getPluginManager()
        .apply(DependencyManagementPlugin.class);

    project.getExtensions().configure(DependencyManagementExtension.class, dme ->
      dme.imports(importsHandler ->
          importsHandler.mavenBom(format(springBom, ext.getSpringBoot().getVersion()))
      )
    );
  }

}
