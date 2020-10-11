plugins {
  idea
  `java-library`
  `maven-publish`
  id("org.springframework.boot") version "2.3.0.RELEASE"
  id("io.spring.dependency-management") version "1.0.9.RELEASE"
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

  dependencyManagement {
    imports {
      mavenBom("com.alibaba.cloud:spring-cloud-alibaba-dependencies:2.2.0.RELEASE");
      mavenBom("org.springframework.cloud:spring-cloud-dependencies:Hoxton.SR1");
    }
  }
}
