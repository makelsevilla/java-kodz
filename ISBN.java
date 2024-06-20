import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.nio.Buffer;

/**
 * ISBN are usually written with dashes separating groups of digits.
 */
public class ISBN {
    public static void main(String[] args) {
        // System.out.println("Hello");

        // String sampleISBN = "123456789";

        // // compute 10th digit
        // int productSum = 0;
        // for (int idx = 0; idx < sampleISBN.length(); idx++) {
        //     int multiplier = (sampleISBN.length() + 1) - idx;
        //     int product = Character.getNumericValue(sampleISBN.charAt(idx)) * multiplier;

        //     productSum += product;            
        // }

        // char tentDigit;
        // int remainder = productSum % 11;
        // System.out.println(productSum);
        // System.out.println(remainder);
        // if (remainder < 10) {
        //     tentDigit = Character.forDigit(remainder, 10);
        // } else {
        //     tentDigit = 'X';
        // }

        // System.out.println(sampleISBN + tentDigit);

        System.out.println(readFile("input.txt")); 
        writeFile("output.txt", "null");
        File file = new File("output.txt");

    }

    public static String readFile(String filename) {
        StringBuilder fileContent = new StringBuilder();
        File file = new File(filename);
        
        try {
            FileReader reader = new FileReader(file);            

            // BufferedReader is optional.
            // The benefit of using it is the readLine() method.
            BufferedReader bReader = new BufferedReader(reader);
            String line = bReader.readLine();

            while (line != null) {
                fileContent.append(line);

                line = bReader.readLine();
            }

            bReader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return fileContent.toString();
    }

    public static boolean writeFile(String fileName, String content) {
        try {
            File file = new File(fileName);
            FileWriter writer = new FileWriter(file);
            // BufferedWriter bWriter = new BufferedWriter(writer);

            writer.append('O');
            writer.write("kay");
            writer.write("naman");

            writer.close();
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }

        return true;
    }

    // public String sanitizeString(String s) {

    // }
}