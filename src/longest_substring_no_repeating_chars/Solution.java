package longest_substring_no_repeating_chars;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().lengthOfLongestSubstring("abcabcbb"));
    }
    public int lengthOfLongestSubstring(String s) {
        final HashSet<Character> uniques = new HashSet<>();
        final Queue<Character> charsQueue = new ArrayDeque<>(s.length());
        final char[] chars = s.toCharArray();
        int maxLength = 0;

        for(final Character c: chars){

            if(uniques.contains(c)){
                Character head;

                while(!charsQueue.isEmpty()){
                    head = charsQueue.remove();
                    uniques.remove(head);
                    if(head.equals(c)){
                        break;
                    }
                }
            }

            charsQueue.add(c);
            uniques.add(c);

            maxLength = Integer.max(maxLength, charsQueue.size());
        }

        return  maxLength;
    }
}
