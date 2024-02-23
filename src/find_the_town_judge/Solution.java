package find_the_town_judge;

import java.util.HashMap;

public class Solution {
    public int findJudge(int n, int[][] trust) {

        if(n==1){
            return 1;
        }

        final class Person{
            public final int number;
            int whomTrustsCount;
            int byWhomTrustedCount;


            Person(int number) {
                this.number = number;
            }
        }

        final var people= new Person[n];

        for(final var trustRelations:trust){
            final var whoTrustsIndex = trustRelations[0];
            final var toWhomTrustsIndex = trustRelations[1];
            if(people[whoTrustsIndex-1] == null){
                people[whoTrustsIndex-1] = new Person(whoTrustsIndex);
            }
            if(people[toWhomTrustsIndex-1] == null){
                people[toWhomTrustsIndex-1] = new Person(toWhomTrustsIndex);
            }
            final var whoTrusts = people[whoTrustsIndex-1];
            final var toWhomTrusts = people[toWhomTrustsIndex-1];
            whoTrusts.whomTrustsCount++;
            toWhomTrusts.byWhomTrustedCount++;
        }

        for(final var person:people){
            if(person != null && person.whomTrustsCount == 0 && person.byWhomTrustedCount == n-1){
                return  person.number;
            }
        }

        return -1;
    }
}
