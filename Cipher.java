import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;


// Wrong solution
public class Cipher {

    public static void main(String[] args) {
        ArrayList<String> inputLines = new ArrayList<String>();
        // File handle
        File inputFile = new File("input.txt");

        try {
            // Scanner reads the file thru file handle
            Scanner myReader = new Scanner(inputFile);
            while (myReader.hasNextLine()) {
                String line = myReader.nextLine();
                inputLines.add(line);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred when reading the file.");
            e.printStackTrace();
        }

        ArrayList<String> encryptedInputLines = new ArrayList<String>();

        for (String inputLine : inputLines) {
            char[] inputLineChars = inputLine.toCharArray();

            StringBuilder encryptedInputLineBuilder = new StringBuilder();

            // encrypt the text
            for (char inputLineChar : inputLineChars) {
                if (Character.isLetter(inputLineChar)) {
                    encryptedInputLineBuilder.append((char) (inputLineChar + 3));
                } else {
                    encryptedInputLineBuilder.append(inputLineChar);
                }
            }

            String encryptedInputLine = encryptedInputLineBuilder.toString();
            encryptedInputLines.add(encryptedInputLine);
        }

        String stringToBeWritten = "";

        for (int i = 0; i < encryptedInputLines.size(); i++) {
            String text = encryptedInputLines.get(i) + "\n";

            stringToBeWritten += text;
        }

        System.out.println(stringToBeWritten);

        try {
            FileWriter myWriter = new FileWriter("encrypted.txt");
            myWriter.write(stringToBeWritten);
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

}