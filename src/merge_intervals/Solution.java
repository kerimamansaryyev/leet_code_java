package merge_intervals;

import java.util.*;

public class Solution {

    public static void main(String[] args) {
        new Solution().merge(
                new int[][]{
//                        {1, 3}, {2, 6}, {8, 10}, {15, 18},
                        {1, 4}, {5, 6}
                }
        );
    }

    public int[][] merge(int[][] intervals) {
        final HashMap<Integer, Integer> coords = new HashMap<>();
        final var removeList = new LinkedList<Integer>();
        final var priorityQueue = new PriorityQueue<Integer>();

        for (final var interval : intervals) {
            final var prev = coords.get(interval[0]);
            coords.put(interval[0], Math.max(prev == null ? -1 : prev, interval[1]));
        }
        for (final var key : coords.keySet()) {
            Integer value = coords.get(key);
            while (coords.get(value) != null) {
                removeList.add(value);
                value = coords.get(value);
            }
            coords.put(key, value);
        }
        for (final var element : removeList) {
            coords.remove(element);
        }


        for (final var key : coords.keySet()) {
            priorityQueue.add(key);
            priorityQueue.add(coords.get(key));
        }

        final var list = new LinkedList<Integer>();
        int listSize = 0;
        int prev = -1;

        while (!priorityQueue.isEmpty()) {
            final var element = priorityQueue.poll();

            if (listSize == 0) {
                list.add(element);
                listSize++;
            } else if (element - list.getLast() == 1 && listSize % 2 == 0) {
                list.removeLast();
                list.add(element);
                prev = element;
                listSize++;
                continue;
            } else if (element - prev != 1) {
                list.add(element);
                listSize++;
            }

            prev = element;
        }


        final int[][] result = new int[listSize / 2][2];
        int pairCount = 0;
        int peerCount = -1;

        for (final var element : list) {
            result[pairCount][++peerCount % 2] = element;
            if (peerCount % 2 == 1) {
                pairCount++;
            }
        }

        return result;
    }
}
