/**
 * L3 - Contains Duplicate (Exam Seating Roll Number Check)
 * Name: Gursimran Bajwa   |   Reg. No: RA2511003011289
 * Arrays, loops and conditionals only - no HashSet.
 */
public class ContainsDuplicate {

    /* Compares every pair of different positions and exits early on the first match. */
    public static boolean containsDuplicate(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    return true;                    // early exit - answer is already known
                }
            }
        }
        return false;                               // every value is distinct
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
        int[][] inputs = { { 1, 2, 3, 1 }, { 1, 2, 3, 4 }, { 1, 1, 1, 3, 3, 4, 3, 2, 4, 2 } };

        for (int[] nums : inputs) {
            System.out.println("nums = " + format(nums)
                    + "  ->  " + containsDuplicate(nums));
        }
    }
}
