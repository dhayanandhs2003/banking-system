import java.util.LinkedHashMap;
import java.util.Map;

public class FirstNonRepeatingCharacter {
    public static char findFirstNonRepeating(String str) {
        Map<Character, Integer> charCount = new LinkedHashMap<>();

        // Count occurrences of each character
        for (char ch : str.toCharArray()) {
            charCount.put(ch, charCount.getOrDefault(ch, 0) + 1);
        }

        // Find the first character with count 1
        for (Map.Entry<Character, Integer> entry : charCount.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }

        return '\0'; // Return null character if no non-repeating character exists
    }

    public static void main(String[] args) {
        String input1 = "Hexaware";
        String input2 = "aabbccdde";

        System.out.println("First non-repeating character: " + findFirstNonRepeating(input1)); // H
        System.out.println("First non-repeating character: " + findFirstNonRepeating(input2)); // e
    }
}
