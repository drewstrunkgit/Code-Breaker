package com.drewstrunk.codebreak;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by dhisatak on 2/12/2018.
 */
public class Game {
    public static int guessesMade = 0;
    static int[] code = new int[4];
//    static int[] code = {0,2,8,2};


    public static void setCode() {
        for (int x = 0; x < 4; x++) {
            code[x] = (int) (Math.random() * 10);
        }
    }

    public static void main(String[] args) {
        //Declare a variable for the minimum number of guesses.
        int minGuesses = 1;
        //Declare a variable for the maximum number of guesses.
        int maxGuesses = 0;
        //Declare a variable for the total number of guesses.
        int sumGuesses = 0;

        //To calculate the average over 10,000 attempts, we'll run the entire CodeBreaker game 10,000 times.
        for (int z = 0; z < 10000; z++) {
            //Sets the code to a random 4 digit number.
            setCode();

            //Create a counter to keep track of how many numbers we know are correct.
            int correctNumCount = 0;

            //Create a counter to keep track of the number of guesses for each attempt.
            int numGuesses = 0;

            //Create an array where we can store numbers that we know are correct.
            //Start with 20 in every position so that we can easily see when a number is replaced while debugging.
            int correctNumbers[] = {20, 20, 20, 20};

            //We want to run the code that figures out our numbers and their position 9 times, once for each number.
            for (int y = 0; y < 10; y++) {
                //Create our aGuess array and assign each position to the value that is our loop variable. 0,0,0,0, then 1,1,1,1, etc.
                int[] aGuess = {y, y, y, y};
                //Declare variables for checking our results and getting our star count.
                String getAnswer = checkresult(aGuess);
                int getStarCount = countChars('*', getAnswer);
                //Whenever we make a guess using checkresult we want to increment our number of guesses by 1.
                numGuesses++;
                //If we get a star, we know that at least one of the numbers is a 0, now we need to know where it goes.
                if (getStarCount > 0) {
                    //We want to run this code for each position in the Array.
                    for (int x = 0; x < aGuess.length; x++) {
                        //Start by putting 10 into every position in the aGuess array.
                        aGuess[0] = 10;
                        aGuess[1] = 10;
                        aGuess[2] = 10;
                        aGuess[3] = 10;

                        //Change the value of whichever position we are currently at to the value in our outside loop (0-9)
                        aGuess[x] = y;
                        getAnswer = checkresult(aGuess);
                        numGuesses++;
                        getStarCount = countChars('*', getAnswer);

                        //If we get a star, we know that the position we are at is where the number goes.
                        //Assign the position we are at to the value in our outside loop (0-9)
                        if (getStarCount == 1) {
                            correctNumbers[x] = y;
                            correctNumCount++;
                        }
                    }
                }
                //If the number of guesses in this attempt is less than the current minimum guesses, this number of guesses is our new minimum.
                if (numGuesses < minGuesses) {
                    minGuesses = numGuesses;
                }
                //If the number of guesses in this attempt is greater than the current maximum guesses, this number of guesses is our new maximum.
                if (numGuesses > maxGuesses) {
                    maxGuesses = numGuesses;
                }
                //Once we have figured out all 4 numbers, stop guessing.
                if (correctNumCount == 4) {
                    break;
                }
            }
            //Add the number of guesses from this attempt to the total number of guesses.
            sumGuesses = (sumGuesses + numGuesses);
        }
        //Print our minimum number of guesses.
        System.out.println("Minimum number of guesses: " + minGuesses);
        //Print our maximum number of guesses.
        System.out.println("Maximum number of guesses: " + maxGuesses);
        //Print our average number of guesses.
        System.out.println("The average number of guesses is: " + (sumGuesses / 10000));
    }

    // Create a loop to continue guessing and implement codebreaker logic
    // Include a counter to determine how many attempts it took to break the code.
    // You have been supplied two methods to check your guess an count the type of character in the string
    // checkResult will return a String with a star if the number is the right value and position and a dash if the number is in the answer but not in the right position
    // Example combination = 1234 guess = 1400 result = "*-"
    // countChars is a method that returns the number of times a character appears in a string
    // Example countChars("daddy",'d') returns 3

    protected static String checkresult(int[] aGuess) {
        {
            guessesMade++; //keep track of how many guesses have been made
            ArrayList<Integer> codeMatchIndex = new ArrayList<Integer>(); //keep track of which code indexes are already marked with either * or -

            StringBuilder answer = new StringBuilder();

            //find direct matches
            for (int index = 0; index < 4; index++) {
                if (aGuess[index] == code[index]) {
                    codeMatchIndex.add(index);
                    answer.append("*");
                }
            }

            //find partial matches from remaining
            for (int guessIndex = 0; guessIndex < 4; guessIndex++) {
                if (codeMatchIndex.contains(guessIndex)) continue; //already counted skip it

                for (int codeIndex = 0; codeIndex < 4; codeIndex++) {
                    if (codeMatchIndex.contains(codeIndex)) continue; //already counted skip it

                    if (aGuess[guessIndex] == code[codeIndex]) {
                        codeMatchIndex.add(codeIndex);
                        answer.append("-");
                    }
                }
            }

            return answer.toString();

        }
    }

    protected static int countChars(char character, String str) {
        int count = 0;

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == character) {
                count++;
            }
        }
        return count;
    }
}



