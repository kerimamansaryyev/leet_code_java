package remove_duplicates_from_sorted_array_2;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        final var solution = new Solution();
        final var nums = new int[]{1,1,1,2,2,3};
        System.out.println(solution.removeDuplicates(nums));
        System.out.println(Arrays.toString(nums));
    }
    public int removeDuplicates(int[] nums) {
        if (nums.length < 2) {
            return nums.length;
        }

        int prev = nums[0];
        int nextAvailableSpot = 1;

        for (int i = 1; i < nums.length;) {
            boolean found = false;
            while (i<nums.length && nums[i] == prev){
                if(!found){
                    nums[nextAvailableSpot++] = nums[i];
                    found = true;
                }
                i++;
            }
            if(i == nums.length){
                break;
            }
            prev = nums[nextAvailableSpot++] = nums[i++];
        }

        return nextAvailableSpot;
    }
}
