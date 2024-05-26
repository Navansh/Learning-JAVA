package LL_Questions.Conversion;

public class Flatten_Binary_Tree_To_LL {
    public static void main(String[] args) {

    }

    public class TreeNode {
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

    public static void flatten(TreeNode root) {
        flattenTree(root);
    }

    public static TreeNode flattenTree(TreeNode root) {
        TreeNode lTail = flattenTree(root.left);
        TreeNode rTail = flattenTree(root.right);

        if(lTail == null && rTail == null) {
            //if both are null, then our tail for this is root only
            return root;
        } else if(lTail == null && rTail!=null) {
            return rTail;
            //if lTail is null, meaning its flattened, then just simply return the
            //the rightTail
        } else if(lTail != null && rTail == null) {
            TreeNode leftChild = root.left;
            root.right = leftChild;
            root.left = null;
            return lTail;

            //we shift the pointers and make the left point to the right side
            //and finally the tail will be leftTail only as that was shifted to
            //right
        } else {
            //meaning the l and r both are not null
            TreeNode leftChild = root.left;
            TreeNode rightChild = root.right;

            root.right = leftChild;
            root.left = null;
            lTail.right = rightChild;

            return rTail;

            //do all of these operation to shift leftSide to the right part of the node
            //then attatching the previously attached to the end node of the leftSide

            //doing this as this represents the preOrder tareeka
            //hence flattening it
        }
    }
}
