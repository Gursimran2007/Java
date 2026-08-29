/**
 * L5 - Rotate Array (Shifting a Playlist Queue)
 * Name: Gursimran Bajwa   |   Reg. No: RA2511003011289
 */
public class RotateArray {

    /* Every element moves to (i + k) % length in a freshly built array. */
    public static int[] rotateArray(int[] nums, int k) {
        if (nums.length == 0) return nums;

        k = k % nums.length;            // a full rotation changes nothing
        int[] rotated = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            rotated[(i + k) % nums.length] = nums[i];
        }

        // Copy back into nums so the caller's array reflects the rotation too.
        for (int i = 0; i < nums.length; i++) {
            nums[i] = rotated[i];
        }
        return nums;
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
        int[][] inputs = { { 1, 2, 3, 4, 5, 6, 7 }, { 1, 2 }, { 1, 2, 3 } };
        int[]   shifts = { 3,                       3,        3         };

        for (int t = 0; t < inputs.length; t++) {
            String before = format(inputs[t]);
            String after  = format(rotateArray(inputs[t], shifts[t]));
            System.out.println("nums = " + before + ", k = " + shifts[t] + "  ->  " + after);
        }
    }
}
