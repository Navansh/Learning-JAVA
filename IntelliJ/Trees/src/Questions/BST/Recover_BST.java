package Questions.BST;

public class Recover_BST {
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
    TreeNode first = null;
    TreeNode second = null;
    TreeNode previous = null;
    //don't do TreeNode first = new TreeNode();
    //as then it will give false even for first time for first == null
    //which we want for our if condition
    //similarly for second and previous

    public void recoverTree(TreeNode root) {


        inorderTraversal(root);
        //now swap first and second nodes
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }

    private void inorderTraversal(TreeNode root) {
        //unlike array here we can i, and i + 1, so we need to keep track of
        //current and previous index
        //so the current index is the one that is passed onto the function call
        //and the previous we'll maintain using this

        if(root == null) {
            return;
        }

        //we'll do inorder traversal and the one in which we don't get increasing
        //order value for the nodes, we'll mark them as faulty nodes using
        //first and second

        inorderTraversal(root.left);
        //here you can write about the nodes
        //if we do printing, that is called inorder traversal, but here just want
        //to use the sorted behaviour of inorder traversal, hence we'll do our
        //operation in between these

        if(previous != null && root.val < previous.val && first == null) {
            //this is the problem case and it has occured the first time
            first = previous;
            second = root;
            //giving for both as we don't know if this is the edge case
            //edge case : when the faulty nodes are consecutive
            //then our algo wouldn't be able to find it
        } else if (previous != null && root.val < previous.val && first != null){
            second = root;
            //the current node
            //for the first faulty node we made first = prev
            //and for second faulty second = current
            //hence i and i + 1. very similar to arrays waala question
        }

        //normal case in which root.val > previous.val, then its normal inorder
        //as its sorted, so just continue as :
        previous = root;
        //then the R move for inorder
        inorderTraversal(root.right);

        //after this gets over, it will set our vars first and second
    }
}
