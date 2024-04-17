plugins {
    kotlin("plugin.jpa")

}

version = "0.0.1"

allprojects {
    dependencies {
        implementation("org.springframework.boot:spring-boot-starter-data-jpa:2.7.6")
        implementation ("mysql:mysql-connector-java:8.0.27")
    }
}