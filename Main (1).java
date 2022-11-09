// This program is the text based version of the game Mastermind and uses numbers
// instead of colours. The computer generates a random code and the user has to
// try and guess the code within 10 tries

import java.util.*;
import java.text.*;
import java.io.*;

class Main {

    // method for checking the user's guess and giving feedback
    public static int guessChecking (int i, int code[], int guess[]) {

        // variables in order to count number of correct guesses
        int halfCorrect = 0;
        int fullCorrect = 0;

        // arrays used so that numbers are not counted more or less
        int halfCheck[] = new int[4];
        halfCheck[0] = 0;
        halfCheck[1] = 0;
        halfCheck[2] = 0;
        halfCheck[3] = 0;

        int fullCheck[] = new int[4];
        fullCheck[0] = 0;
        fullCheck[1] = 0;
        fullCheck[2] = 0;
        fullCheck[3] = 0;

        // counter variable
        int a = 0;

        // loop to check if guess is correct and in the right spot
        for (a = 0; a < code.length; a++) {
            if (guess[a] == code[a]) {
                fullCorrect++;
                fullCheck[a] = 1;
                halfCheck[a] = 1;
            } 
        }

    // loop to check if guess is correct but in the wrong spot
        for (a = 0; a < code.length; a++) {
            if (fullCheck[a] == 0 && halfCheck[(a + 1) % 4] == 0 && 
                    guess[a] == code[(a + 1) % 4]) {
                halfCorrect++;
                halfCheck[(a + 1) % 4] = 1;
            } else if (fullCheck[a] == 0 && halfCheck[(a + 2) % 4] == 0 && 
                    guess[a] == code[(a + 2) % 4]) {
                halfCorrect++;
                halfCheck[(a + 2) % 4] = 1;
            } else if (fullCheck[a] == 0 && halfCheck[(a + 3) % 4] == 0 && 
                    guess[a] == code[(a + 3) % 4]) {
                halfCorrect++;
                halfCheck[(a + 3) % 4] = 1;
                }  
            }     

 
        // give feedback to the user and say if they won or lost
        if (i == 10 && fullCorrect != 4) {
            System.out.println("\nSorry, you have run out of tries and have not"
                    + " guessed the code. The correct code was " + code[0]
                    + "" + code[1] + "" + code[2] + "" + code[3]);
        } else if (fullCorrect != 4) {
            System.out.println("\nThere are " + fullCorrect + " numbers that are"
                    + " correct and in the right place.\nThere are " + halfCorrect 
                    + " numbers that are correct but are in the wrong place");
        } else if (fullCorrect == 4) {
            i = 11;
            System.out.println("\nCongratulations! You have guessed the code!");
        } 
            return (i);
    }

    public static void main(String[] args) {

        // explains the rules of the game
        System.out.println("MasterMind \n\nWelcome to Mastermind. \nIn this game,"
                + " the computer will generate a 4 digit code from 1 to 6" 
                + " (could repeat digits) and\nyou will be given 10 attempts to"
                + " guess the code. Each time you guess, the computer will tell\nyou"
                + " how many digits are correct and in the right place, and how"
                + " many digits are correct and\nin the wrong place.");

        // used to create a random code
        Random randomNum = new Random();

        // introduce scanner to read input
        Scanner scan = new Scanner(System.in);

        // counter variables and loop variables
        int repeat = 1;
        int i = 1;
        int invalid = 1;
    
        // do loop to repeat the game
        do {

        // array to store values of random code
        int code[] = new int[4];
        code[0] = randomNum.nextInt(6) + 1;
        code[1] = randomNum.nextInt(6) + 1;
        code[2] = randomNum.nextInt(6) + 1;
        code[3] = randomNum.nextInt(6) + 1;

        System.out.println("\nThe system has generated a code");

        // for loop to ask the user for input
        for (i = 1; i <= 10; i++) {           
        
            do {
            System.out.println("\nPlease input your guess number " + i + ":");

            String input = scan.next();
            int length = input.length();

            // check for invalid input
            if (length == 4) {

                // array to store the guesses
                int guess[] = new int[4];
                guess[0] = Character.getNumericValue(input.charAt(0));
                guess[1] = Character.getNumericValue(input.charAt(1));
                guess[2] = Character.getNumericValue(input.charAt(2));
                guess[3] = Character.getNumericValue(input.charAt(3));

                // check for more invalid input
                if (guess[0] > 0 && guess[0] < 7 && guess[1] > 0 && guess[1] < 7 
                        && guess[2] > 0 && guess[2] < 7 && guess[3] > 0 
                        && guess[3] < 7) {

                    // call method to check user's guess
                    i = guessChecking(i, code, guess);
                    invalid = 0;
                } else {
                    System.out.println("\nInput number is invalid, please"
                            + " try again");
                    invalid = 1;
                }
            } else {
                System.out.println("\nInvalid input, please try again");
                invalid = 1;
            }            
          } while (invalid == 1);       
        }

        // asking user if they want to play again
        System.out.println("\nWould you like to play again? Press 1 to play again");
        int inputRepeat = scan.nextInt();
        repeat = inputRepeat;
        i = 1;
        } while (repeat == 1);
    }
}