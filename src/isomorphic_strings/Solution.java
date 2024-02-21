package isomorphic_strings;

import java.util.HashMap;

public class Solution {
    public static void main(String[] args) {
        final var solution = new Solution();
        System.out.println(solution.isIsomorphic("egg", "add"));
    }
    public boolean isIsomorphic(String s, String t) {
        if(s.length() < 2){
            return  true;

        }
        else if(s.equals(t)){
            return true;
        }

        final var sChars = s.toCharArray();
        final var tChars = t.toCharArray();
        final var pairsOfS = new HashMap<Character, Character>();
        final var pairsOfT = new HashMap<Character, Character>();

        for (int i = 0; i < s.length(); i++) {
            final var sPair = pairsOfS.get(sChars[i]);
            final var tPair = pairsOfT.get(tChars[i]);
            if(sPair == null && tPair == null){
                pairsOfS.put(sChars[i], tChars[i]);
                pairsOfT.put(tChars[i], sChars[i]);
            }
            else if(sPair == null || tPair == null || !sPair.equals(tChars[i]) || !tPair.equals(sChars[i]) ){
                return false;
            }
        }

        return  true;
    }
}
