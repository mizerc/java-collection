## About

Using MAVEN to add lwjgl library to use Java with OpenGL.
Which needs the GLFW natives (C library ) installed in the host machine.

## Creating new maven project

Maven has a built-in `archetype` system that can create a standard project structure automatically from the CLI.

```shell
mvn archetype:generate \
-DgroupId=com.example \
-DartifactId=maven-glfw \
-DarchetypeArtifactId=maven-archetype-quickstart \
-DinteractiveMode=false
```

Later you add deps to pom.xml from https://www.lwjgl.org/customize.

Make sure you get MacOS arm64 instead of MacOS x64 if using M1-M5 CPUs.

## Makefile

```txt
all: build
build:
	mvn clean package
run:
	java -jar target/hello-world-maven-1.0-SNAPSHOT.jar
```
