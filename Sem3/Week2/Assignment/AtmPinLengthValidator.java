/**
 * Problem 1 - ATM PIN Length Validator
 * Name: Gursimran Bajwa   |   Reg. No: RA2511003011289
 */
public class AtmPinLengthValidator {

    /* One length() call and a single if / else - no loop needed. */
    public static void checkPinLength(String pin) {
        if (pin.length() != 4) {
            System.out.println("Invalid PIN - must be exactly 4 digits.");
        } else {
            System.out.println("PIN length OK.");
        }
    }

    public static void main(String[] args) {
        String[] pins = { "482", "4820", "12345" };

        for (String pin : pins) {
            System.out.println("PIN entered: \"" + pin + "\"");
            checkPinLength(pin);
            System.out.println();
        }
    }
}
