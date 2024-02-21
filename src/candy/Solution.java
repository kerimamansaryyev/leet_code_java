package candy;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().candy(new int[]{1,2,87,87,87,2,1}));
    }

    public int candy(int[] ratings) {
        final int[] candies = new int[ratings.length];
        Arrays.fill(candies, 0, candies.length, 1);

        for (int i = 0; i < ratings.length - 1; i++) {
            int rightNbh = i + 1;
            if(ratings[i] >= ratings[rightNbh]){
                candies[i] = candies[i] + candies[rightNbh];
                candies[rightNbh] = Math.max(1, candies[rightNbh] - 1);
            }
            else{
                candies[rightNbh] = candies[i] + candies[rightNbh];
                candies[i] = Math.max(1, candies[i] - 1);
            }
        }

        System.out.println(Arrays.toString(candies));

        return  Arrays.stream(candies).reduce(0, Integer::sum);
    }
}
