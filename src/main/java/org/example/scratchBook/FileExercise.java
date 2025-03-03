package org.example.scratchBook;

import java.io.*;
import java.util.Scanner;

public class FileExercise {

    public static void main(String[] args) throws IOException {
        File file = new File("C:\\Users\\pgrom\\OneDrive\\Desktop\\spring-6-webapp\\MyScratchBook\\src\\main\\resources\\sonnet.txt");
        Scanner input = new Scanner(file);
        int totalWords = 0;
        int totalLetters = 0;
        int even = 0;
        int odd = 0;

        while (input.hasNext()) {
            String line = input.nextLine();
            String[] array = line.split("\s+");
            int wordsInLine = array.length;
            //counting letters in word
            for (String s : array) {
                int lettersInWord = s.length();
                if (lettersInWord % 2 == 0) {
                    even++;
                } else {
                    odd++;
                }
                totalLetters += lettersInWord;
            }
            //total words in file
            totalWords += wordsInLine;
        }

        System.out.println("File analysed: " + file.getName());
        System.out.println("There were " + totalWords + " words and " + totalLetters + " letters.");
        System.out.println("There were " + even + " even words, and " + odd + " odd words.");
        input.close();

        FileWriter resultFile = new FileWriter("results.txt");
        PrintWriter output = new PrintWriter(resultFile);

        try {
            output.println("File analysed: " + file.getName());
            output.println("There were " + totalWords + " words and " + totalLetters + " letters.");
            output.println("There were " + even + " even words, and " + odd + " odd words.");
            output.close();
        } catch (Exception e) {
            e.getStackTrace();
        }
    }


}
