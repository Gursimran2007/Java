/**
 * Problem 3 - The Traffic Signal Streak Analyzer
 * Name: Gursimran Bajwa   |   Reg. No: RA2511003011289
 */
public class TrafficSignalStreakAnalyzer {

    /* Single pass over the log, tracking the current streak and the best one so far. */
    public static void findLongestStreak(String signalLog) {
        if (signalLog == null || signalLog.isEmpty()) {
            System.out.println("Empty signal log - nothing to analyze.");
            return;
        }

        char bestColor = signalLog.charAt(0);
        int bestLength = 1;

        char currentColor = signalLog.charAt(0);
        int currentLength = 1;

        for (int i = 1; i < signalLog.length(); i++) {
            if (signalLog.charAt(i) == currentColor) {
                currentLength++;                    // streak continues
            } else {
                currentColor = signalLog.charAt(i); // streak broken, start a new one
                currentLength = 1;
            }

            if (currentLength > bestLength) {
                bestLength = currentLength;
                bestColor = currentColor;
            }
        }

        System.out.println("Longest Streak: '" + bestColor + "' repeated " + bestLength + " times");
    }

    public static void main(String[] args) {
        String[] logs = { "RRGGGYRR", "RRRRYYGG", "RYGRYGRYG", "GGGGGGRY" };

        for (String log : logs) {
            System.out.println("Signal log: \"" + log + "\"");
            findLongestStreak(log);
            System.out.println();
        }
    }
}
