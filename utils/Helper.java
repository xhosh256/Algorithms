package utils;

import java.util.Random;

//this class will store all auxiliary methods
public class Helper {
    //Arrays
    public static int[] shuffle(int[] arr) {
        Random random = new Random();
        for (int i = 0; i < arr.length; i++) {
            int j = random.nextInt(arr.length);
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
        return arr;
    }

    public static void merge() {

    }
}
