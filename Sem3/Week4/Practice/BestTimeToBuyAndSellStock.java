/**
 * L2 - Best Time to Buy and Sell Stock (Trainee Investor)
 * Name: Gursimran Bajwa   |   Reg. No: RA2511003011289
 */
public class BestTimeToBuyAndSellStock {

    /* One left-to-right pass, tracking the lowest price so far and the best profit so far. */
    public static int maxProfit(int[] prices) {
        if (prices.length == 0) return 0;

        int lowestSoFar = prices[0];
        int bestProfit  = 0;

        for (int i = 1; i < prices.length; i++) {
            int profitIfSoldToday = prices[i] - lowestSoFar;

            if (profitIfSoldToday > bestProfit) {
                bestProfit = profitIfSoldToday;     // better sell day found
            }
            if (prices[i] < lowestSoFar) {
                lowestSoFar = prices[i];            // better buy day found
            }
        }
        return bestProfit;                          // stays 0 when prices only fall
    }

    private static String format(int[] array) {
        StringBuilder text = new StringBuilder("[");
        for (int i = 0; i < array.length; i++) {
            text.append(array[i]);
            if (i < array.length - 1) text.append(", ");
        }
        return text.append("]").toString();
    }

    public static void main(String[] args) {
        int[][] inputs = { { 7, 1, 5, 3, 6, 4 }, { 7, 6, 4, 3, 1 }, { 2, 4, 1 } };

        for (int[] prices : inputs) {
            System.out.println("prices = " + format(prices)
                    + "  ->  Max Profit: " + maxProfit(prices));
        }
    }
}
