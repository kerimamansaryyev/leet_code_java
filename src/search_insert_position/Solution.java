package search_insert_position;

import java.util.Arrays;
import java.util.TreeSet;

public class Solution {
    public static void main(String[] args) {
        final var nums = new int[]{1, 3, 5, 6};
        System.out.println(new Solution().searchInsert(nums, 0));
    }

    public int searchInsert(int[] nums, int target) {
        if (nums.length == 0) {
            return 0;
        }

        int leftPtr = 0;
        int rightPtr = nums.length - 1;

        while (leftPtr <= rightPtr) {
            System.out.println(leftPtr);
            System.out.println(rightPtr);
            System.out.println();
            final var mid = (leftPtr + rightPtr) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (target > nums[mid]) {
                leftPtr = mid + 1;
            } else {
                rightPtr = mid - 1;
            }
        }

        return  leftPtr;
    }
}
