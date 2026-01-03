all: build

build:
	mvn clean package

run:
	mvn -q exec:java -Dexec.mainClass=com.example.App -Dexec.jvmArgs="-XstartOnFirstThread"

runjar:
	java -XstartOnFirstThread -jar target/maven-glfw-1.0-SNAPSHOT-jar-with-dependencies.jar

buildMacBundle:
	jpackage \
	--type app-image \
	--name "MavenGLFW" \
	--input target \
	--main-jar maven-glfw-1.0-SNAPSHOT-jar-with-dependencies.jar \
	--java-options "-XstartOnFirstThread" \
	--dest dist

clean:
	rm -rf target
