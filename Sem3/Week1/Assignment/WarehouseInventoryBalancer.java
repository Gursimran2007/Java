/**
 * Problem 4 - The Warehouse Inventory Balancer
 * Name: Gursimran Bajwa   |   Reg. No: RA2511003011289
 */
public class WarehouseInventoryBalancer {

    /* Totals both sections, compares them, and locates the single highest quantity. */
    public static void analyzeInventory(int[] sectionA, int[] sectionB) {
        if (sectionA.length != sectionB.length) {
            System.out.println("Error: both sections must have the same number of items.");
            return;
        }

        int totalA = 0, totalB = 0;
        for (int i = 0; i < sectionA.length; i++) {
            totalA += sectionA[i];
            totalB += sectionB[i];
        }

        String status = (totalA == totalB) ? "Balanced" : "Not Balanced";

        // Track the maximum together with the section and index where it was found.
        int highest = sectionA[0];
        String highestSection = "Section A";
        int highestIndex = 0;

        for (int i = 1; i < sectionA.length; i++) {
            if (sectionA[i] > highest) {
                highest = sectionA[i];
                highestSection = "Section A";
                highestIndex = i;
            }
        }
        for (int i = 0; i < sectionB.length; i++) {
            if (sectionB[i] > highest) {
                highest = sectionB[i];
                highestSection = "Section B";
                highestIndex = i;
            }
        }

        System.out.println("Section A Total: " + totalA
                + " | Section B Total: " + totalB
                + " | Status: " + status
                + " | Highest Quantity: " + highest
                + " (" + highestSection + ", Item " + (highestIndex + 1) + ")");
    }

    public static void main(String[] args) {
        int[] a1 = { 20, 15, 30 };
        int[] b1 = { 25, 10, 30 };
        analyzeInventory(a1, b1);

        int[] a2 = { 40, 12, 8, 5 };
        int[] b2 = { 10, 60, 9, 7 };
        analyzeInventory(a2, b2);

        int[] a3 = { 5, 5, 5 };
        int[] b3 = { 5, 5, 5 };
        analyzeInventory(a3, b3);
    }
}
