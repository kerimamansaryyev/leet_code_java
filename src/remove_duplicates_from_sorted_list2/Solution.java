package remove_duplicates_from_sorted_list2;

import java.util.LinkedList;

public class Solution {
    public static void main(String[] args) {
        var list = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, null))));

        list = new Solution().deleteDuplicates(list);

        do {
            System.out.print(list.val);
            if (list.next != null) {
                System.out.print(" -> ");
            }
            list = list.next;
        } while (list != null);
    }

    static final class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }


    }
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }

        final var uniqueListStack = new LinkedList<Integer>();
        uniqueListStack.add(head.val);
        int stackLength = 1;
        var cursor = head.next;
        Integer lastRemoved = null;

        while (cursor != null){
            if(lastRemoved != null && lastRemoved.equals(cursor.val)){
                cursor = cursor.next;
                continue;
            }
            if(!uniqueListStack.isEmpty() && uniqueListStack.getLast().equals(cursor.val)){
                lastRemoved = uniqueListStack.removeLast();
                stackLength--;
            }
            else {
                uniqueListStack.add(cursor.val);
                stackLength++;
            }
            cursor = cursor.next;
        }

        if(stackLength <= 0){
            return null;
        }

        head = new ListNode(uniqueListStack.removeFirst());
        cursor = head;
        stackLength--;

        while (stackLength > 0){
            cursor.next = new ListNode(uniqueListStack.removeFirst());
            cursor = cursor.next;
            stackLength--;
        }

        return head;
    }
}
