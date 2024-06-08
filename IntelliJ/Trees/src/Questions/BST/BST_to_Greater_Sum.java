package Questions.BST;

import java.util.ArrayList;

public class BST_to_Greater_Sum {
    public static void main(String[] args) {
        //https://leetcode.com/problems/convert-bst-to-greater-tree/
        //https://leetcode.com/problems/binary-search-tree-to-greater-sum-tree/description/
    }
    static class TreeNode {
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
    }

    int greater = 0;
    public TreeNode convertBSTOptimized(TreeNode root) {
        //Beats : 100%, *************
        //do reverse inorder traversal, that way we'll get numbers in decreasing
        //order and we can also use a greater var to keep the track of sum
        //till last greatest node
        TreeNode head = root;
        reverseInorder(root);

        return head;
    }

    private void reverseInorder(TreeNode root) {
        if(root == null) {
            return;
        }
        reverseInorder(root.right);

        //here our inorder stuff begins
        greater = greater + root.val;
        //initially for the first node greater = 0, so it just amounts to the
        //value of the root.val
        root.val = greater;

        reverseInorder(root.left);
    }

    ArrayList<Integer> ans = new ArrayList<>();
    int i = 0;
    public TreeNode convertBST(TreeNode root) {
        //BEATS : 20% ******************
        if(root == null) {
            return null;
        }
        //idea 1 : create a postfixSum array and put it in the node's value
        //calculate the inorder traversal
        TreeNode head = root;
        TreeNode head1 = root;
        inorderCalculator(root); //O(H)
        //form the postfixSum Array
        int[] postfixSum = new int[ans.size()];
        postfixSum[ans.size() - 1] = ans.get(ans.size() - 1);

        for (int i = ans.size() - 2; i >= 0; i--) {
            postfixSum[i] = postfixSum[i + 1] + ans.get(i); //O(N)
        }

        //now we have postfix sum, now do inorder traversal again, but this
        //time we'll update the values as we go
        root = head1;
        inorderChanger(root, postfixSum);//O(H)
        return head;
    }

    private void inorderChanger(TreeNode root, int[] postfixSum) {
        if(root.left != null) {
            inorderChanger(root.left, postfixSum);
        }

        root.val = postfixSum[i++];

        if(root.right != null) {
            inorderChanger(root.right, postfixSum);
        }
    }

    private void inorderCalculator(TreeNode root) {
        //LNR
        if(root.left != null) {
            inorderCalculator(root.left);
        }
        ans.add(root.val);
        if(root.right != null) {
            inorderCalculator(root.right);
        }

    }
}
