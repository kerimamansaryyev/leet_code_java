package rotate_array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    public static void main(String[] args) {
        final var solution = new Solution();
        final int[] nums = {1, 2, 3, 4, 5, 6, 7};
        solution.rotate(nums, 3);
        System.out.println(Arrays.toString(nums));
    }

    public void rotate(int[] nums, int k) {

        k = k % nums.length;

        if (nums.length < 2 || k == 0) {
            return;
        }

        int head = 0;
        int tail = nums.length - k - 1;

        while (head<tail){
            final var temp = nums[head];
            nums[head] = nums[tail];
            nums[tail] = temp;
            tail--;
            head++;
        }

        head = nums.length - k;
        tail = nums.length - 1;

        while (head<tail){
            final var temp = nums[head];
            nums[head] = nums[tail];
            nums[tail] = temp;
            tail--;
            head++;
        }

        head = 0;
        tail = nums.length - 1;

        while (head<tail){
            final var temp = nums[head];
            nums[head] = nums[tail];
            nums[tail] = temp;
            tail--;
            head++;
        }

    }
}
