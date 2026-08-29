/**
 * Problem 5 - The Movie Review Word Length Profiler
 * Name: Gursimran Bajwa   |   Reg. No: RA2511003011289
 */
public class MovieReviewWordLengthProfiler {

    /* Splits the review and buckets every word by its length. */
    public static void classifyWordLengths(String review) {
        String[] words = review.trim().split("\\s+");

        int shortWords = 0, mediumWords = 0, longWords = 0;

        for (String word : words) {
            if (word.isEmpty()) continue;

            int length = word.length();
            if (length <= 4)       shortWords++;      // Short  : 1-4 letters
            else if (length <= 8)  mediumWords++;     // Medium : 5-8 letters
            else                   longWords++;       // Long   : 9+ letters
        }

        System.out.println("Short: " + shortWords
                + " | Medium: " + mediumWords
                + " | Long: " + longWords);
    }

    public static void main(String[] args) {
        String[] reviews = {
                "This movie was absolutely fantastic and thrilling",
                "Bad plot slow pace",
                "An extraordinarily breathtaking cinematographic achievement"
        };

        for (String review : reviews) {
            System.out.println("Review: \"" + review + "\"");
            classifyWordLengths(review);
            System.out.println();
        }
    }
}
