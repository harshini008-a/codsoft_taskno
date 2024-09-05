/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
  import java.util.Random;
import java.util.Scanner;
/**
 *
 * @author A .Harshini
 */
public class game  {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int rounds = 0;
        int totalScore = 0;

        while (true) {
            rounds++;
            int numberToGuess = random.nextInt(100) + 1;
            int attempts = 0;
            int maxAttempts = 7; // Maximum attempts allowed per round
            boolean guessedCorrectly = false;

            System.out.println("Round " + rounds + ": Guess the number between 1 and 100");

            while (attempts < maxAttempts) {
                attempts++;
                System.out.print("Attempt " + attempts + ": Enter your guess: ");
                int userGuess = scanner.nextInt();

                if (userGuess == numberToGuess) {
                    System.out.println("Congratulations! You guessed the correct number.");
                    guessedCorrectly = true;
                    break;
                } else if (userGuess < numberToGuess) {
                    System.out.println("Too low!");
                } else {
                    System.out.println("Too high!");
                }
            }

            if (guessedCorrectly) {
                totalScore += maxAttempts - attempts + 1; // Higher score for fewer attempts
            } else {
                System.out.println("Sorry, you've used all attempts. The correct number was: " + numberToGuess);
            }

            System.out.println("Your current score: " + totalScore);

            System.out.print("Do you want to play another round? (yes/no): ");
            String playAgain = scanner.next();

            if (!playAgain.equalsIgnoreCase("yes")) {
                break;
            }
        }

        System.out.println("Game over! Your final score: " + totalScore);
        scanner.close();
    }
}
  

