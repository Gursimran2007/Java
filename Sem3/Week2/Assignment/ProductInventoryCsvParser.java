/**
 * Problem 3 - Product Inventory CSV Parser
 * Name: Gursimran Bajwa   |   Reg. No: RA2511003011289
 */
public class ProductInventoryCsvParser {

    /* Splits a CSV line into exactly 3 fields and prints a formatted record. */
    public static void parseInventoryRecord(String csvLine) {
        String[] fields = csvLine.split(",");

        if (fields.length != 3) {
            System.out.println("Invalid Record");
            return;
        }

        String productName = fields[0].trim();
        String sku         = fields[1].trim();
        String quantity    = fields[2].trim();

        System.out.println("Product: " + productName + " | SKU: " + sku + " | Qty: " + quantity);
    }

    public static void main(String[] args) {
        String[] lines = {
                "Wireless Mouse,WM-2201,150",
                "Wireless Mouse,150",
                "Mechanical Keyboard,MK-4410,75"
        };

        for (String line : lines) {
            System.out.println("Input: \"" + line + "\"");
            parseInventoryRecord(line);
            System.out.println();
        }
    }
}
