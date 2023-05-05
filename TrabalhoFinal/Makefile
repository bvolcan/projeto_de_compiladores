build:
	javacc -output_directory=./ClassDump Lugosi.jj && javac -d ./ClassDump ./ClassDump/*.java

run:
	java -cp ./ClassDump Lugosi exemplo.lug