import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileRW {

    public static void main(String[] args) {

        writeFile("./input.txt", "Hello Universe");
        System.out.println(readFile("./input.txt"));
    }

    public static String readFile(String fileName) {
        StringBuilder content = new StringBuilder();

        try {
            File fileObj = new File(fileName);
            Scanner reader = new Scanner(fileObj);

            while (reader.hasNextLine()) {
                String data = reader.nextLine() + "\n";
                content.append(data);
            }
        } catch (FileNotFoundException e) {
            // TODO: handle exception
            System.out.println("An error occured while reading the file.");
            e.printStackTrace();
        }

        // trim() removes the excess "\n" or any whitespaces at the end of the string.
        return content.toString().trim();
    }

    public static void writeFile(String fileName, String content) {
        try {
            FileWriter writer = new FileWriter(fileName);
            writer.write(content);
            writer.close();

            System.out.println("Successfuly written in file " + fileName);
        } catch (IOException e) {
            // TODO: handle exception
            System.out.println("An error occured while writing in a file.");
            e.printStackTrace();
        }
    }

}
