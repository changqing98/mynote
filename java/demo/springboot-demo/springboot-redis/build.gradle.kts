repositories {
  mavenCentral()
}

dependencies {
  compile("org.springframework.boot", "spring-boot-starter-data-redis")
  compile("org.apache.commons", "commons-pool2", "2.7.0")
  compile("com.fasterxml.jackson.core", "jackson-databind", "2.9.9.3")
  compile ("com.alibaba:fastjson:1.2.61")

}

