package Algos.ArrayAlgos;

public class Searches {
    public static int linearSearch(int[] nums, int target) {
        // Iterate through each element of the array
        for(int i = 0; i < nums.length; ++i) {
            // compare the current element with the target
            if(nums[i] == target) {
                // return the index where the target is located
                return i;
            }
        }
        // return -1 if the target isn't found
        return -1;
        // Complexity:
        // time: O(n)
        // space: O(1)
    }

    public static int binarySearch(int[] nums, int target) {
        // Initialize the pointers
        int left = 0, right = nums.length-1;
        // continue searching while left pointer is less or equal to the right pointer
        while (left <= right) {
            // Calculate the middle index of the range
            int mid = left+(right-left)/2;

            // if the middle element is equal to the target, return its index
            if(nums[mid] == target) {
                return mid;
            }
            // if the middle element is less than target, shift the left pointer to mid+1
            else if(nums[mid] < target) {
                left = mid+1;
            }
            // else shift right pointer to mid-1
            else {
                right = mid-1;
            }
        }

        // return -1 if the target isn't found
        return -1;
        // Complexity:
        // time: O(log n)
        // space: O(1)
    }

    public static int ternarySearch() {
        return -1;
    }
}