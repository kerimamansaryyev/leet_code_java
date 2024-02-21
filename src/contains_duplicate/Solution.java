package contains_duplicate;

import java.util.HashMap;
import java.util.HashSet;

public class Solution {
    public boolean containsDuplicate(int[] nums) {
        final var hashSet = new HashSet<>();
        for(final int num: nums){
            if(hashSet.contains(num)){
                return true;
            }
            hashSet.add(num);
        }
        return  false;
    }
}
