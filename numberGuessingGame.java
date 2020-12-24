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

        switch (query){

            // Easy mode (15)

            case 1:
                limitedAttempts = 6;
                tries = 0;
                int secretNumber = numberShuffling("Easy");
                System.out.println("Mode: Easy\nChoose a number between 1 and 15.");
                do {
                    System.out.println("Your Guess: ");
                    yourNumber = input.nextInt();
                    tries++;
                    if(tries >= limitedAttempts){
                        System.out.println("No more attempts, better luck next time.");
                        System.out.println("The correct number was " + secretNumber);
                        break;
                    } else if (yourNumber == secretNumber){
                        System.out.println("Good job!");
                        displayTries(tries);
                        break;
                    } else {
                        wordHint("Easy", yourNumber, secretNumber);
                    }
                } while (true);
                break;

            // Medium mode (30)

            case 2:
                limitedAttempts = 12;
                tries = 0;
                secretNumber = numberShuffling("Medium");
                System.out.println("Mode: Medium\nChoose a number between 1 and 30.");
                do {
                    System.out.println("Your Guess: ");
                    yourNumber = input.nextInt();
                    tries++;
                    if(tries >= limitedAttempts){
                        System.out.println("No more attempts, better luck next time.");
                        System.out.println("The correct number was " + secretNumber);
                        break;
                    } else if (yourNumber == secretNumber){
                        System.out.println("Good job!");
                        displayTries(tries);
                        break;
                    } else {
                        wordHint("Medium", yourNumber, secretNumber);
                    }
                } while (true);
                break;

            // Hard mode (75)

            case 3:
                limitedAttempts = 17;
                tries = 0;
                secretNumber = numberShuffling("Hard");
                System.out.println("Mode: Hard\nChoose a number between 1 and 75.");
                do {
                    System.out.println("Your Guess: ");
                    yourNumber = input.nextInt();
                    tries++;
                    if(tries >= limitedAttempts){
                        System.out.println("No more attempts, better luck next time.");
                        System.out.println("The correct number was " + secretNumber);
                        break;
                    } else if (yourNumber == secretNumber){
                        System.out.println("Good job!");
                        displayTries(tries);
                        break;
                    } else {
                        wordHint("Hard", yourNumber, secretNumber);
                    }
                } while (true);
                break;

            // Expert mode (150)

            case 4:
                limitedAttempts = 25;
                tries = 0;
                secretNumber = numberShuffling("Expert");
                System.out.println("Mode: Expert\nChoose a number between 1 and 150.");
                do {
                    System.out.println("Your Guess: ");
                    yourNumber = input.nextInt();
                    tries++;
                    if(tries >= limitedAttempts){
                        System.out.println("No more attempts, better luck next time.");
                        System.out.println("The correct number was " + secretNumber);
                        break;
                    } else if (yourNumber == secretNumber){
                        System.out.println("Good job!");
                        displayTries(tries);
                        break;
                    } else {
                        wordHint("Expert", yourNumber, secretNumber);
                    }
                } while (true);
                break;

            default:
                System.out.println("Invalid input. Try again.");
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

    public int numberShuffling(String difficulty){
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

    public static void main(String[] args){
            numberGuessingGame newGame = new numberGuessingGame();
            newGame.startGame();
        }
}
