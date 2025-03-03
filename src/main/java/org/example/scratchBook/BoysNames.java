package org.example.scratchBook;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class BoysNames {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("C:\\Users\\pgrom\\OneDrive\\Desktop\\spring-6-webapp\\MyScratchBook\\src\\main\\resources\\boys-names.txt");
        Scanner fileOutput = new Scanner(file);
        Scanner scanner = new Scanner(System.in);

        //top 100 names over years
        //first column rank
        //open, parse and stores the name data
        //input boy name
        //and it displays ranking by year
        // Year (1924) Ranked 68 etc
        System.out.println("Enter name : > ");
        String userInput = scanner.nextLine();
        System.out.println(userInput);


        while (fileOutput.hasNext()) {
            String line = fileOutput.nextLine();
            System.out.println(line);
            String[] lines = line.split("\s+");
            

        }


    }
}