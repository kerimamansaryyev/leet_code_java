package length_last_word;

import java.util.Arrays;

public class Solution {
    public int lengthOfLastWord(String s) {
        int counter = 0;
        s = s.trim();

        for (int i = s.length() - 1; i >= 0; i--) {
            if(s.charAt(i) == ' '){
                return  counter;
            }
            counter++;
        }

        return counter;
    }
}
