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

        // Easy mode (15)
        // Medium mode (30)
        // Hard mode (75)
        // Expert mode (150)
        switch (query) {
            case 1 -> {
                limitedAttempts = 6;  // aiming for 6 attempts
                tries = 0;
                timesGuessed = 0;
                secretNumber = numberShuffling("Easy");
                System.out.println("Mode: Easy\nChoose a number between 1 and 15.");
                do {
                    if (limitedAttempts - tries == 0) {
                        System.out.println("No more attempts, better luck next time.");
                        System.out.println("The correct number was " + secretNumber);
                        score(timesGuessed, "Easy");
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
                                score(timesGuessed, "Easy");
                                break;

                            } else if (ifContinuing.equals("yes") || ifContinuing.equals("Yes")) {
                                int roundNumber = 1;
                                secretNumber = numberShuffling("Easy");
                                System.out.println("Round 1");
                                do {
                                    if (limitedAttempts - tries == 0) {
                                        System.out.println("\nno more attempts, better luck next time.\n");
                                        System.out.println("The correct number was " + secretNumber);
                                        System.out.println("You made it into Round " + roundNumber);
                                        System.out.println("Good job!");
                                        score(timesGuessed, "Easy");
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
                            wordHint("Easy", yourNumber, secretNumber);
                            triesLeft(tries, limitedAttempts);
                        }
                    }
                } while (true);
            }
            case 2 -> {
                limitedAttempts = 11;  // aiming for 12 attempts
                tries = 0;
                timesGuessed = 0;
                secretNumber = numberShuffling("Medium");
                System.out.println("Mode: Medium\nChoose a number between 1 and 30.");
                do {
                    if (limitedAttempts - tries == 0) {
                        System.out.println("No more attempts, better luck next time.");
                        System.out.println("The correct number was " + secretNumber);
                        score(timesGuessed, "Medium");
                        break;
                    } else {
                        System.out.println("Your Guess: ");
                        yourNumber = input.nextInt();
                        if (yourNumber == secretNumber) {   // cfh
                            timesGuessed++;
                            tries--;
                            System.out.println("Good job!");
                            System.out.println("Continue into the survival mode?");
                            String ifContinuing = input.next();

                            if (ifContinuing.equals("no") || ifContinuing.equals("No")) {
                                displayTries(tries);
                                System.out.println("Good job!");
                                score(timesGuessed, "Medium");
                                break;

                            } else if (ifContinuing.equals("yes") || ifContinuing.equals("Yes")) {
                                int roundNumber = 1;
                                secretNumber = numberShuffling("Medium");
                                System.out.println("Round 1");
                                do {
                                    if (limitedAttempts - tries == 0) {
                                        System.out.println("No more attempts, better luck next time.");
                                        System.out.println("The correct number was " + secretNumber);
                                        System.out.println("You made it into Round " + roundNumber);
                                        System.out.println("Good job!");
                                        score(timesGuessed, "Easy");
                                        break;
                                    } else {
                                        System.out.println("Your Guess: ");
                                        yourNumber = input.nextInt();
                                        if (yourNumber == secretNumber) {
                                            roundNumber++;
                                            tries--;
                                            timesGuessed++;
                                            System.out.println("Good job!");
                                            System.out.println("Round " + roundNumber);
                                            secretNumber = numberShuffling("Medium");
                                        } else {
                                            tries++;
                                            wordHint("Medium", yourNumber, secretNumber);
                                        }
                                    }

                                } while (true);
                                break;  // cft
                            }
                        } else {
                            tries++;
                            wordHint("Medium", yourNumber, secretNumber);
                            triesLeft(tries, limitedAttempts);
                        }
                    }
                } while (true);
            }
            case 3 -> {
                limitedAttempts = 16;  // aiming for 17 attempts
                tries = 0;
                timesGuessed = 0;
                secretNumber = numberShuffling("Hard");
                System.out.println("Mode: Hard\nChoose a number between 1 and 75.");
                do {
                    if (limitedAttempts - tries == 0) {
                        System.out.println("No more attempts, better luck next time.");
                        System.out.println("The correct number was " + secretNumber);
                        score(timesGuessed, "Hard");
                        break;
                    } else {
                        System.out.println("Your Guess: ");
                        yourNumber = input.nextInt();
                        if (yourNumber == secretNumber) {  // cfh
                            timesGuessed++;
                            tries--;
                            System.out.println("Good job!");
                            System.out.println("Continue into the survival mode?");
                            String ifContinuing = input.next();

                            if (ifContinuing.equals("no") || ifContinuing.equals("No")) {
                                displayTries(tries);
                                System.out.println("Good job!");
                                score(timesGuessed, "Hard");
                                break;

                            } else if (ifContinuing.equals("yes") || ifContinuing.equals("Yes")) {
                                int roundNumber = 1;
                                secretNumber = numberShuffling("Hard");
                                System.out.println("Round 1");
                                do {
                                    if (limitedAttempts - tries == 0) {
                                        System.out.println("No more attempts, better luck next time.");
                                        System.out.println("The correct number was " + secretNumber);
                                        System.out.println("You made it into Round " + roundNumber);
                                        System.out.println("Good job!");
                                        score(timesGuessed, "Hard");
                                        break;
                                    } else {
                                        System.out.println("Your Guess: ");
                                        yourNumber = input.nextInt();
                                        if (yourNumber == secretNumber) {
                                            timesGuessed++;
                                            roundNumber++;
                                            tries--;
                                            System.out.println("Good job!");
                                            System.out.println("Round " + roundNumber);
                                            secretNumber = numberShuffling("Hard");

                                        } else {
                                            tries++;
                                            wordHint("Hard", yourNumber, secretNumber);
                                            triesLeft(tries, limitedAttempts);
                                        }
                                    }

                                } while (true);
                                break;  // cft
                            }
                        } else {
                            tries++;
                            wordHint("Hard", yourNumber, secretNumber);
                            triesLeft(tries, limitedAttempts);
                        }
                    }
                } while (true);
            }
            case 4 -> {
                limitedAttempts = 24;  // aiming for 25 attempts
                tries = 0;
                timesGuessed = 0;
                secretNumber = numberShuffling("Expert");
                System.out.println("Mode: Expert\nChoose a number between 1 and 150.");
                do {

                    if (limitedAttempts - tries == 0) {
                        System.out.println("No more attempts, better luck next time.");
                        System.out.println("The correct number was " + secretNumber);
                        score(timesGuessed, "Expert");
                        break;
                    } else {
                        System.out.println("Your Guess: ");
                        yourNumber = input.nextInt();
                        if (yourNumber == secretNumber) {  // cfh
                            timesGuessed++;
                            tries--;
                            System.out.println("Good job!");
                            System.out.println("Continue into the survival mode?");
                            String ifContinuing = input.next();

                            if (ifContinuing.equals("no") || ifContinuing.equals("No")) {
                                displayTries(tries);
                                System.out.println("Good job!");
                                score(timesGuessed, "Expert");
                                break;

                            } else if (ifContinuing.equals("yes") || ifContinuing.equals("Yes")) {
                                int roundNumber = 1;
                                secretNumber = numberShuffling("Expert");
                                System.out.println("Round 1");
                                do {
                                    if (limitedAttempts - tries == 0) {
                                        System.out.println("No more attempts, better luck next time.");
                                        System.out.println("The correct number was " + secretNumber);
                                        System.out.println("You made it into Round " + roundNumber);
                                        System.out.println("Good job!");
                                        score(timesGuessed, "Expert");
                                        break;
                                    } else {
                                        System.out.println("Your Guess: ");
                                        yourNumber = input.nextInt();
                                        if (yourNumber == secretNumber && tries != 0) {
                                            timesGuessed++;
                                            roundNumber++;
                                            tries--;
                                            System.out.println("Good job!");
                                            System.out.println("Round " + roundNumber);
                                            secretNumber = numberShuffling("Expert");

                                        } else if (tries != 0) {
                                            tries++;
                                            wordHint("Expert", yourNumber, secretNumber);
                                            triesLeft(tries, limitedAttempts);
                                        }
                                    }

                                } while (true);
                                break;  // cft
                            }
                        } else {
                            tries++;
                            wordHint("Expert", yourNumber, secretNumber);
                            triesLeft(tries, limitedAttempts);
                        }
                    }
                } while (true);
            }
            default -> System.out.println("Invalid input. Try again.");
        }
    }

    public void wordHint(String difficulty, int chosenNumber, int neededNumber){
        switch (difficulty) {
            case "Easy":
                if(chosenNumber > 15){
                    System.out.println("Number is out of perimeter.");
                } else if(15 >= neededNumber - chosenNumber && 7 <= neededNumber - chosenNumber){
                    System.out.println("That's not so close");
                } else if (7 > neededNumber - chosenNumber && 3 <= neededNumber - chosenNumber){
                    System.out.println("You are getting closer");
                } else if (3 > neededNumber - chosenNumber){
                    System.out.println("You are very close");
                }
                break;

            case "Medium":
                if (chosenNumber > 30){
                    System.out.println("Number is out of perimeter.");
                } else if(30 >= neededNumber - chosenNumber && 12 <= neededNumber - chosenNumber){
                    System.out.println("That's not so close");
                } else if (12 > neededNumber - chosenNumber && 5 <= neededNumber - chosenNumber){
                    System.out.println("You are getting closer");
                } else if (5 > neededNumber - chosenNumber){
                    System.out.println("You are very close");
                }
                break;

            case "Hard":
                if (chosenNumber > 75){
                    System.out.println("Number is out of perimeter.");
                } else if (75 >= neededNumber - chosenNumber && 30 <= neededNumber - chosenNumber){
                    System.out.println("That's not so close");
                } else if (30 > neededNumber - chosenNumber && 10 <= neededNumber - chosenNumber){
                    System.out.println("You are getting closer");
                } else if (10 > neededNumber - chosenNumber){
                    System.out.println("You are very close");
                } else if (4 > neededNumber - chosenNumber){
                    System.out.println("You are so close!");
                }
                break;
            case "Expert":

                if (chosenNumber > 150){
                    System.out.println("Number is out of perimeter.");
                } else if (150 >= neededNumber - chosenNumber && 50 <= neededNumber - chosenNumber){
                    System.out.println("That's not so close");
                } else if (50 > neededNumber - chosenNumber && 15 <= neededNumber - chosenNumber){
                    System.out.println("You are getting closer");
                } else if (15 > neededNumber - chosenNumber && 5 <= neededNumber - chosenNumber){
                    System.out.println("You are very close");
                } else if (5 > neededNumber - chosenNumber){
                    System.out.println("You are so close!");
                }
                break;
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
