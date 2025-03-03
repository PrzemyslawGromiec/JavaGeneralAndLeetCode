package org.example.intervals.runLengthEncode;

import java.util.ArrayList;
import java.util.List;

public class RunLengthEncode {
    public static void main(String[] args) {
        String input = "aaabccccde";
        List<String> encoded = runLengthEncode(input);
        System.out.println(encoded);
    }

    public static List<String> runLengthEncode(String s) {
        List<String> result = new ArrayList<>();
        if (s.isEmpty()) {
            return result;
        }

        for (int i = 0, j = 0; j < s.length();) {
            if (j + 1 < s.length() && s.charAt(j) == s.charAt(j + 1)) {
                j++;
            } else {
                if (i !=j ) {
                    result.add(s.charAt(i) + String.valueOf(j - i + 1));
                } else {
                    result.add(s.charAt(i) + "1");
                }
                i = j +1;
                j++;
            }
        }
        return result;
    }
}
