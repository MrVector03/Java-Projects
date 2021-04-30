package numberGuessingGame.java;

import java.util.Scanner;
import java.util.Random;

public class numberGuessingGame {

    Random random = new Random();
    Scanner input = new Scanner(System.in);
    public void startGame() {
        System.out.println("Choose difficulty: \nEasy - 1\nMedium - 2\nHard - 3\nExpert - 4\nEnter the difficulty: ");
        int query = input.nextInt();
        int yourNumber; // number which is input by the user
        int tries; // number of times when user tries to guess the number
        int limitedAttempts; // number of maximum tries user can use before ending the game
        int timesGuessed;  // number of times user correctly guessed the number
        int secretNumber;  // number which is expected to be guessed by user
        String difficulty;
        // Easy mode (15)
        // Medium mode (30)
        // Hard mode (75)
        // Expert mode (150)
        while (true) {
            if (query == 1){
                limitedAttempts = 6;  // aiming for 6 attempts
                tries = 0;
                timesGuessed = 0;
                difficulty = "Easy";
                secretNumber = numberShuffling(difficulty);
                break;
            } else if (query == 2){
                limitedAttempts = 8;  // aiming for 12 attempts
                tries = 0;
                timesGuessed = 0;
                difficulty = "Medium";
                secretNumber = numberShuffling(difficulty);
                break;
            } else if (query == 3){
                limitedAttempts = 10;  // aiming for 17 attempts
                tries = 0;
                timesGuessed = 0;
                difficulty = "Hard";
                secretNumber = numberShuffling(difficulty);
                break;
            } else if (query == 4){
                limitedAttempts = 12;  // aiming for 25 attempts
                tries = 0;
                timesGuessed = 0;
                difficulty = "Expert";
                secretNumber = numberShuffling(difficulty);
                break;
            } else {
                System.out.println("Invalid input. Try again.");
            }
        }

        System.out.println("Mode: " + difficulty + "\nChoose a number between 1 and 15.");
        do {
            if (limitedAttempts - tries == 0) {
                System.out.println("No more attempts, better luck next time.");
                System.out.println("The correct number was " + secretNumber);
                score(timesGuessed, difficulty);
                break;
            } else {
                System.out.println("Your Guess: ");
                yourNumber = input.nextInt();
                if (yourNumber == secretNumber) {  // options for later
                    timesGuessed++;
                    tries--;
                    System.out.println("Good job!");
                    System.out.println("Continue into the survival mode?");
                    String ifContinuing = input.next();

                    if (ifContinuing.equals("no") || ifContinuing.equals("No")) {  // succeed
                        displayTries(tries);
                        System.out.println("Good job!");
                        score(timesGuessed, difficulty);
                        break;

                    } else if (ifContinuing.equals("yes") || ifContinuing.equals("Yes")) {
                        int roundNumber = 1;
                        secretNumber = numberShuffling(difficulty);
                        System.out.println("Round 1");
                        do {
                            if (limitedAttempts - tries == 0) {
                                System.out.println("\nno more attempts, better luck next time.\n");
                                System.out.println("The correct number was " + secretNumber);
                                System.out.println("You made it into Round " + roundNumber);
                                System.out.println("Good job!");
                                score(timesGuessed, difficulty);
                                break;
                            } else {
                                System.out.println("Your Guess: ");
                                System.out.println(secretNumber);
                                yourNumber = input.nextInt();
                                if (yourNumber == secretNumber) {  // succeed but not over, rounds
                                    roundNumber++;
                                    tries--;
                                    timesGuessed++;
                                    System.out.println("Good job!");
                                    System.out.println("Round " + roundNumber);
                                    secretNumber = numberShuffling("Easy");

                                } else {
                                    tries++;
                                    wordHint("Easy", yourNumber, secretNumber);
                                    triesLeft(tries, limitedAttempts);
                                }
                            }
                        } while (true);
                        break;
                    }
                } else {
                    tries++;
                    wordHint(difficulty, yourNumber, secretNumber);
                    triesLeft(tries, limitedAttempts);
                }
            }
        } while (true);
    }

    public void wordHint(String difficulty, int chosenNumber, int neededNumber){
        int maxNumber = switch (difficulty) {
            case "Easy" -> 15;
            case "Medium" -> 30;
            case "Hard" -> 75;
            case "Expert" -> 150;
            default -> 1;
        };

        if (chosenNumber > maxNumber){
            System.out.println("Number is out of perimeter.");
        } else if (maxNumber >= neededNumber - chosenNumber && maxNumber / 3 <= neededNumber - chosenNumber){
            System.out.println("That's not so close");
        } else if (maxNumber / 3 > neededNumber - chosenNumber && maxNumber / 10 <= neededNumber - chosenNumber){
            System.out.println("You are getting closer");
        } else if (maxNumber / 10 > neededNumber - chosenNumber && maxNumber / 30 <= neededNumber - chosenNumber){
            System.out.println("You are very close");
        } else if (maxNumber / 30 > neededNumber - chosenNumber){
            System.out.println("You are so close!");
        }
    }
    public void triesLeft(int tries, int triesLimit){
        int num = triesLimit - tries;
        System.out.println("Tries: " + num);
    }
    /*
            Randomising numbers for each game mode and round
    */
    public int numberShuffling(String difficulty) {
        int num;
        switch (difficulty) {
            case "Easy" -> num = 1 + random.nextInt(15);
            case "Medium" -> num = 1 + random.nextInt(30);
            case "Hard" -> num = 1 + random.nextInt(75);
            case "Expert" -> num = 1 + random.nextInt(150);
            default -> num = 0;
        }
        return num;
    }

    public void displayTries(int tries){
        System.out.println("You needed " + tries + " tries to guess the right number.");
    }

    public void score(int timesGuessed, String difficulty){
        String string;
        switch (difficulty){
            case "Easy" -> string = ("Final score: " + (timesGuessed * 25));
            case "Medium" -> string = ("Final score: " + (timesGuessed * 25 + 50));
            case "Hard" -> string = ("Final score: " + (timesGuessed * 25 + 100));
            case "Expert" -> string = ("Final score: " + (timesGuessed * 25 + 150));
            default -> string = ("Invalid input");
        }
        System.out.println(string);
    }

    public static void main(String[] args){
            numberGuessingGame newGame = new numberGuessingGame();
            newGame.startGame();
        }
}
