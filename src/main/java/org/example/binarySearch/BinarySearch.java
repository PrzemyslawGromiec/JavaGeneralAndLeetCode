package org.example.binarySearch;

public class BinarySearch {
    public static void main(String[] args) {
        int[] numbers = {1,2,3,4,5,6,7};
        int elementToFindIndex = findElement(numbers,9);
        System.out.println(elementToFindIndex);
    }


    private static int findElement(int[] numbers, int numToFind) {
        int low = 0;
        int high = numbers.length -1;

        while (low <= high) {
            int midPosition = (low + high)/2;
            int midNum = numbers[midPosition];

            if (numToFind == midNum) {
                return midPosition;
            }

            if (numToFind < midNum) {
                high = midPosition - 1;
            } else {
                low = midPosition + 1;
            }
        }
        return -1;
    }
}
