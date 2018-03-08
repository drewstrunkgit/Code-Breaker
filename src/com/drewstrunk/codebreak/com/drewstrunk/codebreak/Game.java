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

        setCode();
        //Set the code to 9, 0, 8, 1 for testing purposes.  Will delete this code when the algorithm is finished.
        code[0] = 9;
        code[1] = 0;
        code[2] = 8;
        code[3] = 1;
        //Print the code for debugging purposes.
        System.out.println(Arrays.toString(code));

        //Create a counter to keep track of how many numbers we know are correct.
        int correctNumCount = 0;

        //Create an array where we can store numbers that we know are correct.
        //Start with 20 in every position so that we can easily see when a number is replaced.
        int correctNumbers[] = {20, 20, 20, 20};

        //Start by guessing "0, 0, 0, 0"
        int[] aGuess = {0, 0, 0, 0};
        //Declare variables for checking our results and getting our star and dash counts.
        String getAnswer = checkresult(aGuess);
        int getStarCount = countChars('*', getAnswer);
        int getDashCount = countChars('-', getAnswer);
        //Print this stuff for debugging purposes.
        System.out.println(Arrays.toString(aGuess));
        System.out.println(getStarCount);
        System.out.println(getDashCount);
        System.out.println();

        //If we get a star, we know that one of the numbers is a 0, now we need to know where it goes.
        if (getStarCount == 1) {

            for (int x = 0; x < aGuess.length; x++) {
                aGuess[0] = 10;
                aGuess[1] = 10;
                aGuess[2] = 10;
                aGuess[3] = 10;

                aGuess[x] = 0;
                getAnswer = checkresult(aGuess);
                getStarCount = countChars('*', getAnswer);

                if (getStarCount == 1) {
                    correctNumbers[x] = 0;
                    correctNumCount++;
                }
            }
            System.out.println("The correct numbers so far are: " + Arrays.toString(correctNumbers));
        }
    }
            //Start by guessing with a 0 in the first position, with numbers that we know aren't correct in the other positions.
            /*
            aGuess[0] = 0;
            aGuess[1] = 10;
            aGuess[2] = 10;
            aGuess[3] = 10;
            getAnswer = checkresult(aGuess);
            getStarCount = countChars('*', getAnswer);

            //If we get a star, we know that the number is in the correct position.  We'll put a 0 in the first position of the array.
            //We'll also increment our correctNumCount variable because we've found our first correct number.
            if (getStarCount == 1) {
                correctNumbers[0] = 0;
                correctNumCount++;

            //If we didn't get a star, we need to try a 0 in the second position.
            //We'll repeat this process 4 times.  As soon as we get a star, we'll put a 0 in the appropriate position.
            } else if (getStarCount == 0) {
                aGuess[0] = 10;
                aGuess[1] = 0;
                aGuess[2] = 10;
                aGuess[3] = 10;
                getAnswer = checkresult(aGuess);
                getStarCount = countChars('*', getAnswer);

                if (getStarCount == 1) {
                    correctNumbers[1] = 0;
                    correctNumCount++;
                } else if (getStarCount == 0) {
                    aGuess[0] = 10;
                    aGuess[1] = 10;
                    aGuess[2] = 0;
                    aGuess[3] = 10;
                    getAnswer = checkresult(aGuess);
                    getStarCount = countChars('*', getAnswer);

                    if (getStarCount == 1) {
                        correctNumbers[2] = 0;
                        correctNumCount++;
                    } else if (getStarCount == 0) {
                        aGuess[0] = 10;
                        aGuess[1] = 10;
                        aGuess[2] = 10;
                        aGuess[3] = 0;
                        getAnswer = checkresult(aGuess);
                        getStarCount = countChars('*', getAnswer);

                        if (getStarCount == 1) {
                            correctNumbers[3] = 0;
                            correctNumCount++;
                        }
                    }
                }
            }
            //At this point, we'll know if a 0 is one of the numbers, and if so, where it goes.
            //Print the correctNumbers array for debugging purposes.
            System.out.println("Correct numbers so far: " + Arrays.toString(correctNumbers));
            System.out.println();
        }
            //Now, we'll guess 1,1,1,1 and repeat the process.  We'll do this through the number 9 and then we'll have all 4 numbers in the correct positions.
            aGuess[0] = 1;
            aGuess[1] = 1;
            aGuess[2] = 1;
            aGuess[3] = 1;
            getAnswer = checkresult(aGuess);
            getStarCount = countChars('*', getAnswer);
            getDashCount = countChars('-', getAnswer);
            System.out.println(Arrays.toString(aGuess));
            System.out.println(getStarCount);
            System.out.println(getDashCount);
            System.out.println();

            if (getStarCount == 1) {
                aGuess[0] = 1;
                aGuess[1] = 10;
                aGuess[2] = 10;
                aGuess[3] = 10;
                getAnswer = checkresult(aGuess);
                getStarCount = countChars('*', getAnswer);

                if (getStarCount == 1) {
                    correctNumbers[0] = 1;
                    correctNumCount++;
                } else if (getStarCount == 0) {
                    aGuess[0] = 10;
                    aGuess[1] = 1;
                    aGuess[2] = 10;
                    aGuess[3] = 10;
                    getAnswer = checkresult(aGuess);
                    getStarCount = countChars('*', getAnswer);

                    if (getStarCount == 1) {
                        correctNumbers[1] = 1;
                        correctNumCount++;
                    } else if (getStarCount == 0) {
                        aGuess[0] = 10;
                        aGuess[1] = 10;
                        aGuess[2] = 1;
                        aGuess[3] = 10;
                        getAnswer = checkresult(aGuess);
                        getStarCount = countChars('*', getAnswer);

                        if (getStarCount == 1) {
                            correctNumbers[2] = 1;
                            correctNumCount++;
                        } else if (getStarCount == 0) {
                            aGuess[0] = 10;
                            aGuess[1] = 10;
                            aGuess[2] = 10;
                            aGuess[3] = 1;
                            getAnswer = checkresult(aGuess);
                            getStarCount = countChars('*', getAnswer);

                            if (getStarCount == 1) {
                                correctNumbers[3] = 1;
                                correctNumCount++;
                            }
                        }
                    }
                }

                System.out.println("Correct numbers so far: " + Arrays.toString(correctNumbers));
                System.out.println();
            }
    }
    */
    //Need to add logic for 2+ stars.
    //Need to stop guessing when correctNumCount = 4
    //Need to track guesses and average guesses.

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



