import java.util.HashMap;
import java.util.HashSet;


// Just like Cipher4 but with shifting
public class Cipher5 {
    public static void main(String[] args) {
        String baseKey = "aAbBcCdDeEfFgGhHiIjJkKlLmMnNoOpPqQrRsStTuUvVwWxXyYzZ\s";
        String encryptionKey = "IBdnlbfPsLWYXqENRmyvVoHJTCDupAcFjOhxwrUazZSiMQGtgekK\n";


        try {

            // convertBaseKeyStringToHashMap test
            System.out.println(convertKeyStringToHashMap("aabbcC"));

            // encrypt test
            String encryptedText = encrypt("ang ganda ganda mo Z", baseKey, encryptionKey, 3);
            System.out.println(encryptedText);

            // decrypt test
            System.out.println(decrypt(encryptedText, baseKey, encryptionKey, 3));
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    // convert keys to be an Array of String
    private static String encrypt(String input, String baseKey, String encryptionKey) throws Exception {
        return encrypt(input, baseKey, encryptionKey, 0);
    }

    private static String encrypt(String input, String baseKey, String encryptionKey, int shift) throws Exception {
        // Validate keys
        String[] keys = {baseKey, encryptionKey};
        if(!validateKeys(keys)) {
            throw new Exception("The keys provided are not valid.");
        }

        int KEYS_LENGTH = baseKey.length();
        StringBuilder encryptedInputBuilder = new StringBuilder();

        HashMap<Character, Integer> baseKeyHashMap = convertKeyStringToHashMap(baseKey);
        for (char ch : input.toCharArray()) {
            char inclusionChar;

            // encrypts the character
            if (baseKeyHashMap.get(ch) != null) {
                int currBaseKeyIndex = baseKeyHashMap.get(ch);
                int shiftedKeyIndex = currBaseKeyIndex + shift; 
                shiftedKeyIndex = ((shiftedKeyIndex % KEYS_LENGTH) + KEYS_LENGTH) % KEYS_LENGTH;
                
                inclusionChar = encryptionKey.charAt(shiftedKeyIndex);
            } else {
                inclusionChar = ch;
            }

            encryptedInputBuilder.append(inclusionChar);
        }

        return encryptedInputBuilder.toString();
    }

    private static String decrypt(String input, String baseKey, String encryptionKey) throws Exception {

        return encrypt(input, encryptionKey, baseKey);
    }

    private static String decrypt(String input, String baseKey, String encryptionKey, int shift) throws Exception {

        return encrypt(input, encryptionKey, baseKey, -shift);
    }

    // for fast searching of character index
    private static HashMap<Character, Integer> convertKeyStringToHashMap(String key) {
        HashMap<Character, Integer> keyIndexMap = new HashMap<>();

        int currKeyIndexMap = 0;
        for (int currIdx = 0; currIdx < key.length(); currIdx++) {
            char currChar = key.charAt(currIdx);

            // ignore duplicate characters in baseKey
            if (!keyIndexMap.containsKey(currChar)) {
                keyIndexMap.put(currChar, currKeyIndexMap);
                currKeyIndexMap++;
            }
        }

        return keyIndexMap;
    }

    private static boolean validateKeys(String[] keys) {
        // check if all the keys are equal in length

        // get the length of each key and add it to HashSet
        HashSet<Integer> distinctKeyLengths = new HashSet<>();
        for(String key: keys) {
            // validate each key using validateKey()
            // if invalid, return false
            if(! validateKey(key)) {
                return false;
            }

            distinctKeyLengths.add(key.length());
        }

        // check if the length of HashSet exceeds 1
        // if yes, return false
        if(distinctKeyLengths.size() > 1) {
            return false;
        }

        // if all have passed
        return true;
    }

    /**
     * 
     * @param key
     * @return True if the key doesn't have duplicate characters, otherwise False;
     */
    private static boolean validateKey(String key) {
        // must not have duplicate characters
        int distinctCharsCount = (int) key.chars().distinct().count();
        if(distinctCharsCount != key.length()) {
            return false;
        }

        return true;
    }
}
