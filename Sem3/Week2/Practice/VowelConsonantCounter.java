/**
 * Problem 1 - Vowel & Consonant Counter (Library Orientation Kiosk)
 * Name: Gursimran Bajwa   |   Reg. No: RA2511003011289
 */
public class VowelConsonantCounter {

    /* Walks the text with charAt() and buckets each letter as a vowel or consonant. */
    public static void countVowelsAndConsonants(String text) {
        int vowels = 0, consonants = 0;

        for (int i = 0; i < text.length(); i++) {
            char ch = Character.toLowerCase(text.charAt(i));

            if (ch == ' ') continue;                 // spaces are ignored

            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                vowels++;
            } else if (ch >= 'a' && ch <= 'z') {
                consonants++;
            }
        }

        System.out.println("Vowels: " + vowels + " | Consonants: " + consonants);
    }

    public static void main(String[] args) {
        String[] titles = { "Java Programming", "Data Structures", "Gursimran Bajwa" };

        for (String title : titles) {
            System.out.println("Title: \"" + title + "\"");
            countVowelsAndConsonants(title);
            System.out.println();
        }
    }
}
