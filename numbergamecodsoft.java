import java.util.Scanner;
import java.util.Random;

public class NumberGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();

        int totalRounds = 0;
        int roundsWon = 0;
        String playAgain;

        System.out.println("🎯 Welcome to the Number Guessing Game!");

        do {
            int numberToGuess = rand.nextInt(100) + 1; // 1 to 100
            int tries = 0;
            int maxTries = 5;
            boolean guessedRight = false;

            System.out.println("\n🔢 I have picked a number between 1 and 100.");
            System.out.println("💡 You have " + maxTries + " attempts to guess it.");

            while (tries < maxTries) {
                System.out.print("Enter your guess: ");
                int guess = sc.nextInt();
                tries++;

                if (guess == numberToGuess) {
                    System.out.println("✅ Correct! You guessed the number in " + tries + " tries.");
                    guessedRight = true;
                    roundsWon++;
                    break;
                } else if (guess < numberToGuess) {
                    System.out.println("⬆️ Too low!");
                } else {
                    System.out.println("⬇️ Too high!");
                }

                System.out.println("⏳ Attempts left: " + (maxTries - tries));
            }

            if (!guessedRight) {
                System.out.println("❌ You've used all your attempts. The number was: " + numberToGuess);
            }

            totalRounds++;
            System.out.print("\n🔁 Do you want to play another round? (yes/no): ");
            sc.nextLine(); // clear buffer
            playAgain = sc.nextLine().toLowerCase();

        } while (playAgain.equals("yes"));

        System.out.println("\n🎮 Game Over!");
        System.out.println("📊 Rounds played: " + totalRounds);
        System.out.println("🏆 Rounds won: " + roundsWon);

        sc.close();
    }
}

