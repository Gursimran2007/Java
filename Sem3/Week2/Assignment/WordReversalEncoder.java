/**
 * Problem 2 - Word Reversal Encoder ("Mirror Text" Mini-Game)
 * Name: Gursimran Bajwa   |   Reg. No: RA2511003011289
 */
public class WordReversalEncoder {

    /* Reverses every word individually while keeping the word order unchanged. */
    public static String reverseEachWord(String sentence) {
        String[] words = sentence.split(" ");
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < words.length; i++) {
            StringBuilder reversedWord = new StringBuilder();

            for (int j = words[i].length() - 1; j >= 0; j--) {
                reversedWord.append(words[i].charAt(j));
            }

            result.append(reversedWord);
            if (i < words.length - 1) {
                result.append(" ");                 // re-join with single spaces
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        String[] sentences = { "hello club", "Gursimran Bajwa", "step semester three" };

        for (String sentence : sentences) {
            System.out.println("Input : " + sentence);
            System.out.println("Output: " + reverseEachWord(sentence));
            System.out.println();
        }
    }
}
