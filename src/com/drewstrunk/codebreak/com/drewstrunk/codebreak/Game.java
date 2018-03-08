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
        System.out.println(Arrays.toString(code));
        int correctNumCount = 0;
        int correctNumbers[] = {0, 0, 0, 0};

        int[] aGuess = {0, 0, 0, 0};
        String getAnswer = checkresult(aGuess);
        int getStarCount = countChars('*', getAnswer);
        int getDashCount = countChars('-', getAnswer);
        System.out.println(Arrays.toString(aGuess));
        System.out.println(getStarCount);
        System.out.println(getDashCount);
        System.out.println();

        if (getStarCount == 1) {
            aGuess[0] = 0;
            aGuess[1] = 10;
            aGuess[2] = 10;
            aGuess[3] = 10;
            getAnswer = checkresult(aGuess);
            getStarCount = countChars('*', getAnswer);
            getDashCount = countChars('-', getAnswer);

            if (getStarCount == 1) {
                correctNumbers[correctNumCount] = 0;
                correctNumCount++;
            } else if (getStarCount == 0) {
                aGuess[0] = 10;
                aGuess[1] = 0;
                aGuess[2] = 10;
                aGuess[3] = 10;
                getAnswer = checkresult(aGuess);
                getStarCount = countChars('*', getAnswer);
                getDashCount = countChars('-', getAnswer);

                if (getStarCount == 1) {
                    correctNumbers[correctNumCount] = 0;
                    correctNumCount++;
                } else if (getStarCount == 0) {
                    aGuess[0] = 10;
                    aGuess[1] = 10;
                    aGuess[2] = 0;
                    aGuess[3] = 10;
                    getAnswer = checkresult(aGuess);
                    getStarCount = countChars('*', getAnswer);
                    getDashCount = countChars('-', getAnswer);

                    if (getStarCount == 1) {
                        correctNumbers[correctNumCount] = 0;
                        correctNumCount++;
                    } else if (getStarCount == 0) {
                        aGuess[0] = 10;
                        aGuess[1] = 10;
                        aGuess[2] = 10;
                        aGuess[3] = 0;
                        getAnswer = checkresult(aGuess);
                        getStarCount = countChars('*', getAnswer);
                        getDashCount = countChars('-', getAnswer);

                        if (getStarCount == 1) {
                            correctNumbers[correctNumCount] = 0;
                            correctNumCount++;
                        }
                    }
                }
            }

            System.out.println(Arrays.toString(correctNumbers));
        }

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
                getDashCount = countChars('-', getAnswer);

                if (getStarCount == 1) {
                    correctNumbers[correctNumCount] = 1;
                    correctNumCount++;
                } else if (getStarCount == 0) {
                    aGuess[0] = 10;
                    aGuess[1] = 1;
                    aGuess[2] = 10;
                    aGuess[3] = 10;
                    getAnswer = checkresult(aGuess);
                    getStarCount = countChars('*', getAnswer);
                    getDashCount = countChars('-', getAnswer);

                    if (getStarCount == 1) {
                        correctNumbers[correctNumCount] = 1;
                        correctNumCount++;
                    } else if (getStarCount == 0) {
                        aGuess[0] = 10;
                        aGuess[1] = 10;
                        aGuess[2] = 1;
                        aGuess[3] = 10;
                        getAnswer = checkresult(aGuess);
                        getStarCount = countChars('*', getAnswer);
                        getDashCount = countChars('-', getAnswer);

                        if (getStarCount == 1) {
                            correctNumbers[correctNumCount] = 1;
                            correctNumCount++;
                        } else if (getStarCount == 0) {
                            aGuess[0] = 10;
                            aGuess[1] = 10;
                            aGuess[2] = 10;
                            aGuess[3] = 1;
                            getAnswer = checkresult(aGuess);
                            getStarCount = countChars('*', getAnswer);
                            getDashCount = countChars('-', getAnswer);

                            if (getStarCount == 1) {
                                correctNumbers[correctNumCount] = 1;
                                correctNumCount++;
                            }
                        }
                    }
                }

                System.out.println(Arrays.toString(correctNumbers));
            }
    }




    /*    for (int y = 0; y < 9; y++) {
            aGuess[0] = aGuess[0] + 1;
            aGuess[1] = aGuess[1] + 1;
            aGuess[2] = aGuess[2] + 1;
            aGuess[3] = aGuess[3] + 1;
            getAnswer = checkresult(aGuess);
            getStarCount = countChars('*', getAnswer);
            getDashCount = countChars('-', getAnswer);
            System.out.println(Arrays.toString(aGuess));
            System.out.println(getStarCount);
            System.out.println(getDashCount);
            System.out.println();
        }

           /*  aGuess[0] = (aGuess[0] + 1);
            aGuess[1] = (aGuess[1] + 1);
            aGuess[2] = (aGuess[2] + 1);
            aGuess[3] = (aGuess[3] + 1);

            System.out.println(checkresult(aGuess));
            System.out.println("This is guess: " + x);
            System.out.println(Arrays.toString(aGuess));

            */

    // Create a loop to continue guessing and implement codebreaker logic
    // Include a counter to determine how many attempts it took to break the code.
    // You have been supplied two methods to check your guess an count the type of character in the string
    // checkResult will return a String with a star if the number is the right value and position and a dash if the number is in the answer but not in the right position
    // Example combination = 1234 guess = 1400 result = "*-"
    // countChars is a method that returns the number of times a character appears in a string
    // Example countChars("daddy",'d') returns 3

//        int[] guess = {2,2,3,4};
//        System.out.println(checkresult(guess));

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



