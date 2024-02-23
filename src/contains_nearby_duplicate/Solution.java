package contains_nearby_duplicate;

import java.util.HashMap;

public class Solution {
    public static void main(String[] args) {
        final var solution = new Solution();
        System.out.println(solution.containsNearbyDuplicate(new int[]{1,2,3,1}, 3));;
    }
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        final var indexTrackMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            final var lastIndex = indexTrackMap.get(nums[i]);
            if (lastIndex != null && i - lastIndex <= k) {
                return true;
            }
            indexTrackMap.put(nums[i], i);
        }
        return false;
    }
}
