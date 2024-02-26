package reverse_words;

import java.util.LinkedList;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().reverseWords("hello   asd world"));;
    }
    public String reverseWords(String s) {
        s = s.trim();
        if(s.length() == 0){
            return s;
        }
        final var words = s.split(" ");
        final var q = new LinkedList<String>();
        int wordsCount = 0;
        for(final var word:words){
            if(!word.isEmpty()){
                q.addFirst(word);
                wordsCount++;
            }
        }
        final StringBuilder sBuilder = new StringBuilder();
        while (wordsCount > 0){
            sBuilder.append(q.poll()).append(" ");
            wordsCount--;
        }
        return sBuilder.toString().trim();
    }
}
