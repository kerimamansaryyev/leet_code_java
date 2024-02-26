package remove_duplicates_from_sorted_array;

public class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length < 2) {
            return nums.length;
        }

        int prev = nums[0];
        int nextAvailableSpot = 1;

        for (int i = 1; i < nums.length;) {
            while (i<nums.length && nums[i] == prev){
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
