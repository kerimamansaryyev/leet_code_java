package longest_common_prefix;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().longestCommonPrefix(new String[]{"flower", "flow", "flight"}));
        ;
    }

    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        if (strs.length == 1) {
            return strs[0];
        }

        final StringBuilder stringBuilder = new StringBuilder();
        String minString = Arrays.stream(strs).min(Comparator.comparingInt(String::length)).orElse("");

        for (int i = 0; i < minString.length(); i++) {
            for (final var word : strs) {
                if (word.charAt(i) != minString.charAt(i)) {
                    return stringBuilder.toString();
                }
            }
            stringBuilder.append(minString.charAt(i));
        }

        return stringBuilder.toString();
    }
}
