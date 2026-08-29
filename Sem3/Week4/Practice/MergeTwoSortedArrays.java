/**
 * L4 - Merge Two Sorted Arrays (Combining Two Sections' Exam Scores)
 * Name: Gursimran Bajwa   |   Reg. No: RA2511003011289
 */
public class MergeTwoSortedArrays {

    /* Two-pointer merge: always copy the smaller of the two current elements. */
    public static int[] mergeSortedArrays(int[] arr1, int[] arr2) {
        int[] merged = new int[arr1.length + arr2.length];

        int i = 0;      // pointer into arr1
        int j = 0;      // pointer into arr2
        int k = 0;      // write position in merged

        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] <= arr2[j]) {
                merged[k] = arr1[i];
                i++;
            } else {
                merged[k] = arr2[j];
                j++;
            }
            k++;
        }

        // One array is exhausted - copy whatever is left of the other one.
        while (i < arr1.length) {
            merged[k] = arr1[i];
            i++;
            k++;
        }
        while (j < arr2.length) {
            merged[k] = arr2[j];
            j++;
            k++;
        }

        return merged;
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
        int[][][] pairs = {
                { { 1, 3, 5 },    { 2, 4, 6 } },
                { { },            { 1, 2, 3 } },
                { { 1, 2, 9 },    { 3, 4 }    }
        };

        for (int[][] pair : pairs) {
            System.out.println("arr1 = " + format(pair[0]) + ", arr2 = " + format(pair[1])
                    + "  ->  " + format(mergeSortedArrays(pair[0], pair[1])));
        }
    }
}
