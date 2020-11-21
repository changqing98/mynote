plugins {
  idea
  `java-library`
  `maven-publish`
}

group = "com.yechangqing"
version = "1.0.0-SNAPSHOT"

allprojects {
  apply(plugin = "java")
  apply(plugin = "java-library")
  repositories {
    mavenLocal()
    maven("https://maven.aliyun.com/repository/public")
    mavenCentral()
    jcenter()
  }
  tasks.test{
    useJUnitPlatform()
  }
}


subprojects {

  dependencies {
    testImplementation("org.junit.jupiter", "junit-jupiter-api", "5.6.0")
  }
  configure<JavaPluginConvention> {
    sourceCompatibility = JavaVersion.VERSION_11
  }
}
