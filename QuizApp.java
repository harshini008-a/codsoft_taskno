/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author A .Harshini
 */
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class QuizApp {
    // Quiz question class
    static class Question {
        String questionText;
        String[] options;
        int correctOption;

        Question(String questionText, String[] options, int correctOption) {
            this.questionText = questionText;
            this.options = options;
            this.correctOption = correctOption;
        }
    }

    // Define quiz questions
    static Question[] questions = {
        new Question("What is the capital of France?", new String[] {"1. Paris", "2. London", "3. Berlin", "4. Madrid"}, 1),
        new Question("Which planet is known as the Red Planet?", new String[] {"1. Earth", "2. Mars", "3. Jupiter", "4. Venus"}, 2),
        new Question("What is the square root of 16?", new String[] {"1. 2", "2. 3", "3. 4", "4. 5"}, 3)
    };

    static int score = 0;
    static boolean timeUp = false;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Timer timer = new Timer();

        System.out.println("Welcome to the Quiz Application!");

        for (int i = 0; i < questions.length; i++) {
            Question currentQuestion = questions[i];
            timeUp = false;

            // Display the question and options
            System.out.println("\nQuestion " + (i + 1) + ": " + currentQuestion.questionText);
            for (String option : currentQuestion.options) {
                System.out.println(option);
            }

            // Set a timer for the question
            TimerTask task = new TimerTask() {
                @Override
                public void run() {
                    timeUp = true;
                    System.out.println("\nTime's up!");
                }
            };

            timer.schedule(task, 10000);  // 10 seconds for each question

            // Wait for the user's answer or timeout
            int userAnswer = -1;
            while (!timeUp && userAnswer == -1) {
                if (scanner.hasNextInt()) {
                    userAnswer = scanner.nextInt();
                }
            }

            // Cancel the timer for this question
            task.cancel();

            // Check the answer and update the score
            if (userAnswer == currentQuestion.correctOption) {
                System.out.println("Correct!");
                score++;
            } else {
                System.out.println("Incorrect.");
            }
        }

        // Display the result
        System.out.println("\nQuiz Over! Your score is: " + score + "/" + questions.length);
    }
}
