package roman_to_int;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public int romanToInt(String s) {


        final var chars = s.toCharArray();
        final Map<Character, Integer> valueMap = new HashMap<>();
        final Map<Character, Character> precedanceMap = new HashMap<>();

        precedanceMap.put('I', null);
        precedanceMap.put('X', 'I');
        precedanceMap.put('V', 'I');
        precedanceMap.put('C', 'X');
        precedanceMap.put('L', 'X');
        precedanceMap.put('D', 'C');
        precedanceMap.put('M', 'C');

        valueMap.put('I', 1);
        valueMap.put('V', 5);
        valueMap.put('X', 10);
        valueMap.put('L', 50);
        valueMap.put('C', 100);
        valueMap.put('D', 500);
        valueMap.put('M', 1000);

        int result = valueMap.get(chars[0]);

        for(int i=1;i<chars.length;i++){
            final Character prevNeighbor = chars[i-1];
            final Character c = chars[i];
            final var isNeighborPreceding = prevNeighbor.equals(precedanceMap.get(c));

            result += valueMap.get(c) + (isNeighborPreceding? -2*valueMap.get(prevNeighbor): 0);
        }

        return  result;
    }

}
