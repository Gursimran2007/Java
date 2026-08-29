/**
 * Problem 2 - Palindrome Checker, 3 Approaches (QA Text Verification Toolkit)
 * Name: Gursimran Bajwa   |   Reg. No: RA2511003011289
 */
public class PalindromeChecker {

    /* Approach 1 - iterative two-pointer comparison. */
    public static boolean isPalindromeIterative(String text) {
        int left = 0, right = text.length() - 1;
        while (left < right) {
            if (text.charAt(left) != text.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }

    /* Approach 2 - recursion: compare the ends, then shrink the substring. */
    public static boolean isPalindromeRecursive(String text) {
        if (text.length() <= 1) return true;
        if (text.charAt(0) != text.charAt(text.length() - 1)) return false;
        return isPalindromeRecursive(text.substring(1, text.length() - 1));
    }

    /* Approach 3 - convert to a char array, reverse it, compare with the original. */
    public static boolean isPalindromeArrayReversal(String text) {
        char[] chars = text.toCharArray();
        char[] reversed = new char[chars.length];
        for (int i = 0; i < chars.length; i++) {
            reversed[i] = chars[chars.length - 1 - i];
        }
        return text.equals(new String(reversed));
    }

    private static String label(boolean isPalindrome) {
        return isPalindrome ? "Palindrome" : "Not Palindrome";
    }

    public static void main(String[] args) {
        String[] inputs = { "madam", "hello", "racecar", "step" };

        for (String text : inputs) {
            boolean a = isPalindromeIterative(text);
            boolean b = isPalindromeRecursive(text);
            boolean c = isPalindromeArrayReversal(text);

            System.out.println("Input: \"" + text + "\"");
            System.out.println("  Iterative: " + label(a)
                    + " | Recursive: " + label(b)
                    + " | Array Reversal: " + label(c));
            System.out.println("  All three approaches agree: " + ((a == b) && (b == c)));
            System.out.println();
        }
    }
}
