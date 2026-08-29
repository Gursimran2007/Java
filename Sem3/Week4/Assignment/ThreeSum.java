import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * A3 - 3Sum (Budgeting Tool: Transactions That Cancel Out)
 * Name: Gursimran Bajwa   |   Reg. No: RA2511003011289
 * Sort + two pointers - O(n^2) time after an O(n log n) sort.
 */
public class ThreeSum {

    /* For each element, two pointers sweep the rest of the sorted array for a matching pair. */
    public static int[][] threeSum(int[] nums) {
        Arrays.sort(nums);                       // sorting makes duplicates adjacent
        List<int[]> triplets = new ArrayList<>();

        for (int i = 0; i < nums.length - 2; i++) {

            // Skip a repeated first value, or the same triplet would be reported twice.
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            int left  = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                if (sum == 0) {
                    triplets.add(new int[] { nums[i], nums[left], nums[right] });

                    // Move both pointers past their duplicate values.
                    while (left < right && nums[left] == nums[left + 1])   left++;
                    while (left < right && nums[right] == nums[right - 1]) right--;
                    left++;
                    right--;
                } else if (sum < 0) {
                    left++;                      // need a larger sum
                } else {
                    right--;                     // need a smaller sum
                }
            }
        }

        return triplets.toArray(new int[triplets.size()][]);
    }

    private static String format(int[] array) {
        StringBuilder text = new StringBuilder("[");
        for (int i = 0; i < array.length; i++) {
            text.append(array[i]);
            if (i < array.length - 1) text.append(", ");
        }
        return text.append("]").toString();
    }

    private static String format(int[][] rows) {
        StringBuilder text = new StringBuilder("[");
        for (int i = 0; i < rows.length; i++) {
            text.append(format(rows[i]));
            if (i < rows.length - 1) text.append(", ");
        }
        return text.append("]").toString();
    }

    public static void main(String[] args) {
        int[][] inputs = { { -1, 0, 1, 2, -1, -4 }, { 0, 0, 0 }, { -2, 0, 1, 1, 2 } };

        for (int[] nums : inputs) {
            String before = format(nums);
            System.out.println("nums = " + before + "  ->  " + format(threeSum(nums)));
        }
    }
}
