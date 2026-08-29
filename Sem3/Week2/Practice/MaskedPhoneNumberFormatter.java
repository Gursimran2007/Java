/**
 * Problem 4 - Masked Phone Number Formatter (Student Support Call Center)
 * Name: Gursimran Bajwa   |   Reg. No: RA2511003011289
 */
public class MaskedPhoneNumberFormatter {

    /* Validates a 10-digit number and builds "XXXXXX-<last 4 digits>". */
    public static String maskPhoneNumber(String phone) {
        if (phone == null || phone.length() != 10) {
            return "Invalid phone number";
        }

        for (int i = 0; i < phone.length(); i++) {
            if (!Character.isDigit(phone.charAt(i))) {
                return "Invalid phone number";
            }
        }

        StringBuilder masked = new StringBuilder("XXXXXX");
        masked.append(phone.substring(6));      // the visible last 4 digits
        masked.insert(6, "-");                  // separator for readability

        return masked.toString();
    }

    public static void main(String[] args) {
        String[] numbers = { "9876543210", "98765", "98765abc10", "9123456789" };

        for (String phone : numbers) {
            System.out.println(phone + "  ->  " + maskPhoneNumber(phone));
        }
    }
}
