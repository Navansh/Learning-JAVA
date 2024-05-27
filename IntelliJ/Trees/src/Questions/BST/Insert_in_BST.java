package Questions.BST;

import com.sun.source.tree.Tree;

public class Insert_in_BST {
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

    public TreeNode insertIntoBSTAnother(TreeNode root, int val) {
        //just a slight changes as in another way to write the while loop ******
        //*****************************************
        TreeNode n = new TreeNode(val);
        if(root == null) {
            return n;
        }
        TreeNode head = root;

        while (root != null) {
            if(root.val > val) {
                //then move left
                if(root.left == null) {
                    //then attatch here only
                    root.left = n;
                    return head;
                } else {
                    root = root.left;
                }
            } else {
                if(root.right == null) {
                    root.right = n;
                    return head;
                } else {
                    root = root.right;
                }
            }

            //its given in the PS that you won't a get number which is already present
            //hence only 2 possible cases

        }
        //hence the only way to exit the while loop is from the internal return statement
        //which is after adding node to the BST
        return null;
    }

    public TreeNode insertIntoBST(TreeNode root, int val) {
        TreeNode n = new TreeNode(val);
        if(root == null) {
            return n;
        }
        TreeNode head = root;

        while (true) {
            if(root.val > val) {
                //then move left
                if(root.left == null) {
                    //then attatch here only
                    root.left = n;
                    return head;
                } else {
                    root = root.left;
                }
            } else {
                if(root.right == null) {
                    root.right = n;
                    return head;
                } else {
                    root = root.right;
                }
            }

            //its given in the PS that you won't a get number which is already present
            //hence only 2 possible cases

        }
        //hence the only way to exit the while loop is from the internal return statement
        //which is after adding node to the BST

    }
}
