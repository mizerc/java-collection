# About

# Maven

## Creating maven project

Maven has a built-in `archetype` system that can create a standard project structure automatically from the CLI.

```shell
mvn archetype:generate \
-DgroupId=com.example \
-DartifactId=maven-hello-world \
-DarchetypeArtifactId=maven-archetype-quickstart \
-DinteractiveMode=false
```
