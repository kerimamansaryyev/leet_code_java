package merge_k_sorted_lists;



class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }

public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().mergeKLists(
                new ListNode[]{
                        new ListNode(1, new ListNode(4, new ListNode(5))),
                        new ListNode(1, new ListNode(3, new ListNode(4))),
                        new ListNode(2, new ListNode(6)),
                }
        ));
    }
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode last = new ListNode();

        ListNode head = last;

        do {

            int minVal = 10000;
            int minNodeIndex = -1;

            for(int i=0;i<lists.length;i++){
                if(lists[i] != null && lists[i].val < minVal) {
                    minVal = lists[i].val;
                    minNodeIndex = i;
                }
            }

            if(minNodeIndex == -1){
                break;
            }

            lists[minNodeIndex] = lists[minNodeIndex].next;

            last.next = new ListNode(minVal);
            System.out.println(last.next.val);
            last = last.next;


        } while (true);

        return  head.next;

    }
}
