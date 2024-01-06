package int_to_roman;

import java.util.Stack;

public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().intToRoman(6));
    }
    public String intToRoman(int num) {


        enum RomanGroup{

            M(1000, 'M',1000),
            CM(900, 'M',1000),

            D(400, 'D',500),

            C(90, 'C',100),

            L(40, 'L',50),

            X(9, 'X',10),

            V(4, 'V',5),

            I(1, 'I',1);

            final int seed;
            final int minValue;
            final Character primalCharacter;

            RomanGroup(int minValue, Character primalCharacter, int seed){
                this.minValue = minValue;
                this.primalCharacter = primalCharacter;
                this.seed = seed;
            }
        }


        StringBuilder resultSb = new StringBuilder();

        for(int i = 0, numTransformed = num;numTransformed > 0; i++){
            final int power = (int) Math.pow(10, i);
            numTransformed /= power;
            final int temp =  num/power;
            int frac = (temp % 10) * power;
            Stack<Character> stack = new Stack<>();
            Character buffer = null;

            for(final var group: RomanGroup.values()){
                if(frac >= group.minValue){
                    frac = frac - group.seed;

                    if(frac == 0){
                        stack.push(group.primalCharacter);
                        if(buffer != null){
                            stack.push(buffer);
                        }
                        break;
                    }

                    final int fracAbs = Math.abs(frac);

                    if(fracAbs < group.minValue){
                        if(frac > 0){
                            stack.push(group.primalCharacter);
                            if(buffer != null){
                                stack.push(buffer);
                                buffer = null;
                            }
                        }
                        else {
                            frac = -frac;
                            buffer = group.primalCharacter;
                        }
                        continue;
                    }

                    stack.push(group.primalCharacter);

                    while(frac >= group.seed){
                        stack.push(group.primalCharacter);
                        frac = frac - group.seed;
                    }

                    if(buffer != null){
                        stack.push(buffer);
                    }

                    break;
                }
            }

            while (!stack.isEmpty()){
                resultSb.insert(0,stack.pop());
            }
        }

        return resultSb.toString();
    }
}