package is_subsequence;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    public static void main(String[] args) {
        final var solution = new Solution();
        solution.isSubsequence("abc", "ahbgdc");
    }
    public boolean isSubsequence(String s, String t) {
        final Queue<Character> q = new LinkedList<>();
        for (final var c : s.toCharArray())
            q.add(c);
        for (final var c : t.toCharArray()) {
            if (q.isEmpty()) {
                return true;
            }
            if(q.element().equals(c)){
                q.poll();
            }
        }
        return  q.isEmpty();
    }
}
