import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

// Inspired by chatGPT
public class Cipher2 {
    public static void main(String[] args) {
        String inputText = readFile("input.txt");
        String encryptedText = encrypt(inputText, 3);
        writeFile("encrypted.txt", encryptedText);
        
        String encryptedTextContent = readFile("encrypted.txt");
        String decryptedText = decrypt(encryptedTextContent, 3);
        writeFile("decrypted.txt", decryptedText);

        System.out.println("Done!");
    }

    private static String readFile(String fileName) {
        StringBuilder content = new StringBuilder();

        try {
            File fileObj = new File(fileName);
            Scanner reader = new Scanner(fileObj);

            while(reader.hasNextLine()) {
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

    private static void writeFile(String fileName, String content) {
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

    private static String encrypt(String text, int shift) {
        StringBuilder encryptedText = new StringBuilder();

        for(char ch: text.toCharArray()) {
            if(Character.isLetter(ch)) {
                char shifted = (char) (ch + shift);

                if(Character.isUpperCase(ch)) {
                    shifted = (char) ((shifted - 'A') % 26 + 'A');
                } else {
                    shifted = (char) ((shifted - 'a') % 26 + 'a');
                }
                
                encryptedText.append(shifted);
            } else {
                encryptedText.append(ch);
            }
        }

        return encryptedText.toString();
    }

    private static String decrypt(String text, int shift) {
        return encrypt(text, -shift);
        // or
        // return encrypt(text, 26 - shift);
    }
}
