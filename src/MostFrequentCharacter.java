import java.util.HashMap;
import java.util.Map;

public class MostFrequentCharacter {
    public static char findMostFrequent(String str) {
        Map<Character, Integer> charCount = new HashMap<>();
        char mostFrequentChar = '\0';
        int maxCount = 0;

        // Count occurrences of each character
        for (char ch : str.toCharArray()) {
            charCount.put(ch, charCount.getOrDefault(ch, 0) + 1);

            // Update most frequent character if needed
            if (charCount.get(ch) > maxCount) {
                maxCount = charCount.get(ch);
                mostFrequentChar = ch;
            }
        }

        return mostFrequentChar;
    }

    public static void main(String[] args) {
        String input = "success";
        System.out.println("Most frequent character: " + findMostFrequent(input)); // Output: 's'
    }
}
