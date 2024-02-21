package first_missing_positive;

import java.util.Arrays;
import java.util.HashSet;
import java.util.TreeSet;

public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().firstMissingPositive(
                new int[]{1,2,3,4,5,6,7,8,9,20}
        ));
    }

    public int firstMissingPositive(int[] nums) {
        final var hashSet = new HashSet<Integer>();
        int counter = 0;

        for(final int num: nums){
            if(num > 0){
                hashSet.add(num);
                counter++;
            }
        }

        for (int i = 1; i <= counter; i++) {
            if(!hashSet.contains(i)){
                return  i;
            }
        }

        return counter+1;
    }
}
