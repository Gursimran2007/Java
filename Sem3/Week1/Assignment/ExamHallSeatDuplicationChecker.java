/**
 * Problem 1 - The Exam Hall Seat Duplication Checker
 * Name: Gursimran Bajwa   |   Reg. No: RA2511003011289
 * Constraint: arrays and loops only - no Collections classes used.
 */
public class ExamHallSeatDuplicationChecker {

    /* Compares every seat number with every later one and reports duplicates. */
    public static void checkDuplicateSeats(int[] seatNumbers) {
        boolean duplicateFound = false;
        int[] alreadyReported = new int[seatNumbers.length];
        int reportedCount = 0;

        for (int i = 0; i < seatNumbers.length; i++) {
            for (int j = i + 1; j < seatNumbers.length; j++) {
                if (seatNumbers[i] == seatNumbers[j]) {

                    // Make sure the same duplicate is not printed twice.
                    boolean alreadyPrinted = false;
                    for (int k = 0; k < reportedCount; k++) {
                        if (alreadyReported[k] == seatNumbers[i]) {
                            alreadyPrinted = true;
                            break;
                        }
                    }

                    if (!alreadyPrinted) {
                        System.out.println("Duplicate Seat Number Found: " + seatNumbers[i]);
                        alreadyReported[reportedCount] = seatNumbers[i];
                        reportedCount++;
                        duplicateFound = true;
                    }
                }
            }
        }

        if (!duplicateFound) {
            System.out.println("No Duplicate Seats Found");
        }
    }

    private static void printArray(int[] array) {
        StringBuilder line = new StringBuilder("{");
        for (int i = 0; i < array.length; i++) {
            line.append(array[i]);
            if (i < array.length - 1) line.append(", ");
        }
        System.out.println("Seat list: " + line.append("}"));
    }

    public static void main(String[] args) {
        int[] hallOne   = { 101, 102, 103, 102, 105 };
        int[] hallTwo   = { 101, 102, 103, 104, 105 };
        int[] hallThree = { 201, 202, 201, 204, 202, 206 };

        printArray(hallOne);
        checkDuplicateSeats(hallOne);
        System.out.println();

        printArray(hallTwo);
        checkDuplicateSeats(hallTwo);
        System.out.println();

        printArray(hallThree);
        checkDuplicateSeats(hallThree);
    }
}
