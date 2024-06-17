import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

/**
 * @author makelsevilla
 * I've found online that this is the type of Cipher program that DICT is using for the hands-on examination of ICT Proficiency Certification
 */
public class Cipher5 {
    public static void main(String[] args) {
        // String baseKey = "aAbBcCdDeEfFgGhHiIjJkKlLmMnNoOpPqQrRsStTuUvVwWxXyYzZ\s";
        // String encryptionKey = "IBdnlbfPsLWYXqENRmyvVoHJTCDupAcFjOhxwrUazZSiMQGtgekK\n";

        String[] baseKey = {"H", "E", "L", "O"}; 
        String[] encryptionKey = {"10", "11", "12", "13"};

        try {

            // convertBaseKeyStringToHashMap test
            String[] key = { "a", "11" };
            // System.out.println(convertKeyToHashMap(key));

            // encrypt test
            String encryptedText = encrypt("HELLO", baseKey, encryptionKey, 3);
            System.out.println(encryptedText);

            // decrypt test
            System.out.println(decrypt(encryptedText, baseKey, encryptionKey, 3));
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println(e.getMessage());
        }
    }

    // convert keys to be an Array of String
    private static String encrypt(String input, String baseKey, String encryptionKey, int shift) throws Exception {
        String[] groupedBaseKey = groupStringChars(baseKey, 1);
        String[] groupedEncryptionKey = groupStringChars(encryptionKey, 1);

        return encrypt(input, groupedBaseKey, groupedEncryptionKey, shift);
    }

    private static String encrypt(String input, String[] baseKey, String[] encryptionKey, int shift) throws Exception {
        // Validate keys
        String[][] keys = { baseKey, encryptionKey };
        if (!validateKeys(keys)) {
            throw new Exception("The keys provided are not valid.");
        }

        int KEYS_LENGTH = baseKey.length;

        StringBuilder encryptedInput = new StringBuilder();

        HashMap<String, Integer> baseKeyHashMap = convertKeyToHashMap(baseKey);

        // baseKey elements length
        // kung ano yung length ng baseKey elements, yun ang kukunin sa input param.
        int baseKeyElemLength = baseKey[0].length();

        try {
            for (String segment : groupStringChars(input, baseKeyElemLength)) {
                String includeStr;

                // encrypts the character
                if (baseKeyHashMap.get(segment) != null) {
                    int currBaseKeyIndex = baseKeyHashMap.get(segment);

                    int shiftedKeyIndex = (currBaseKeyIndex + shift) % KEYS_LENGTH;

                    includeStr = encryptionKey[shiftedKeyIndex];
                } else {
                    includeStr = segment;
                }

                encryptedInput.append(includeStr);
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Input is not valid for Encrypting and Decrypting with the provided keys.");
            e.printStackTrace();
        }

        String encryptedStr = encryptedInput.toString();

        return encryptedStr;
    }

    // if String is passed instead of String[]
    // the keys will be needed to be segmented to 1 and returned as String[]
    // we can use the groupStringChars for that
    private static String decrypt(String input, String baseKey, String encryptionKey, int shift) throws Exception {
        String[] groupedBaseKey = groupStringChars(baseKey, 1);
        String[] groupedEncryptionKey = groupStringChars(encryptionKey, 1);

        return decrypt(input, groupedBaseKey, groupedEncryptionKey, shift);
    }

    private static String decrypt(String input, String[] baseKey, String[] encryptionKey, int shift) throws Exception {

        // returning shift with (baseKey.length - shift) will make sure that the modulo
        // operation
        // in encrypt method always return a positive value
        // if baseKey.length is not added here, it will be needed to add in the encrypt
        // methods
        return encrypt(input, encryptionKey, baseKey, baseKey.length - shift);
    }

    private static String[] groupStringChars(String input, int groupSize) throws IllegalArgumentException {
        if (input.length() < 1 || groupSize < 1) {
            throw new IllegalArgumentException("input or groupSize must be greater than 0");
        }

        // System.out.println(input.length() + "%" + groupSize);
        if (input.length() % groupSize != 0) {
            throw new IllegalArgumentException("input length must be divisible by groupSize");
        }

        String[] res = new String[(int) input.length() / groupSize];

        int resIdx = 0;
        for (int idx = 0; idx < input.length(); idx += groupSize) {
            res[resIdx] = input.substring(idx, idx + groupSize);
            resIdx++;
        }

        return res;
    }

    // for fast searching of character index
    private static HashMap<String, Integer> convertKeyToHashMap(String[] key) {
        HashMap<String, Integer> keyIndexMap = new HashMap<>();

        // int currKeyIndexMap = 0;
        for (int currIdx = 0; currIdx < key.length; currIdx++) {
            String currEl = key[currIdx];

            keyIndexMap.put(currEl, currIdx);

            // removed the duplicate ignore, because we are already checking
            // if the key is valid or not at the top of encrypt method
            // if (!keyIndexMap.containsKey(currEl)) {
            // keyIndexMap.put(currEl, currKeyIndexMap);
            // currKeyIndexMap++;
            // }
        }

        return keyIndexMap;
    }

    private static boolean validateKeys(String[][] keys) {
        // check if all the keys are equal in length

        // get the length of each key and add it to HashSet
        HashSet<Integer> distinctKeyLengths = new HashSet<>();
        for (String[] key : keys) {
            // validate each key using validateKey()
            // if invalid, return false
            if (!validateKey(key)) {
                return false;
            }

            distinctKeyLengths.add(key.length);
        }

        // check if the length of HashSet exceeds 1
        // if yes, return false
        if (distinctKeyLengths.size() > 1) {
            return false;
        }

        // if all have passed
        return true;
    }

    /**
     * 
     * @param key
     * @return True if the key is valid.
     */
    private static boolean validateKey(String[] key) {
        // must not have duplicate characters
        int distinctCharsCount = new HashSet<>(Arrays.asList(key)).size();
        if (distinctCharsCount != key.length) {
            return false;
        }

        // all of the key segment(key elements) must equal in length
        int segmentLength = key[0].length();
        for(String segment: key) {
            if(segment.length() != segmentLength) {
                return false;
            }
        }

        return true;
    }

}
