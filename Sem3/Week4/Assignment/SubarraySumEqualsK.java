import java.util.HashMap;
import java.util.Map;

/**
 * A4 - Subarray Sum Equals K (Hostel Attendance-Change Log)
 * Name: Gursimran Bajwa   |   Reg. No: RA2511003011289
 * Prefix sums + hash map - O(n) time, O(n) space.
 *
 * A sliding window cannot be used here: with negative numbers the running sum is not
 * monotonic, so shrinking the window is no longer guaranteed to reduce the sum.
 */
public class SubarraySumEqualsK {

    /* sum(i+1..j) == prefix[j] - prefix[i], so count earlier prefixes equal to (running - k). */
    public static int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> prefixCounts = new HashMap<>();
        prefixCounts.put(0, 1);          // the empty prefix: lets a subarray from index 0 count

        int runningSum = 0;
        int total      = 0;

        for (int num : nums) {
            runningSum += num;
            total += prefixCounts.getOrDefault(runningSum - k, 0);
            prefixCounts.put(runningSum, prefixCounts.getOrDefault(runningSum, 0) + 1);
        }
        return total;
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
        int[][] inputs  = { { 1, 1, 1 }, { 1, -1, 0 }, { 3, 4, 7, 2, -3, 1, 4, 2 } };
        int[]   targets = { 2,           0,            7                          };

        for (int t = 0; t < inputs.length; t++) {
            System.out.println("nums = " + format(inputs[t]) + ", k = " + targets[t]
                    + "  ->  Count: " + subarraySum(inputs[t], targets[t]));
        }
    }
}
