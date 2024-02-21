package group_anagrams;

import java.util.*;
import java.util.stream.Collectors;

public class Solution {

    public int[] topKFrequentApproach2(int[] nums, int k) {
        class Element {
            final int number;
            int frequency;

            Element(int number) {
                this.number = number;
                frequency = 0;
            }
        }

        final HashMap<Integer, Element> hashMap = new HashMap<>();

        for (final var num : nums) {
            hashMap.computeIfAbsent(num, Element::new);
            hashMap.get(num).frequency++;
        }

        final var values = hashMap.values().stream().sorted((a, b) -> b.frequency - a.frequency).toList();
        int[] result = new int[k];

        for (int i = 0; i < k; i++) {
            result[i] = values.get(i).number;
        }

        return result;

    }

    public int[] topKFrequentApproach1(int[] nums, int k) {
        class Element {
            final int number;
            int frequency;

            Element(int number) {
                this.number = number;
                frequency = 0;
            }
        }

        final HashMap<Integer, Element> hashMap = new HashMap<>();
        final PriorityQueue<Element> q = new PriorityQueue<>((a, b) -> b.frequency - a.frequency);

        for (final var num : nums) {
            hashMap.computeIfAbsent(num, Element::new);
            hashMap.get(num).frequency++;
        }

        q.addAll(hashMap.values());

        final int[] result = new int[k];

        for (int i = 0; i < k; i++) {
            if (!q.isEmpty()) {
                result[i] = q.poll().number;
            }
        }

        return result;
    }
}
