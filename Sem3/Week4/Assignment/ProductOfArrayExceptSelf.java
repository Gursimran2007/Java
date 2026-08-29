/**
 * A1 - Product of Array Except Self (Bundle Pricing Engine)
 * Name: Gursimran Bajwa   |   Reg. No: RA2511003011289
 * O(n) time, no division anywhere, O(1) extra space beyond the output array.
 */
public class ProductOfArrayExceptSelf {

    /* Forward pass stores the product of everything to the left of i;
       backward pass multiplies in the product of everything to the right. */
    public static int[] productExceptSelf(int[] nums) {
        int[] answer = new int[nums.length];

        int leftProduct = 1;
        for (int i = 0; i < nums.length; i++) {
            answer[i] = leftProduct;                // nothing to the left of index 0
            leftProduct = leftProduct * nums[i];
        }

        int rightProduct = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            answer[i] = answer[i] * rightProduct;   // combine left and right halves
            rightProduct = rightProduct * nums[i];
        }

        return answer;
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
        int[][] inputs = { { 1, 2, 3, 4 }, { -1, 1, 0, -3, 3 }, { 2, 3 } };

        for (int[] nums : inputs) {
            System.out.println("nums = " + format(nums)
                    + "  ->  " + format(productExceptSelf(nums)));
        }
    }
}
