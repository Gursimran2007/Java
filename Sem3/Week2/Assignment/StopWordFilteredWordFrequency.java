import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

/**
 * Problem 5 - Stop-Word-Filtered Word Frequency Report
 * Name: Gursimran Bajwa   |   Reg. No: RA2511003011289
 */
public class StopWordFilteredWordFrequency {

    static final String[] STOP_WORDS = { "the", "was", "and", "a", "is", "of", "in" };

    private static boolean isStopWord(String word) {
        for (String stopWord : STOP_WORDS) {
            if (word.equals(stopWord)) return true;
        }
        return false;
    }

    /* Cleans the text, drops stop words, counts the rest, prints by count descending. */
    public static void printFilteredWordFrequency(String feedback) {
        String cleaned = feedback.toLowerCase()
                                 .replace(".", "")
                                 .replace(",", "")
                                 .replace("!", "")
                                 .replace("?", "");

        String[] words = cleaned.trim().split("\\s+");

        Map<String, Integer> frequency = new HashMap<>();
        for (String word : words) {
            if (word.isEmpty() || isStopWord(word)) continue;
            frequency.put(word, frequency.getOrDefault(word, 0) + 1);
        }

        // Sort the unique words by their count, highest first.
        List<Map.Entry<String, Integer>> entries = new ArrayList<>(frequency.entrySet());
        entries.sort((first, second) -> second.getValue() - first.getValue());

        for (Map.Entry<String, Integer> entry : entries) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    public static void main(String[] args) {
        String[] feedbacks = {
                "The mentor was great, the session was great and clear.",
                "The training in java was useful and the java labs was practical."
        };

        for (String feedback : feedbacks) {
            System.out.println("Feedback: \"" + feedback + "\"");
            System.out.println("Word frequency report:");
            printFilteredWordFrequency(feedback);
            System.out.println();
        }
    }
}
