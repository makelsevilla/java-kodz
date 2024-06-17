import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        // Scanner in = new Scanner(System.in);

        // System.out.println("Enter something: ");
        // String input = in.next();

        // System.out.println("Input: " + input);

        // in.close();
        
        // String[] samp = new String[3];

        // samp[2] = "hello";
        // System.out.println(samp);
        for(String text: groupStringChars("hihihihih2", 2)) {
            System.out.println(text);
        }
    }

    private static String[] groupStringChars(String input, int groupSize) throws IllegalArgumentException{
        if(input.length() < 1 || groupSize < 1) {
            throw new IllegalArgumentException("input or groupSize must be greater than 0");
        }

        if(input.length() % groupSize != 0) {
            throw new IllegalArgumentException("input length must be divisible by groupSize");
        }

        String[] res = new String[(int) input.length() / groupSize];

        int resIdx = 0;
        for(int idx = 0; idx < input.length(); idx+=groupSize) {
            res[resIdx] = input.substring(idx, idx+groupSize);
            resIdx++;
        }
        
        return res;
    }
}
