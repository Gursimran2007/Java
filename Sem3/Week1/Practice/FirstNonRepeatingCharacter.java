/**
 * Problem 4 - First Non-Repeating Character (Unique Letter Hunt Mini-Game)
 * Name: Gursimran Bajwa   |   Reg. No: RA2511003011289
 */
public class FirstNonRepeatingCharacter {

    /* Returns the first character with frequency 1, or '\0' when none exists. */
    public static char findFirstNonRepeatingChar(String text) {
        int[] frequency = new int[256];          // ASCII frequency table

        for (int i = 0; i < text.length(); i++) {
            frequency[text.charAt(i)]++;
        }
        for (int i = 0; i < text.length(); i++) {
            if (frequency[text.charAt(i)] == 1) {
                return text.charAt(i);           // early exit on the first hit
            }
        }
        return '\0';                             // sentinel: nothing unique
    }

    public static void main(String[] args) {
        String[] inputs = { "swiss", "aabbcc", "programming", "step sem 3" };

        for (String text : inputs) {
            char result = findFirstNonRepeatingChar(text);
            System.out.println("Input: \"" + text + "\"");
            if (result == '\0') {
                System.out.println("  No Non-Repeating Character Found");
            } else {
                System.out.println("  First Non-Repeating Character: '" + result + "'");
            }
        }
    }
}
