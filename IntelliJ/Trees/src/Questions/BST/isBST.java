package Questions.BST;

public class isBST {
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

    public boolean isValidBST(TreeNode root) {
        long min = Integer.MIN_VALUE;
        long max = Integer.MAX_VALUE;

        return BSTChecker(min,  root, max);
    }

    private boolean BSTChecker(long min, TreeNode root, long max) {
        if(root == null) {
            return true;
        }
        //check if the current node is valid
        if(root.val < min || root.val > max) {
            return false;
            //hence using this first we confirmed that root is in range

        }

        //now check the siblings if they exist
        boolean left = BSTChecker(min,root.left, (long)root.val - 1);
        boolean right = BSTChecker((long)root.val + 1, root.right, max);
        //as root.val is int, so int + 1 will give int which will then
        //be given to function call
        return left && right;
        //this is analogous to :
        // if(l==false || r == false){
        //            return false;
        //        }
        //        return true;

    }
}
