# Notes  

## Classpath  

To load classes in a java program temporarily at runtime
- command `java -cp .:<jarfilepath> <javaclass>`
- example `java -cp .:./jarfile.jar App`  

Multiple path can be defined by separating them with colon `:`. For the example above, the current directory and the jarfile path is set as the classpath.