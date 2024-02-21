package happy_number;

public class Solution {
    public static void main(String[] args) {
        final var solution = new Solution();
        System.out.println(solution.isHappy(19));
    }

    public boolean isHappy(int n) {
        while (n > 9) {
            n = digitsSquareSum(n);
        }
        return n == 1 || n == 7;
    }

    private static int digitsSquareSum(int number) {
        if (number < 10) {
            return number * number;
        }

        return (int) (Math.pow(number % 10, 2) + digitsSquareSum(number / 10));
    }
}
