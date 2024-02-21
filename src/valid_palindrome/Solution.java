package valid_palindrome;

public class Solution {
    public static void main(String[] args) {
        final var solution = new Solution();
        System.out.println(solution.isPalindrome("A man, a plan, a canal: Panama"));
    }
    public boolean isPalindrome(String s) {
        if(s.length() < 2){
            return  true;
        }
        s = s.trim();
        int head = 0;
        int tail = s.length()-1;
        while (head<tail){
            if(!Character.isAlphabetic(s.charAt(head)) && !Character.isDigit(s.charAt(head))){
                head++;
                continue;
            }
            if(!Character.isAlphabetic(s.charAt(tail)) && !Character.isDigit(s.charAt(tail))){
                tail--;
                continue;
            }
            if(Character.toLowerCase(s.charAt(head)) != Character.toLowerCase(s.charAt(tail))){
                return false;
            }
            head++;
            tail--;
        }
        return Character.toLowerCase(s.charAt(head)) == Character.toLowerCase(s.charAt(tail));
    }
}
