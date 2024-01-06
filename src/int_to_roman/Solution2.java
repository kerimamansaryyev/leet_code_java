package int_to_roman;

import java.util.*;

public class Solution2 {

    public static void main(String[] args) {
        System.out.println(new Solution2().intToRoman(1994));
    }

    public String intToRoman(int num) {
        enum RomanGroup {

            M(1000, null, "M"),
            CM(900, M, "CM"),

            D(500, CM, "D"),

            CD(400, D, "CD"),

            C(100, CD, "C"),

            XC(90, C, "XC"),

            L(50, XC, "L"),

            XL(40, L, "XL"),

            X(10, XL, "X"),

            IX(9, X, "IX"),

            V(5, IX, "V"),

            IV(4, V, "IV"),

            I(1, IV, "I");

            final int minVal;
            final RomanGroup next;

            final String signature;

            RomanGroup(int minVal, RomanGroup next, String signature) {

                this.minVal = minVal;
                this.next = next;
                this.signature = signature;
            }
        }

        if (num <= 0) {
            return "";
        }

        StringBuilder sBuilder = new StringBuilder();

        RomanGroup currG = RomanGroup.I;

        do {

            final var maxValue = currG.next == null ? 4000 : currG.next.minVal;

            if (num >= currG.minVal && num < maxValue) {
                sBuilder.append(currG.signature);
                num -= currG.minVal;
                currG = RomanGroup.I;
                continue;
            }

            currG = currG.next;

        } while (num > 0 && currG != null);

        return sBuilder.toString();
    }
}
