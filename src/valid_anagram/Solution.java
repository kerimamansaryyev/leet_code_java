package valid_anagram;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().isAnagram("anagram", "nagaram"));
    }

    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;

        return  s.length() >= 26? approach2(s, t): approach1(s, t);
    }


    public boolean approach1(String s, String t) {
            final var alphabet = new int[26];

            for (final var c:t.toCharArray()) {
                alphabet[c - 'a']++;
            }

            for (final var c:s.toCharArray()) {
                final var r = --alphabet[c - 'a'];
                if(r<0){
                    return  false;
                }
            }

            return true;
    }

    public boolean approach2(String s, String t) {
        final int[] alphabet = new int[26];

        for (int i = 0; i < s.length(); i++) {
            alphabet[s.charAt(i) - 'a']++;
            alphabet[t.charAt(i) - 'a']--;
        }

        for (final int count : alphabet) {
            if (count != 0) {
                return false;
            }
        }

        return true;
    }
}
