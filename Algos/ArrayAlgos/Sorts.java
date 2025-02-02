package Algos.ArrayAlgos;

public class Sorts {
    public static void bubbleSort(int[] nums) {
        for(int i = 0; i < nums.length-1; ++i) {
            boolean isSwapped = false;

            for(int j = 0; j < nums.length-1-i; ++j) {
                if(nums[j] > nums[j+1]) {
                    isSwapped = true;
                    int tmp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = tmp;
                }
            }

            if(!isSwapped) break;
        }
    }

    public static void insertSort() {

    }
    public static void selectSort() {

    }
    public static void quickSort(int[] nums) {

    }
    public static void mergeSort(int[] nums) {

    }
}
