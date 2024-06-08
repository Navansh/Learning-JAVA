package Questions.Morris_Traversal;

import java.util.ArrayList;
import java.util.List;

public class Postorder_Traversal {
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

    public List<Integer> postorderTraversal(TreeNode root) {

        List<Integer> ans = new ArrayList<>();
        postorderTraversalHelper(root, ans);
        //now reverse this array using 2 pointer approach
        int left = 0;
        int right = ans.size() - 1;
        while (left < right) {
            int temp = ans.get(left);
            ans.set(left, ans.get(right));
            ans.set(right, temp);
            left++;
            right--;
        }

        return ans;
    }

    private void postorderTraversalHelper(TreeNode root, List<Integer> ans) {
        TreeNode curr = root;

        while (curr != null) {
            if(curr.right == null) {
                //then essentially we don't need to do much and just print the node
                //itself and move to right
                ans.add(curr.val);
                curr = curr.left;
                //we don't need to come back to this node ever again and we can
                //just move on
            } else {
                //means the left is not null and now we need to make connection
                //as well as remove it
                TreeNode currp1 = curr.right;

                //now find the rightmost node
                while (currp1.left != null && currp1.left != curr) {
                    //meaning this while loop can continue as long as the right node
                    //is not null and is not the parent node that
                    //we started with
                    //this ensures that we are on this rightmost node for the first time
                    //and now we have to make the c
                    currp1 = currp1.left;
                }

                //when we get out of the while loop, there are 2 possible conditions
                if(currp1.left == curr) {
                    //meaning we are visiting this node for the second time
                    //hence no need to print it, as this is been already done
                    //instead break the connection which we made previously
                    currp1.left = null;
                    //hence its now time to print the node ( process the node )
                    // as left part is explored now
                    curr = curr.left;


                } else if(currp1.left == null) {
                    //means we are visiting this node for the first time
                    //so make the connection and move forwards
                    currp1.left = curr;
                    ans.add(curr.val);
                    //we printed the value and then we went to the leftside
                    //NLR
                    curr = curr.right;
                    //and it can move till the leftmost node print it and then
                    //move back again to the parent node, completing the cycle
                    //
                }
            }
        }
    }
}
