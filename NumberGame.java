import java.util.Random;
import java.util.Scanner;

public class NumberGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int roundsWon = 0;  // Total rounds won by the user

        System.out.println("Welcome to the Number Guessing Game!");

        // Loop for multiple rounds
        boolean playAgain = true;
        while (playAgain) {
            int numberToGuess = random.nextInt(100) + 1; // Random number between 1 and 100
            int attempts = 0;
            boolean guessedCorrectly = false;

            System.out.println("\nI have selected a number between 1 and 100. Try to guess it!");
            System.out.println("You have a maximum of 10 attempts.");

            // Loop for up to 10 attempts
            while (attempts < 10) {
                System.out.print("Enter your guess: ");
                int userGuess = scanner.nextInt();
                attempts++;

                if (userGuess == numberToGuess) {
                    System.out.println("Correct! You guessed the number in " + attempts + " attempts.");
                    guessedCorrectly = true;
                    roundsWon++;
                    break;
                } else if (userGuess < numberToGuess) {
                    System.out.println("⬆Too low! Try a higher number.");
                } else {
                    System.out.println("⬇Too high! Try a lower number.");
                }
            }

            if (!guessedCorrectly) {
                System.out.println("You've used all 10 attempts. The correct number was: " + numberToGuess);
            }

            // Ask if user wants to play another round
            System.out.print("\nDo you want to play again? (yes/no): ");
            String response = scanner.next();
            playAgain = response.equalsIgnoreCase("yes");
        }

        System.out.println("\nGame Over! You won " + roundsWon + " round(s). Thanks for playing!");
        scanner.close();
    }
}
