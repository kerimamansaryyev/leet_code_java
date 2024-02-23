package longest_consecutive_sequence;

import java.util.HashMap;
import java.util.HashSet;

public class Solution {
    public static void main(String[] args) {
        final var solution = new Solution();
        System.out.println(solution.longestConsecutive(new int[]{0,3,7,2,5,8,4,6,0,1}));
    }
    public int longestConsecutive(int[] nums) {
        if(nums.length < 2){
            return nums.length;
        }
        final var sequenceCounter = new HashMap<Integer, Integer>();
        int maxSeqCount = 0;
        for(final var num:nums){
            sequenceCounter.put(num, 1);
        }
        for(var num:nums){
            var resultCount = 0;
            var currNum = num;
            var nextCount = sequenceCounter.get(num);

            while (nextCount != null){
                resultCount+=nextCount;
                nextCount = sequenceCounter.get(--currNum);
                if(nextCount != null){
                    sequenceCounter.remove(currNum);
                }
            }

            sequenceCounter.put(num, resultCount);
            if(resultCount > maxSeqCount){
                maxSeqCount = resultCount;
            }
        }
        return  maxSeqCount;
    }
}
