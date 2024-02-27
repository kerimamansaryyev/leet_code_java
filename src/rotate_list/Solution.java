package rotate_list;

public class Solution {
    public static void main(String[] args) {
        var list = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, null))));

        list = new Solution().rotateRight(list, 4);

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

    public ListNode rotateRight(ListNode head, int k) {
        ListNode ptr = head;
        int length = 0;

        while (ptr != null) {
            ptr = ptr.next;
            length++;
        }

        if (length < 2) {
            return head;
        }

        k = k % length;

        if(k == 0){
            return head;
        }

        int count = length - k;
        ListNode last = head;

        while (count>1){
            last = last.next;
            count--;
        }

        final var futureHead = last.next;
        last.next = null;
        last = futureHead;

        while (last.next != null){
            last = last.next;
        }

        last.next = head;
        head = futureHead;


        return head;
    }
}
