package com.example;

import java.text.DecimalFormat;
import java.util.Scanner;

/*
 * Chavvicalc Calculator App
 * Brendan Bobryk, 1036738
 * Assignment week 3/4
 */
public class App {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Character command = '_';

        float A = 0.0f, B = 0.0f;
        DecimalFormat df = new DecimalFormat("#0.000");

        // loop until user quits
        while (command != 'q') {
            printMenu(A, B, df);
            System.out.print("Enter a command: ");
            command = menuGetCommand(scan);

            executeCommand(scan, command, A, B);
        }

        scan.close();
    }

    //
    // menu functions
    //
    private static void printMenuLine() {
        System.out.println(
                "----------------------------------------------------------");
    }

    private static void printMenuCommand(Character command, String desc) {
        System.out.printf("%s\t%s\n", command, desc);
    }

    // prints the menu
    public static void printMenu(Float A, Float B, DecimalFormat df) {
        printMenuLine();
        System.out.println("ChavviCalc");
        printMenuLine();
        System.out.println("A = " + df.format(A) + "     B = " + df.format(B));
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
    private static Boolean executeCommand(Scanner scan, Character command, float A, float B) {
        Boolean success = true;

        switch (command) {
            case 'a':
                System.out.print("Enter a number: ");
                A = scan.nextFloat();
                break;
            case 'b':
                System.out.print("Enter a number: ");
                B = scan.nextFloat();
                break;
            case '+':
                break;
            case '-':
                break;
            case '*':
                break;
            case '/':
                break;
            case 'c':
                break;
            case 'q':
                System.out.println("Thank you for using Chavvi Calc");
                break;
            default:
                System.out.println("ERROR: Unknown commmand");
                success = false;
        }

        return success;
    }
}
