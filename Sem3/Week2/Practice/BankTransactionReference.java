/**
 * Problem 5 - Bank Transaction Reference Generator & Validator
 * Name: Gursimran Bajwa   |   Reg. No: RA2511003011289
 * Valid reference = 3 letters (bank code) + 6 digits (ddMMyy) + 5 digits (sequence) = 14 chars.
 */
public class BankTransactionReference {

    /* Trims stray spaces and uppercases only the 3-character bank code. */
    public static String normalizeReference(String raw) {
        String trimmed = raw.trim();

        if (trimmed.length() < 3) {
            return trimmed;                       // too short to have a bank code
        }
        return trimmed.substring(0, 3).toUpperCase() + trimmed.substring(3);
    }

    /* Runs the three validation stages and formats the reference when it passes. */
    public static String validateAndFormat(String reference) {
        if (reference.length() != 14) {
            return "Invalid: reference must be exactly 14 characters";
        }

        for (int i = 0; i < 3; i++) {
            if (!Character.isLetter(reference.charAt(i))) {
                return "Invalid: bank code must be 3 letters";
            }
        }

        for (int i = 3; i < 14; i++) {
            if (!Character.isDigit(reference.charAt(i))) {
                return "Invalid: date and sequence must be digits";
            }
        }

        String bankCode = reference.substring(0, 3);
        String day      = reference.substring(3, 5);
        String month    = reference.substring(5, 7);
        String year     = reference.substring(7, 9);
        String sequence = reference.substring(9);

        StringBuilder display = new StringBuilder();
        display.append("[").append(bankCode).append("] DATE: ")
               .append(day).append("/").append(month).append("/").append(year)
               .append(" | SEQ: ").append(sequence);

        return display.toString();
    }

    public static void main(String[] args) {
        String[] rawReferences = {
                "  hdf03022600042  ",
                "12F03022600042",
                "sbi1503260012",
                "icI2908260099x",
                "  axs29082600777  "
        };

        for (String raw : rawReferences) {
            String normalized = normalizeReference(raw);
            System.out.println("Raw: \"" + raw + "\"");
            System.out.println("  Normalized: \"" + normalized + "\"");
            System.out.println("  Result: " + validateAndFormat(normalized));
            System.out.println();
        }
    }
}
