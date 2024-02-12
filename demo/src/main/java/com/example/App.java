package com.example;

import java.text.DecimalFormat;
import java.util.Scanner;

/*
 * ChavviCalc Calculator App
 * Brendan Bobryk, 1036738
 * Assignment Week 3/4
 */
public class App {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Character command = '_';

        // variable declarations
        boolean success = true;
        float[] valuesAB = new float[2];
        valuesAB[0] = 0.0f;
        valuesAB[1] = 0.0f;
        DecimalFormat df = new DecimalFormat("#0.000");

        // loop until user quits
        while (command != 'q') {
            if (success == false) {
                System.out.println("Only the listed commands are available to be entered.");
            }
            printMenu(valuesAB, df);
            System.out.print("Enter a command: ");
            command = menuGetCommand(scan);
            success = executeCommand(scan, command, valuesAB);
        }

        scan.close();
    }

    // menu functions
    private static void printMenuLine() {
        System.out.println(
                "----------------------------------------------------------");
    }

    private static void printMenuCommand(Character command, String desc) {
        System.out.printf("%s\t%s\n", command, desc);
    }

    // prints the menu
    public static void printMenu(float[] valuesAB, DecimalFormat df) {
        printMenuLine();
        System.out.println("ChavviCalc");
        printMenuLine();
        // formats and prints the values of A and B
        System.out.println("A = " + df.format(valuesAB[0]) + "     B = " + df.format(valuesAB[1]));
        printMenuLine();

        printMenuCommand('a', "Enter a value for A");
        printMenuCommand('b', "Enter a value for B");
        printMenuCommand('+', "Add");
        printMenuCommand('-', "Subtract");
        printMenuCommand('*', "Multiply");
        printMenuCommand('/', "Divide");
        printMenuCommand('c', "Clear");
        printMenuCommand('q', "Quit");

        printMenuLine();
    }

    // get first character from input
    private static Character menuGetCommand(Scanner scan) {
        Character command = '_';

        String rawInput = scan.nextLine();

        if (rawInput.length() > 0) {
            rawInput = rawInput.toLowerCase();
            command = rawInput.charAt(0);
        }

        return command;
    }

    // calculator functions
    private static Boolean executeCommand(Scanner scan, Character command, float[] valuesAB) {
        Boolean success = true;

        switch (command) {
            case 'a': // assigning a value to A
                System.out.print("Enter a number: ");
                try {
                    valuesAB[0] = scan.nextFloat();
                } catch (Exception e) {
                    System.out.println("ERROR: The value entered is not a floating point number.");
                }
                scan.nextLine();
                break;

            case 'b': // assigning a value to B
                System.out.print("Enter a number: ");
                try {
                    valuesAB[1] = scan.nextFloat();
                } catch (Exception e) {
                    System.out.println("ERROR: The value entered is not a floating point number.");
                }
                scan.nextLine();
                break;
            case '+': // adding values A and B
                valuesAB[0] = valuesAB[0] + valuesAB[1];
                break;
            case '-': // subtracting values A and B
                valuesAB[0] = valuesAB[0] - valuesAB[1];
                break;
            case '*': // multiplying values A and B
                valuesAB[0] = valuesAB[0] * valuesAB[1];
                break;
            case '/': // dividing values A and B
                if (valuesAB[1] == 0) {
                    System.out.println("ERROR: Unable to divide by 0.");
                } else {
                    valuesAB[0] = valuesAB[0] / valuesAB[1];
                }
                break;
            case 'c': // resetting the values A and B to 0
                valuesAB[0] = 0;
                valuesAB[1] = 0;
                break;
            case 'q': // quitting the program
                System.out.println("Thank you for using ChavviCalc");
                break;
            default: // error handling
                System.out.println("ERROR: Unknown command");
                success = false;
        }

        return success;
    }
}
