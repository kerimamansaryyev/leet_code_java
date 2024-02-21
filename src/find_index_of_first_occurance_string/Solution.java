package find_index_of_first_occurance_string;

public class Solution {

    public static void main(String[] args) {
        final var solution = new Solution();
        System.out.println(solution.strStr("mississippi", "issip"));;
    }
    public int strStr(String haystack, String needle) {
        if (needle.length() > haystack.length()) {
            return -1;
        }
        int haystackPointer = 0;
        int needlePointer = 0;

        while (haystackPointer < haystack.length()) {
            System.out.println(haystack.charAt(haystackPointer));
            System.out.println(needle.charAt(needlePointer));
            System.out.println();
            if (needle.charAt(needlePointer) == haystack.charAt(haystackPointer)) {
                needlePointer++;
            } else if(needlePointer>0){
                haystackPointer -= (needlePointer-1);
                needlePointer = 0;

            }
            if (needlePointer == needle.length()) {
                return haystackPointer - (needlePointer - 1);
            }
            haystackPointer++;
        }
        return -1;
    }
}
