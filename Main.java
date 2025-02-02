import ArrayAlgos.*;

import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        System.out.println("SEARCHES");
        {
            int[] array = {7, 12, 5, 19, 3, 8, 14, 2, 10, 6, 17, 4, 11, 1, 9};
            int[] sortedArray = {3, 7, 12, 15, 22, 28, 34, 45, 58, 63, 79, 91, 101, 115, 130};

            // linear search example
            System.out.println("linear search example");
            System.out.println(Searches.linearSearch(array, 17)); // Output: 10
            System.out.println(Searches.linearSearch(array, 21)); // Output: -1;

            //binary search example (works only in sorted array)
            System.out.println("binary search example (works only in sorted array)");
            System.out.println(Searches.binarySearch(sortedArray, 91)); // Output: 11
            System.out.println(Searches.binarySearch(sortedArray, 18)); // Output: -1;
        }

        System.out.println("\nSORTS");
        {
            int[] array = {7, 12, 5, 19, 3, 8, 14, 2, 10, 6, 17, 4, 11, 1, 9};

            // bubble sort
            System.out.println("Bubble sort");
            System.out.println("Before sorting: " + Arrays.toString(array));
            Sorts.bubbleSort(array);
            System.out.println("After sorting: " + Arrays.toString(array));

            // quick sort
            System.out.println("Quick sort");
            shuffle(array);
            System.out.println("Before sorting: " + Arrays.toString(array));
            Sorts.bubbleSort(array);
            System.out.println("After sorting: " + Arrays.toString(array));
        }
    }

    public static void shuffle(int[] arr) {
        Random random = new Random();
        for (int i = 0; i < arr.length; i++) {
            int j = random.nextInt(arr.length);
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }
}
