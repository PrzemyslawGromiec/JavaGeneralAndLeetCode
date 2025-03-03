package org.example.scratchBook;

import java.util.Scanner;

public class ScratchBook {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int number = 0;

        while (true) {
            System.out.print("Please enter an integer: ");
            String input = scanner.nextLine();

            if (input.trim().isEmpty()) {
                System.out.println("Input cannot be empty. Please enter a valid integer.");
                continue;
            }

            Scanner lineScanner = new Scanner(input);
            if (lineScanner.hasNextInt()) {
                number = lineScanner.nextInt();
                break;
            } else {
                System.out.println("That's not a valid integer. Please try again.");
            }

            lineScanner.close();
        }

        System.out.println("You entered the integer: " + number);
        scanner.close();
    }


}
