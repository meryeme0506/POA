doc:
	javadoc Components/*.java GUI/*.java Main/*.java Solve/*.java -d docs

classes : 
	javac Components/*.java GUI/*.java Main/*.java Solve/*.java -d classes


jar:
	cd classes;\
		jar cvfm ../appli.jar ../manifest-ex Components/*.class GUI/*.class Main/*.class Solve/*.class
		java -jar appli.jar

clean:
	rm -rf docs
	rm -rf classes
	rm -rf appli.jar