import java.util.HashMap;

public class Cipher4 {
    public static void main(String[] args) {
        String baseKey = "aAbBcCdDeEfFgGhHiIjJkKlLmMnNoOpPqQrRsStTuUvVwWxXyYzZ\s";
        String encryptionKey = "IBdnlbfPsLWYXqENRmyvVoHJTCDupAcFjOhxwrUazZSiMQGtgekK\n";

        try {

            // convertBaseKeyStringToHashMap test
            System.out.println(convertKeyStringToHashMap("aabbcC"));

            // encrypt test
            String encryptedText = encrypt("Ang ganda ganda mo", baseKey, encryptionKey);
            System.out.println(encryptedText);

            // decrypt test
            System.out.println(decrypt(encryptedText, baseKey, encryptionKey));
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    private static String encrypt(String input, String baseKey, String encryptionKey) throws Exception {
        // baseKey and encryptionKey should be equal in length, if not throw an error
        if (baseKey.length() != encryptionKey.length()) {
            throw new Exception(
                    "The keys provided is not equal in length. Please make sure that the provided keys are correct");
        }

        StringBuilder encryptedInputBuilder = new StringBuilder();

        HashMap<Character, Integer> baseKeyHashMap = convertKeyStringToHashMap(baseKey);
        for (char ch : input.toCharArray()) {
            char inclusionChar;

            // encrypts the character
            if (baseKeyHashMap.get(ch) != null) {
                int currCharBaseKeyIndex = baseKeyHashMap.get(ch);
                inclusionChar = encryptionKey.charAt(currCharBaseKeyIndex);
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
}
