package Questions.BST;

import Questions.Construction_of_Tree.Tree_using_Inorder_and_Postorder;

public class Search_in_BST {
    public static void main(String[] args) {

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

    public TreeNode searchBSTIterative(TreeNode root, int val) {
        while (root != null) {
            if(root.val == val) {
                return root;
            } else if(root.val > val) {
                //go left
                root = root.left;
            } else {
                root = root.right;
            }
        }

        return null;
    }

    public TreeNode searchBST(TreeNode root, int val) {
        //similar to Binary Search
        if(root.val == val) {
            return root;
        }

        if(root.right != null) {
            if(val > root.val) {
                //search rightside
                return searchBST(root.right, val);
            }
        }

        if(root.left != null) {
            if(val < root.val) {
                //search rightside
                return searchBST(root.left, val);
            }
        }

        return null;

    }
}
