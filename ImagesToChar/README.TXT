rm -rf target/*
cd target && jar xf ../lib/jcommander-1.82.jar
cd target && jar xf ../lib/JColor-5.5.1.jar
javac -cp target -sourcepath src/java -d target src/java/edu/school21/printer/app/Program.java
cp -R src/resources target
jar cvfm target/images-to-chars-printer.jar src/manifest.txt -C target .
java -jar target/images-to-chars-printer.jar --white=BLACK --black=CYAN
