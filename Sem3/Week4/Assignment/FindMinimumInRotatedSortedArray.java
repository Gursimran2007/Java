/**
 * A5 - Find Minimum in Rotated Sorted Array (Circular Duty Roster)
 * Name: Gursimran Bajwa   |   Reg. No: RA2511003011289
 * Modified binary search - O(log n) time.
 */
public class FindMinimumInRotatedSortedArray {

    /* Compares the middle element with the rightmost to decide which half holds the minimum. */
    public static int findMin(int[] nums) {
        int left  = 0;
        int right = nums.length - 1;

        while (left < right) {
            int middle = left + (right - left) / 2;

            if (nums[middle] > nums[right]) {
                left = middle + 1;      // the dip is strictly to the right of middle
            } else {
                right = middle;         // middle could itself be the minimum, so keep it
            }
        }
        return nums[left];              // left and right have converged on the minimum
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
        int[][] inputs = { { 3, 4, 5, 1, 2 }, { 4, 5, 6, 7, 0, 1, 2 }, { 11, 13, 15, 17 }, { 2, 1 } };

        for (int[] nums : inputs) {
            System.out.println("nums = " + format(nums) + "  ->  Minimum: " + findMin(nums));
        }
    }
}
