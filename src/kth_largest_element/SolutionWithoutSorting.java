package kth_largest_element;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.stream.Collectors;

public class SolutionWithoutSorting {

    public static void main(String[] args) {
        System.out.println(new SolutionWithoutSorting().findKthLargest(new int[]{1, 2, 3, 4, 5}, 3));
    }

    public int findKthLargest(int[] nums, int k) {
        final int[] numsHeap = new int[nums.length + 1];

        int kthLargest = 0;

        for (int i = 0; i < nums.length; i++) {
            numsHeap[i + 1] = nums[i];
        }

        bottomUp(numsHeap);

        for (int i = 1; i <= k; i++) {
            kthLargest = numsHeap[1];;
            swap(1, numsHeap.length - i, numsHeap);
            downHeap(1,numsHeap, numsHeap.length - i - 1);
        }

        return kthLargest;
    }

    public void bottomUp(int[] rawHeap) {
        for (int i = (rawHeap.length - 1) / 2; i > 0; i--) {
            downHeap(i, rawHeap, null);
        }
    }

    public void downHeap(int index, int[] nums, Integer ignoreFromIndex) {

        int currentIndex = index;
        int k = maxChildIndex(index, nums, ignoreFromIndex);


        while (k != 0) {
            swap(currentIndex, k, nums);
            currentIndex = k;
            k = maxChildIndex(currentIndex, nums, ignoreFromIndex);
        }
    }

    public void swap(int i, int j, int[] nums) {
        final var temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public int maxChildIndex(int index, int[] nums, Integer ignoreFromIndex) {

        ignoreFromIndex = ignoreFromIndex == null? Integer.MAX_VALUE:ignoreFromIndex;

        if(index > ignoreFromIndex){
            return  0;
        }

        final var leftIndex = index * 2;
        final var rightIndex = (index * 2) + 1;

        var left = giveLeastIfNull(leftIndex, nums);
        var right = giveLeastIfNull(rightIndex, nums);

        if(leftIndex > ignoreFromIndex){
            left = Integer.MIN_VALUE;
        }

        if(rightIndex > ignoreFromIndex){
            right = Integer.MIN_VALUE;
        }

        if (nums[index] > left && nums[index] > right) {
            return 0;
        }

        return left > right ? leftIndex : rightIndex;
    }

    public int giveLeastIfNull(int index, int[] nums) {
        if (index >= nums.length) {
            return Integer.MIN_VALUE;
        }
        return nums[index];
    }


}
