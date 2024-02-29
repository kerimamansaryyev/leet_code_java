package k_pairs_with_smallest_sums;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().kSmallestPairs(new int[]{1, 7, 11}, new int[]{2, 4, 6}, 3));
    }

    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        if (k == 0 || (nums1.length == 0 && nums2.length == 0)) {
            return List.of();
        }

        record SumEntity(int i, int j, int sum){
        }

        final var pQ = new PriorityQueue<SumEntity>(Comparator.comparingInt(SumEntity::sum));
        final var visitedHashSet = new HashSet<SumEntity>();
        final Consumer<SumEntity> visitDelegate = (s) -> {
            pQ.offer(s);
            visitedHashSet.add(s);
        };
        final var result = new LinkedList<List<Integer>>();

        visitDelegate.accept(new SumEntity(0, 0, nums1[0] + nums2[0]));

        while (!pQ.isEmpty() && k-- > 0) {
            final var min = pQ.remove();
            result.add(Arrays.asList(nums1[min.i], nums2[min.j]));

            SumEntity num1SumEntityNext;
            SumEntity num2SumEntityNext;

            if (min.i < nums1.length -1 && !visitedHashSet.contains(num1SumEntityNext = new SumEntity(min.i+1, min.j, nums1[min.i+1] + nums2[min.j]))) {
                visitDelegate.accept(num1SumEntityNext);
            }
            if (min.j < nums2.length -1 && !visitedHashSet.contains(num2SumEntityNext = new SumEntity(min.i, min.j+1, nums1[min.i] + nums2[min.j + 1]))) {
                visitDelegate.accept(num2SumEntityNext);
            }
        }

        return result;
    }
}
