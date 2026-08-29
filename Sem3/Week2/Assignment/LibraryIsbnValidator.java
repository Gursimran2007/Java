/**
 * Problem 4 - Library ISBN Normalizer & Validator
 * Name: Gursimran Bajwa   |   Reg. No: RA2511003011289
 * Valid code = 3 letters (publisher) + 4 digits (year) + 6 digits (catalog) = 13 chars.
 */
public class LibraryIsbnValidator {

    /* Trims stray spaces and uppercases only the 3-character publisher code. */
    public static String normalizeCode(String raw) {
        String trimmed = raw.trim();

        if (trimmed.length() < 3) {
            return trimmed;                        // too short to have a publisher code
        }
        return trimmed.substring(0, 3).toUpperCase() + trimmed.substring(3);
    }

    /* Runs the three validation stages and formats the code when it passes. */
    public static String validateAndFormat(String code) {
        if (code.length() != 13) {
            return "Invalid: code must be exactly 13 characters";
        }

        for (int i = 0; i < 3; i++) {
            if (!Character.isLetter(code.charAt(i))) {
                return "Invalid: publisher code must be 3 letters";
            }
        }

        for (int i = 3; i < 13; i++) {
            if (!Character.isDigit(code.charAt(i))) {
                return "Invalid: year and catalog number must be digits";
            }
        }

        String publisher = code.substring(0, 3);
        String year      = code.substring(3, 7);
        String catalog   = code.substring(7);

        StringBuilder display = new StringBuilder();
        display.append("[").append(publisher).append("] YEAR: ").append(year)
               .append(" | CATALOG: ").append(catalog);

        return display.toString();
    }

    public static void main(String[] args) {
        String[] rawCodes = {
                "  pen2026004251  ",
                "12N2026004251",
                "oxf202600",
                "mcg20260042X1",
                "  hrp2025000199  "
        };

        for (String raw : rawCodes) {
            String normalized = normalizeCode(raw);
            System.out.println("Raw: \"" + raw + "\"");
            System.out.println("  Normalized: \"" + normalized + "\"");
            System.out.println("  Result: " + validateAndFormat(normalized));
            System.out.println();
        }
    }
}
