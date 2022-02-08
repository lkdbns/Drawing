all:
		find . -type f -name '*.class' -exec rm {} +
		javac -d ./build Drawing/*.java
		cd build; jar cvf ../Draw.jar Drawing/*.class