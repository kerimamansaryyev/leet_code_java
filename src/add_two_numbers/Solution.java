package add_two_numbers;

class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
class Solution {

    public static void main(String[] args) {
        final var sample = new ListNode();
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode();
        ListNode head = result;
        boolean isBuffered = false;

        while (l1 != null || l2 != null){
            final var operand1 = l1 == null? 0: l1.val;
            final var operand2 = l2 == null? 0: l2.val;
            final byte bufferedValue = (byte) (isBuffered? 1:0);

            final var sum = operand1 + operand2 + bufferedValue;

            isBuffered = sum>=10;

            result.next = new ListNode(sum%10);

            result = result.next;

            l1 = l1 == null? null: l1.next;
            l2 = l2 == null? null: l2.next;
        }

        if(isBuffered){
            result.next = new ListNode(1);
        }

        return  head.next;
    }
}
