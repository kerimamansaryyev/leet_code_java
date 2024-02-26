package summary_ranges;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Solution {
    public static void main(String[] args) {
        final var solution = new Solution();
        solution.summaryRanges(new int[]{0,1,2,4,5,7});
    }
    public List<String> summaryRanges(int[] nums) {
        if (nums.length == 0) {
            return List.of();
        }
        else if(nums.length == 1){
            return  List.of(String.valueOf(nums[0]));
        }

        final var list = new LinkedList<String>();
        int start = nums[0];
        boolean lastStandAlone = true;

        for (int i = 1; i < nums.length; i++) {
            if(nums[i] - nums[i-1] != 1){
                list.add(start == nums[i-1]? String.valueOf(start): (start + "->" + nums[i-1]));
                start = nums[i];
                lastStandAlone = true;
            }
            else{
                lastStandAlone = false;
            }
        }

        if(lastStandAlone){
            list.add(String.valueOf(nums[nums.length - 1]));
        }
        else{
            var i = nums.length-1;
            list.add(start == nums[i]? String.valueOf(start): (start + "->" + nums[i]));
        }

        return list;
    }
}
