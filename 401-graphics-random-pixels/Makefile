all: clean compile build_jar run_jar 

compile:
	mkdir -p build
	javac -d build src/*.java

build_jar:
	jar cfe build/myapp.jar MainApp -C build .

run_jar:
	java -jar build/myapp.jar

clean:
	rm -rf build