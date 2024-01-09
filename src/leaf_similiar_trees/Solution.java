package leaf_similiar_trees;


import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.function.Consumer;
import java.util.function.Supplier;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
     TreeNode(int val) { this.val = val; }
     TreeNode(int val, TreeNode left, TreeNode right) {
         this.val = val;
         this.left = left;
         this.right = right;
    }

    @Override
    public String toString() {
        return String.valueOf(val);
    }
}


public class Solution {

    public static void main(String[] args) {
        final var root1 = new TreeNode(
                1,
                new TreeNode(2),
                new TreeNode(3)
        );
        System.out.println(new Solution().leafSimilar(root1, root1));
    }

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {

        final Queue<TreeNode> uniqueQueue = new LinkedList<>(){
            private int length = 0;

            @Override
            public boolean isEmpty() {
                return  length == 0;
            }

            @Override
            public TreeNode poll() {
                length--;
                return super.poll();
            }

            @Override
            public boolean add(TreeNode treeNode) {
                if(isEmpty() || getLast() != treeNode){
                    length++;
                    return super.add(treeNode);
                }
                return false;
            }
        };


        final class LeafVerifier {
            boolean result = true;

            boolean verify(){
                findLeafTraversal(root2, (leaf) -> {

                    if(uniqueQueue.isEmpty()){
                        result = false;
                        return;
                    }

                    result = uniqueQueue.poll().val == leaf.val;

                }, () -> result);
                return  result;
            }
        }

        findLeafTraversal(root1, uniqueQueue::add, () -> true);
        final var answer = new LeafVerifier().verify();

        return uniqueQueue.isEmpty() && answer;
    }

    public void findLeafTraversal(TreeNode node, Consumer<TreeNode> onLeafFound, Supplier<Boolean> shouldContinue){
        if(!shouldContinue.get()){
            return;
        }
        if(node == null){
            return;
        }
        if(node.right == null && node.left == null){
            onLeafFound.accept(node);
            return;
        }
        findLeafTraversal(node.left, onLeafFound, shouldContinue);
        findLeafTraversal(node.right, onLeafFound, shouldContinue);
    }
}
