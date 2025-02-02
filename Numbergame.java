import java.util.Random;
import java.util.Scanner;

public class Numbergame {
    private static final int MAX_ATTEMPTS = 10; // Maximum attempts allowed
    private static final int RANGE_MIN = 1; // Minimum range for the random number
    private static final int RANGE_MAX = 100; // Maximum range for the random number

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        boolean playAgain;

        do {
            int score = 0;
            int roundsWon = 0;

            System.out.println("Welcome to the Number Guessing Game!");
            System.out.println("You have " + MAX_ATTEMPTS + " attempts to guess the correct number between " + RANGE_MIN + " and " + RANGE_MAX + ".");

            int randomNumber = random.nextInt(RANGE_MAX - RANGE_MIN + 1) + RANGE_MIN;
            int attempts = 0;
            boolean guessedCorrectly = false;

            while (attempts < MAX_ATTEMPTS && !guessedCorrectly) {
                System.out.print("Enter your guess: ");
                int userGuess = scanner.nextInt();
                attempts++;

                if (userGuess < RANGE_MIN || userGuess > RANGE_MAX) {
                    System.out.println("Please guess a number within the range of " + RANGE_MIN + " to " + RANGE_MAX + ".");
                } else if (userGuess < randomNumber) {
                    System.out.println("Too low! Try again.");
                } else if (userGuess > randomNumber) {
                    System.out.println("Too high! Try again.");
                } else {
                    System.out.println("Congratulations! You've guessed the correct number: " + randomNumber);
                    guessedCorrectly = true;
                    roundsWon++;
                    score = MAX_ATTEMPTS - attempts + 1; // Calculate score based on attempts
                }
            }

            if (!guessedCorrectly) {
                System.out.println("Sorry! You've used all your attempts. The correct number was: " + randomNumber);
            }

            System.out.println("Your score: " + score);
            System.out.println("Rounds won: " + roundsWon);
            
            System.out.print("Do you want to play again? (yes/no): ");
            String response = scanner.next();
            playAgain = response.equalsIgnoreCase("yes");

        } while (playAgain);

        System.out.println("Thank you for playing!");
        scanner.close();
    }
}

