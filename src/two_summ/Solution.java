package two_summ;

import java.util.*;
import java.util.stream.Collectors;

public class Solution {
    public int[] twoSum(int[] nums, int target) {
        final var valueIndexMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            valueIndexMap.put(nums[i], i);
        }

        for(int i=0;i<nums.length;i++){
            final var diff = target - nums[i];

            if(!valueIndexMap.containsKey(diff)){
                continue;
            }

            final var index = valueIndexMap.get(diff);

            if(index != null && i != index){
                return  new int[]{i, index};
            }
        }

        return  new int[]{};
    }
}
