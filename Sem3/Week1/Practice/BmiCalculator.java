import java.util.Random;

/**
 * Problem 3 - BMI Calculator for a Team (Corporate Wellness Program)
 * Name: Gursimran Bajwa   |   Reg. No: RA2511003011289
 */
public class BmiCalculator {

    /* Classifies a BMI value into the standard WHO health bands. */
    public static String getBmiStatus(double bmi) {
        if (bmi < 18.5) return "Underweight";
        else if (bmi < 25.0) return "Normal";
        else if (bmi < 30.0) return "Overweight";
        else return "Obese";
    }

    /* Prints the full wellness report table for the whole team. */
    public static void printWellnessReport(double[] heights, double[] weights) {
        System.out.printf("%-8s %-12s %-12s %-10s %-12s%n",
                "Person", "Height (m)", "Weight (kg)", "BMI", "Status");
        System.out.println("--------------------------------------------------------");

        for (int i = 0; i < heights.length; i++) {
            double bmi = weights[i] / (heights[i] * heights[i]);
            System.out.printf("%-8d %-12.2f %-12.1f %-10.2f %-12s%n",
                    (i + 1), heights[i], weights[i], bmi, getBmiStatus(bmi));
        }
        System.out.println("--------------------------------------------------------");
    }

    public static void main(String[] args) {
        int teamSize = 10;
        double[] heights = new double[teamSize];
        double[] weights = new double[teamSize];

        Random random = new Random(7);   // fixed seed -> reproducible demo run
        for (int i = 0; i < teamSize; i++) {
            heights[i] = 1.50 + random.nextDouble() * 0.45;   // 1.50 m .. 1.95 m
            weights[i] = 45.0 + random.nextDouble() * 55.0;   // 45 kg .. 100 kg
        }

        System.out.println("WELLNESS CAMP - BMI REPORT");
        System.out.println();
        printWellnessReport(heights, weights);

        // Verification against the sample cases given in the problem statement.
        System.out.println();
        System.out.println("Sample verification:");
        double bmi1 = 70 / (1.75 * 1.75);
        double bmi2 = 90 / (1.60 * 1.60);
        System.out.printf("Person 1 - Height: 1.75 m, Weight: 70 kg -> BMI: %.2f | Status: %s%n",
                bmi1, getBmiStatus(bmi1));
        System.out.printf("Person 2 - Height: 1.60 m, Weight: 90 kg -> BMI: %.2f | Status: %s%n",
                bmi2, getBmiStatus(bmi2));
    }
}
