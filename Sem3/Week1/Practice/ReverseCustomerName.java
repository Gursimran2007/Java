/**
 * Problem 5 - Reverse Customer Name (Customer Identity Verification System)
 * Name: Gursimran Bajwa   |   Reg. No: RA2511003011289
 */
public class ReverseCustomerName {

    /* Builds and returns the reverse of the name; the original is never modified. */
    public static String reverseCustomerName(String customerName) {
        char[] characters = customerName.toCharArray();
        StringBuilder reversed = new StringBuilder();

        for (int i = characters.length - 1; i >= 0; i--) {
            reversed.append(characters[i]);
        }
        return reversed.toString();
    }

    public static void main(String[] args) {
        String[] customers = { "Sunil", "Gursimran", "Anita Rao" };

        for (String name : customers) {
            String reversed = reverseCustomerName(name);
            System.out.println("Original Name: " + name);
            System.out.println("Reversed Name: " + reversed);
            System.out.println();
        }
    }
}
