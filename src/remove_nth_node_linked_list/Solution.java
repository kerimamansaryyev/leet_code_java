package remove_nth_node_linked_list;


import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }


public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().removeNthFromEnd(
                new ListNode(1, new ListNode(2)),
                2
        ));
    }
    public ListNode removeNthFromEnd(ListNode head, int n) {
        final Stack<ListNode> s = new Stack<>();
        ListNode curr = head;

        while(curr != null){
            s.push(curr);
            curr = curr.next;
        }

        for (int i = 1;i <= n; i++) {
            final var last = s.pop();
            if(i != n){
                continue;
            }
            if(s.size() < 1 && head != null){
                head = head.next;
            }
            else{
                final var prev = s.pop();
                prev.next = last.next;
            }

            return head;
        }

        return  head;
    }
}
