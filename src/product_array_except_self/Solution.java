package product_array_except_self;

import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().productExceptSelf(new int[]{1, 2, 3, 4})));
    }

    public int[] productExceptSelf(int[] nums) {
        if (nums.length < 2) {
            return nums;
        }

        int prefixProduct = 1;
        int suffixProduct = 1;

        final var result = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            result[i] = prefixProduct;
            prefixProduct *= nums[i];
        }

        for(int i=nums.length-1;i>=0;i--){
            result[i] *= suffixProduct;
            suffixProduct *= nums[i];
        }

        return  result;
    }
}
