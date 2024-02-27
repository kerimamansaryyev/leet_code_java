package move_zeros;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        final var nums = new int[]{0,1,0,3,1,2};
        final var solution = new Solution();
        solution.moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }
    public void moveZeroes(int[] nums) {
        if(nums.length < 2){
            return;
        }

        int nextAvailableSpot = 0;

        for (int i = 0; i < nums.length;) {
            while(i<nums.length && nums[i] == 0){
                i++;
            }
            if(i>=nums.length){
                return;
            }
            final var temp = nums[nextAvailableSpot];
            nums[nextAvailableSpot++] = nums[i];
            nums[i++] = temp;
        }
    }
}
