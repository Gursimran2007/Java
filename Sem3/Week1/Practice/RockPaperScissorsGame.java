import java.util.Random;

/**
 * Problem 1 - Rock-Paper-Scissors Game (The College Coding Arcade)
 * Name: Gursimran Bajwa   |   Reg. No: RA2511003011289
 */
public class RockPaperScissorsGame {

    static final String[] MOVES = { "Rock", "Paper", "Scissors" };

    /* Returns the outcome of one round from the player's point of view. */
    public static String playRound(String playerMove, String computerMove) {
        if (playerMove.equalsIgnoreCase(computerMove)) {
            return "Draw";
        }
        boolean playerWins =
                (playerMove.equalsIgnoreCase("Rock")     && computerMove.equalsIgnoreCase("Scissors")) ||
                (playerMove.equalsIgnoreCase("Paper")    && computerMove.equalsIgnoreCase("Rock"))     ||
                (playerMove.equalsIgnoreCase("Scissors") && computerMove.equalsIgnoreCase("Paper"));
        return playerWins ? "Player Wins" : "Computer Wins";
    }

    public static void main(String[] args) {
        int rounds = 5;
        // Predefined player moves for the live demo (replace with Scanner input if needed).
        String[] playerMoves = { "Rock", "Paper", "Scissors", "Rock", "Paper" };
        String[] computerMoves = new String[rounds];
        String[] results = new String[rounds];

        Random random = new Random(2);   // fixed seed -> reproducible demo run
        int wins = 0, losses = 0, draws = 0;

        for (int i = 0; i < rounds; i++) {
            computerMoves[i] = MOVES[random.nextInt(3)];
            results[i] = playRound(playerMoves[i], computerMoves[i]);

            if (results[i].equals("Player Wins")) wins++;
            else if (results[i].equals("Computer Wins")) losses++;
            else draws++;

            System.out.println("Round " + (i + 1) + " - Player: " + playerMoves[i]
                    + ", Computer: " + computerMoves[i] + "  ->  " + results[i]);
        }

        System.out.println();
        System.out.println("--------------- FINAL SCOREBOARD ---------------");
        System.out.printf("%-8s %-14s %-16s %-14s%n", "Round", "Player Move", "Computer Move", "Result");
        for (int i = 0; i < rounds; i++) {
            System.out.printf("%-8d %-14s %-16s %-14s%n",
                    (i + 1), playerMoves[i], computerMoves[i], results[i]);
        }
        System.out.println("------------------------------------------------");

        double winPercentage = (wins * 100.0) / rounds;
        System.out.println("Wins: " + wins + " | Losses: " + losses + " | Draws: " + draws
                + " | Win % = " + String.format("%.1f", winPercentage) + "%");
    }
}
