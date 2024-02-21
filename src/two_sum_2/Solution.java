package two_sum_2;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    public static void main(String[] args) {
        final var s = new Solution();
        s.twoSum(new int[]{2,7,11,15}, 9);
    }
    public int[] twoSum(int[] numbers, int target) {
        final var reverseMap = new HashMap<Integer, LinkedList<Integer>>();
        for (int i = 0; i < numbers.length; i++) {
            reverseMap.computeIfAbsent(numbers[i], __ -> new LinkedList<>());
            reverseMap.get(numbers[i]).add(i);
        }
        for (final var key : reverseMap.keySet()) {
            final var diff = target - key;
            if (reverseMap.containsKey(diff)) {
                final var operand1 = reverseMap.get(diff).removeLast()+1;
                final var operand2 =reverseMap.get(key).removeLast()+1;
                return new int[]{
                        Math.min(operand1, operand2),
                        Math.max(operand1, operand2),
                };
            }
        }
        return new int[]{};
    }
}
