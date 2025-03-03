package org.example.Arrays.zigzag_conversion_6;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        String s = "PAYPALISHIRING";
        int numRows = 3;
        System.out.println(convert(s, numRows));

    }

    public static String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }

        // Create an array of StringBuilder for each row
      /*  StringBuilder[] rows = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            rows[i] = new StringBuilder();
        }

        // Variables to track current row and direction
        int row = 0;
        int direction = 1; // Start by moving downward

        // Traverse the string and add each character to the appropriate row
        for (char c : s.toCharArray()) {
            rows[row].append(c);

            // If we reach the bottom or top row, reverse direction
            if (row == 0) {
                direction = 1; // Move down
            } else if (row == numRows - 1) {
                direction = -1; // Move up
            }

            // Move to the next row
            row += direction;
        }*/



        // Combine all rows to build the zigzag string
       /* StringBuilder result = new StringBuilder();
        for (StringBuilder sb : rows) {
            result.append(sb);
        }*/

        List<StringBuilder> rows = new ArrayList<>();
        for(int i = 0; i < Math.min(numRows, s.length()); i++) {
            rows.add(new StringBuilder());
        }

        int index = 0;
        boolean goingDown = false;

        for(char c : s.toCharArray()) {
            rows.get(index).append(c);
            if (index == 0 || index == (numRows -1)) {
                goingDown = !goingDown;
            }
            index += goingDown ? 1 : -1;
        }

        StringBuilder result = new StringBuilder();
        for(StringBuilder row : rows) {
            result.append(row);
        }



        return result.toString();

    }
}
