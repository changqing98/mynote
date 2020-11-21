dependencies {
  implementation(project(":module-demo"))
  testImplementation("org.junit.jupiter", "junit-jupiter-engine", "5.6.0")
  testImplementation("org.junit.jupiter", "junit-jupiter-api", "5.6.0")
}

tasks.create("unitTests", Test::class) {
  this.useJUnitPlatform()
  this.exclude("**/*ITest*")
}

println(sourceSets.main.get().output.asPath)
sourceSets.forEach { it ->
  run {
    it.allJava.forEach {

    }
  }
}
