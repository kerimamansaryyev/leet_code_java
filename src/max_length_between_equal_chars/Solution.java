package max_length_between_equal_chars;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().maxLengthBetweenEqualCharacters("scayofdzca"));
    }

    public int maxLengthBetweenEqualCharacters(String s) {
        final HashMap<Character, Integer> indices = new HashMap<>();
        final HashMap<Character, Integer> maxDifferencePerChar = new HashMap<>();

        int maxDifferences = -1;

        for(int i=0;i<s.length(); i++){
            final var currChar = s.charAt(i);

            if(!indices.containsKey(currChar)){
                indices.put(currChar, i);
                maxDifferencePerChar.put(currChar, 0);
            }

            else {
                final var lastDifference = maxDifferencePerChar.get(currChar);
                final var lastIndex = indices.get(currChar);
                final var difference = lastDifference + (i-lastIndex-1);
                if(difference > maxDifferences){
                    maxDifferences = difference;
                }
            }
        }

        return maxDifferences;
    }
}
