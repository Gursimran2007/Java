/**
 * L1 - Two Sum (Shopkeeper's Budget Match)
 * Name: Gursimran Bajwa   |   Reg. No: RA2511003011289
 * Arrays, loops and conditionals only - no library helpers.
 */
public class TwoSum {

    /* Checks every pair (i, j) with i < j and returns the first pair that hits the target. */
    public static int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[] { i, j };      // exactly one valid pair is guaranteed
                }
            }
        }
        return new int[] {};                        // no pair found
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
        int[][] inputs  = { { 2, 7, 11, 15 }, { 3, 2, 4 }, { 3, 3 } };
        int[]   targets = { 9,                6,           6        };

        for (int t = 0; t < inputs.length; t++) {
            int[] result = twoSum(inputs[t], targets[t]);
            System.out.println("nums = " + format(inputs[t]) + ", target = " + targets[t]);
            System.out.print("  Output: " + format(result));

            if (result.length == 2) {
                System.out.println("   (nums[" + result[0] + "] + nums[" + result[1] + "] = "
                        + inputs[t][result[0]] + " + " + inputs[t][result[1]]
                        + " = " + targets[t] + ")");
            } else {
                System.out.println("   (no valid pair)");
            }
        }
    }
}
