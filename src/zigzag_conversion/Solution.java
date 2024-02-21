package zigzag_conversion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().convert("PAYPALISHIRING", 4));
    }

    public String convert(String s, int numRows) {
        if (s.length() < 2 || numRows >= s.length()) {
            return s;
        }

        class ListNode{
            final char val;
            ListNode next;

            ListNode(char val){
                this.val = val;
            }
        }

        final var tails = new ListNode[numRows];
        final var heads = new ListNode[numRows];

        final int diagonalLength = Math.max(numRows - 2, 0);
        int visitedChars = 0;
        int currRow = 0;
        int currCol = 0;

        while (visitedChars < s.length()) {
            if (currRow == numRows) {
                currCol++;
                currRow = 0;
            }

            int columnOffset = currCol % (diagonalLength + 1);

            if (columnOffset != 0){
                currRow = (numRows - columnOffset) - 1;
            }

            if(tails[currRow] == null){
                tails[currRow] = new ListNode(s.charAt(visitedChars++));
                heads[currRow] = tails[currRow];
            }
            else{
                tails[currRow].next = new ListNode(s.charAt(visitedChars++));
                tails[currRow] = tails[currRow].next;
            }

            if (columnOffset == 0) {
                currRow++;
            } else {
                currRow = numRows;
            }
        }

        for(int i=tails.length-1;i>=1;i--){
            tails[i-1].next = heads[i];
        }

        final StringBuilder sBuilder = new StringBuilder();

        while (heads[0] != null){
            sBuilder.append(heads[0].val);
            heads[0] = heads[0].next;
        }

        return sBuilder.toString();
    }
}
