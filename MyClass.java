import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class MyClass {
    public static void main(String[] args) {
        try {

            FileReader myFileReader = new FileReader("input.txt");
            BufferedReader myBufferedReader = new BufferedReader(myFileReader);

            String content = myBufferedReader.readLine();
            myBufferedReader.close();
            myFileReader.close();
            System.out.println(content);
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("Error in reading the file.");
            e.printStackTrace();
        }
    }
}
