package Questions.BST;

public class Delete_Node_in_BST {
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

    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null) {
            return null;
        }
        //firstly find out that node and classify it one of the four types

        //search for the node
        if(root.val > key) {
            root.left = deleteNode(root.left,key);
            //hence whatever is being returned will become the left child
            //this will help us set the parent node, because when we have traversed
            //to the node which we want to delete,
            //we don't have direct connection to the parent to change its connection
            //so we do with the help of recursion, which remembers its parent node
            //hence we change in a x function call
            //and then that change gets put in x - 1 function call using the stack space
            //into the parent connection
        } else if(root.val < key) {
            root.right = deleteNode(root.right, key);
        } else {
            //you found the node
            //now categorize it
            if(root.left == null && root.right == null) {
                //hence leaf node
                //so just remove it and
                return null;
            } else if(root.left == null) {
                //meaning root.right is present
                //so bypass the root and make the connection
                return root.right;
            } else if (root.right == null) {
                //meaning root.left is present
                //so bypass the root and make the connection
                return root.left;
            } else {
                //in this both left and right child of the root are not null

                //hence we either replace this node by the max of left subtree
                //or the min of right subtree
                //let's say we do here with the max of left subtree
                int max = findMax(root.left);

                //now this value will be our root node
                root.val = max;
                //and then delete the max node which was in the left subtree
                root.left = deleteNode(root.left, max);
                //as we've taken the max from the left subtree, so we need to
                //update the connections accordingly
                //not passing root directly as then it will have conflict
                //with the root itself
                return root;
            }
        }

        return root;
        //had to return root to make the connection with the parent node w/ the upper node
        //as once our req action is done, we need to return that root node
        //from all our function calls
    }

    private int findMax(TreeNode left) {
        //just go to right, until it becomes null
        while (left.right!=null) {
            left = left.right;
        }

        //if its null, then we found the rightmost node
        return left.val;
    }
}
