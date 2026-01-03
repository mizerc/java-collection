# Default target: compile
all: clean compile build_jar run_jar 

compile:
	mkdir -p build
	javac -d build src/*.java

# Create a JAR file
build_jar:
	jar cfe build/helloworld.jar HelloWorld -C build .

run_class:
	java --classpath build HelloWorld

run_jar:
	java -jar build/helloworld.jar

print_debug:
	javap -v build/HelloWorld.class

# Clean build files
clean:
	rm -rf build