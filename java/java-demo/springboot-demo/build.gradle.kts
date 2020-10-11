buildscript {
  repositories {
    mavenLocal()
    maven("https://maven.aliyun.com/repository/spring")
    maven("https://maven.aliyun.com/repository/spring-plugin")
    maven("https://maven.aliyun.com/repository/public")
    mavenCentral()
    jcenter()
  }

  dependencies {
    classpath("org.springframework.boot", "spring-boot-gradle-plugin", "2.3.0.RELEASE")
    classpath("io.freefair.gradle", "lombok-plugin", "3.2.1")
    classpath("com.diffplug.spotless", "spotless-plugin-gradle", "3.25.0")
  }
}

plugins {
  idea
  `java-library`
  `maven-publish`
}

group = "com.yechangqing"
version = "1.0.0-SNAPSHOT"

allprojects {
  apply(plugin = "org.springframework.boot")
  apply(plugin = "io.spring.dependency-management")
  apply(plugin = "java-library")

  dependencies {
    api("org.springframework.boot", "spring-boot-starter")
    api("org.springframework.boot", "spring-boot-starter-test")
    testImplementation("org.junit.jupiter", "junit-jupiter-api", "5.6.0")
  }
  configure<JavaPluginConvention> {
    sourceCompatibility = JavaVersion.VERSION_11
  }

  repositories {
    mavenLocal()
    maven("https://maven.aliyun.com/repository/spring")
    maven("https://maven.aliyun.com/repository/spring-plugin")
    maven("https://maven.aliyun.com/repository/public")
    mavenCentral()
    jcenter()
  }
}
