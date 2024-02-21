package remove_element;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        final var solution = new Solution();
        final int[] nums = {1};
        final var result = solution.removeElement(nums, 1);
        System.out.println(Arrays.toString(nums));
        System.out.println(result);
    }

    public int removeElement(int[] nums, int val) {
        int head = 0;
        int tail = nums.length - 1;
        int emptySpot = 0;

        while (head <= tail) {
            if (nums[head] == val) {
                final var temp = nums[tail];
                nums[head] = temp;
                nums[tail] = -1;
            }
            if (nums[head] != val) {
                head++;
            }
            if (nums[tail] == -1) {
                emptySpot++;
                tail--;
            }
        }
        return nums.length - emptySpot;
    }
}
