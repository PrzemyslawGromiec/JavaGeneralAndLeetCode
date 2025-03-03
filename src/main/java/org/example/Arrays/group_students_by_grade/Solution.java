package org.example.Arrays.group_students_by_grade;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        String[] students = {"John, 85", "Alice, 92", "Bob, 76", "Charlie, 65", "Diana, 89"};

        Map<String, List<String>> groupedStudents = groupStudentsByGrade(Arrays.stream(students).toList());

        displayGroupedStudents(groupedStudents);
    }


    public static String getGradeByScore(int score) {
        if (score >= 90 && score <= 100) {
            return "Excellent";
        } else if (score >= 80 && score <= 89) {
            return "Good";
        } else if (score >= 70 && score <= 79) {
            return "Average";
        } else {
            return "Below Average";
        }
    }

    public static Map<String, List<String>> groupStudentsByGrade(List<String> students) {
        Map<String, List<String>> groupedStudents = new LinkedHashMap<>();

        List<String> gradeOrder = List.of("Excellent", "Good", "Average", "Below Average");
        for (String grade : gradeOrder) {
            groupedStudents.put(grade, new ArrayList<>());
        }

        for (String student : students) {
            String[] parts = student.split(", ");
            String name = parts[0];
            int score = Integer.parseInt(parts[1]);

            String gradeCat = getGradeByScore(score);
            groupedStudents.get(gradeCat).add(name);
        }
        return groupedStudents;
    }

    public static void displayGroupedStudents(Map<String, List<String>> groupedStudents) {
        groupedStudents.forEach((grade, students) -> {
            System.out.println(grade + ": " + students);
        });
    }


}
