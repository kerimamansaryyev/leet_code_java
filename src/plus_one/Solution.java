package plus_one;

import java.util.Arrays;
import java.util.LinkedList;

public class Solution {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().plusOne(new int[]{})));
    }

    public int[] plusOne(int[] digits) {
        if (digits.length == 0) {
            return new int[]{};
        }

        final var queue = new LinkedList<Integer>();
        byte buffer = 1;
        int startIndex = digits.length - 1;

        do {
            final var result = digits[startIndex--] + buffer;
            buffer = 0;
            if (result > 9) {
                queue.addFirst(10 - result);
                buffer = 1;
            } else {
                queue.addFirst(result);
            }
        } while (startIndex >= 0);

        if (buffer == 1) {
            queue.addFirst(1);
        }

        final var result = new int[digits.length + buffer];
        startIndex = 0;

        while (!queue.isEmpty()){
            result[startIndex++] = queue.poll();
        }

        return result;
    }
}
