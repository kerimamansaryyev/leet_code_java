package remove_duplicates_from_sorted_list;

public class Solution {

    public static void main(String[] args) {
        var list = new ListNode(1, new ListNode(2, new ListNode(2, new ListNode(4, null))));

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
        if (head == null || head.next == null) {
            return head;
        }
        final ListNode newHead = new ListNode(-200);
        ListNode newHeadCursor = newHead;

        while (head != null){
            if(head.val != newHeadCursor.val){
                newHeadCursor.next = new ListNode(head.val);
                newHeadCursor = newHeadCursor.next;
            }
            head = head.next;
        }

        return newHead.next;
    }
}
