
// Inspired by Youtube Video
// Inputs are numbers, the 2 paired number represents the ASCII letter.
// I think this program only requires to decrypt the encrypted input.
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Cipher3 {
    public static void main(String[] args) {
 
    }

    private static String decrypt(String input, int shift) {
        StringBuilder decryptedInput = new StringBuilder();
        String sanitizedInput = sanitize(input);

        for(String line: sanitizedInput.split("\n")) {
            StringBuilder decryptedLine = new StringBuilder();
            
            for(int currIdx = 0; currIdx < line.length() - 1; currIdx+=2) {
                int charDigit = Integer.parseInt(line.substring(currIdx, currIdx + 2));

                decryptedLine.append((char) (charDigit + shift));
            }

            decryptedInput.append(decryptedLine.toString().concat("\n"));
        }

        return decryptedInput.toString().trim();
    }

    private static String readFileContent(String fileName) {
        StringBuilder fileContent = new StringBuilder();
        File fileObj = new File(fileName);

        try {
            Scanner fileObjScanner = new Scanner(fileObj);
            
            while(fileObjScanner.hasNext()) {
                String line = fileObjScanner.next();

                fileContent.append(line.concat("\n"));
            }
            
            fileObjScanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error. File not found.");
            e.printStackTrace();
        }

        return fileContent.toString().trim();
    }

    // removes all other characters other than the digits
    private static String sanitize(String input) {
        StringBuilder sanitizedInput = new StringBuilder();
        final String CHARS_TO_REMOVE = "-_&";

        for(char ch: input.toCharArray()) {
            // if the current character is not included in charsToRemove, We will add it to the StringBuilder
            if(CHARS_TO_REMOVE.indexOf(ch) == -1) {
                sanitizedInput.append(ch);
            }
        }
        return sanitizedInput.toString();
    }
}
