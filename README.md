# Notes  

## Classpath  

To load classes in a java program temporarily at runtime
- command `java -cp .:<jarfilepath> <javaclass>`
- example `java -cp .:./jarfile.jar App`  

Multiple path can be defined by separating them with colon `:`. For the example above, the current directory and the jarfile path is set as the classpath.  

## `lib` Directory  

extenernal libraries like jar files inside the lib directory are automatically picked up by the IDE to provide intellisense and add it to classpath when <mark>running a program using IDE</mark>.