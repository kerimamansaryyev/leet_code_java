package median_of_two_sorted_arrays;

import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().findMedianSortedArrays(
                new int[]{1, 2},
                new int[]{3, 4}
        ));
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        if (nums1.length == 0 && nums2.length == 0) {
            return 0;
        }

        final var middle = ((nums1.length + nums2.length) / 2) + 1;
        final var merged = new int[middle];

        int num1Tracker = 0;
        int num2Tracker = 0;
        int i = 0;

        while (i < merged.length) {

            if (num1Tracker >= nums1.length) {
                merged[i++] = nums2[num2Tracker++];
                continue;
            }
            if (num2Tracker >= nums2.length) {
                merged[i++] = nums1[num1Tracker++];
                continue;
            }

            merged[i++] = nums1[num1Tracker] < nums2[num2Tracker] ? nums1[num1Tracker++] : nums2[num2Tracker++];
        }

        if (merged.length > 1 && (nums1.length + nums2.length) % 2 == 0) {
            return  ((double) (merged[merged.length-1] + merged[merged.length-2]))/2;
        }

        return merged[merged.length - 1];
    }
}
