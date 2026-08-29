/**
 * A2 - Maximum Subarray (Trader's Best Stretch of Days)
 * Name: Gursimran Bajwa   |   Reg. No: RA2511003011289
 * Kadane's algorithm - O(n) time, O(1) extra space.
 */
public class MaximumSubarray {

    /* At each element: extend the running subarray, or restart from this element. */
    public static int maxSubArray(int[] nums) {
        int currentSum = nums[0];
        int bestSum    = nums[0];       // seeded with a real element, so all-negative works

        for (int i = 1; i < nums.length; i++) {
            if (currentSum + nums[i] > nums[i]) {
                currentSum = currentSum + nums[i];   // extending still pays off
            } else {
                currentSum = nums[i];                // abandon the past, start fresh here
            }

            if (currentSum > bestSum) {
                bestSum = currentSum;
            }
        }
        return bestSum;
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
        int[][] inputs = { { -2, 1, -3, 4, -1, 2, 1, -5, 4 }, { -3, -1, -2 }, { 5, 4, -1, 7, 8 } };

        for (int[] nums : inputs) {
            System.out.println("nums = " + format(nums)
                    + "  ->  Max Subarray Sum: " + maxSubArray(nums));
        }
    }
}
