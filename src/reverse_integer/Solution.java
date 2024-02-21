package reverse_integer;

import javax.swing.plaf.synth.SynthOptionPaneUI;

public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().reverse(-2147483412));
    }

    public int reverse(int x) {
        if (x == 0 || x == Integer.MIN_VALUE) {
            return 0;
        }

        int result = 0;
        boolean isNegative = x < 0;
        x = Math.abs(x);

        for (int i = 0; x > 0; i++, x /= 10) {
            int diff = Math.abs(isNegative?
                    Integer.MIN_VALUE/Math.max(result, 1):
                    Integer.MAX_VALUE/Math.max(result, 1));

            if(diff > 0 && Math.abs(diff) < 10){
                return  0;
            }
            result *= 10;
            result += (x % 10);
        }

        return (isNegative ? -result : result);
    }
}
