/**
 * Problem 2 - The Typing Speed Test Accuracy Checker
 * Name: Gursimran Bajwa   |   Reg. No: RA2511003011289
 */
public class TypingSpeedAccuracyChecker {

    /* Compares the typed text with the original, position by position. */
    public static void checkTypingAccuracy(String original, String typed) {
        if (original.length() != typed.length()) {
            System.out.println("Error: both strings must be of equal length.");
            return;
        }

        int total = original.length();
        int matched = 0;
        int firstMismatchPosition = -1;

        for (int i = 0; i < total; i++) {
            if (original.charAt(i) == typed.charAt(i)) {
                matched++;
            } else if (firstMismatchPosition == -1) {
                firstMismatchPosition = i;          // remember the very first slip
            }
        }

        double accuracy = (matched * 100.0) / total;
        System.out.print("Matched: " + matched + "/" + total
                + " | Accuracy: " + String.format("%.2f", accuracy) + "%");

        if (firstMismatchPosition == -1) {
            System.out.println(" | No Mismatches");
        } else {
            System.out.println(" | First Mismatch at position " + (firstMismatchPosition + 1)
                    + " ('" + original.charAt(firstMismatchPosition)
                    + "' vs '" + typed.charAt(firstMismatchPosition) + "')");
        }
    }

    public static void main(String[] args) {
        String[][] attempts = {
                { "hello world", "hello worlt" },
                { "coding",      "coding"      },
                { "java strings","jawa strimgs"}
        };

        for (String[] attempt : attempts) {
            System.out.println("Original: \"" + attempt[0] + "\"  |  Typed: \"" + attempt[1] + "\"");
            checkTypingAccuracy(attempt[0], attempt[1]);
            System.out.println();
        }
    }
}
