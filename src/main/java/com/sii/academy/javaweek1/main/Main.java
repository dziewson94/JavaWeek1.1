package com.sii.academy.javaweek1.main;

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Main {
    private static int lowerBoundary = 0;
    private static int upperBoundary = 99;


    public static void main(String[] args) {
        /*for (int i = 1; i <= 3; i++) {
            System.out.println(InequalityGenerator.generateInequality(i));
            System.out.println("-------------------------------------------------------");
        }*/
        readArgs(args);
        int numberToGuess = ThreadLocalRandom.current().nextInt(lowerBoundary, upperBoundary + 1);
        System.out.println("Winning number has been chosen");
        System.out.printf("Please provide number between %d and %d inclusive%n", lowerBoundary, upperBoundary);
        int tryNum = 1;
        while (tryNum <= 5) {
            int userInput;

            userInput = getUserInput();
            if (verifyProvidedInput(numberToGuess, tryNum, userInput)) break;
            tryNum++;
        }

    }

    private static boolean verifyProvidedInput(int numberToGuess, int tryNum, int userInput) {
        if (userInput == numberToGuess) {
            System.out.printf("You have provided correct number: %d%nCongratulations%n", userInput);
            return true;
        } else if (tryNum < 5) {
            System.out.printf("No, incorrect. Sorry. Please try again. Attempts %d/5%n", tryNum);
            String message = userInput < numberToGuess ? "lower" : "greater";
            System.out.printf("Provided number is %s than selected by program%n", message);
        } else {
            System.out.printf("Looser, Winning number is:%d", numberToGuess);
            return true;
        }
        return false;
    }

    private static int getUserInput() {
        boolean isUserIdiot = true;
        int userInput = -1;


        while (isUserIdiot) {
            try {
                Scanner scanner = new Scanner(System.in);
                userInput = scanner.nextInt();
                if (userInput < lowerBoundary || userInput > upperBoundary) {
                    System.out.println("Please read instructions carefully, pay attention to boundaries");
                    continue;
                }
                isUserIdiot = false;
            } catch (Exception ex) {
                System.out.printf("Are you able to read?%nPlease provide integer value between %d and %d inclusive unless you are idiot.%nException: %s", lowerBoundary, upperBoundary, ex);

            }
        }
        return userInput;
    }

    private static int parseArg(String arg, String message, boolean firstVal) {
        int val;
        try {
            val = Integer.parseInt(arg);

        } catch (NumberFormatException exception) {
            System.out.println(message);
            return firstVal ? 0 : 99;
        }
        return val;
    }

    private static void readArgs(String[] args) {
        lowerBoundary = parseArg(args[0], String.format("First  argument provided by user is incorrect: %s. Lower boundary will be 0.%n", args[0]), true);
        lowerBoundary = parseArg(args[1], String.format("Second argument provided by user is incorrect: %s. Upper boundary will be 99.%n", args[1]), false);

        if (lowerBoundary >= upperBoundary) {
            System.out.printf("Upper boundary is bigger or equal lower one.%nLower boundary:%d%nUpper boundary:%d.%nBoundaries will be set:0 and 99%n", lowerBoundary, upperBoundary);
            lowerBoundary = 0;
            upperBoundary = 99;
        }
        System.out.printf("Boundaries:%nLower:%d%nUpper:%d%n", lowerBoundary, upperBoundary);
    }
}
