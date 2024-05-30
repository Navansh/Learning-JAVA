package Questions;

import java.util.ArrayList;

public class Root_to_Node_Path {
    public static void main(String[] args) {
        //https://www.geeksforgeeks.org/print-path-root-given-node-binary-tree/
    }

    class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode() {}

        public TreeNode(int _val) {
            val = _val;
        }

        public TreeNode(int _val, TreeNode _left, TreeNode _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    };

    public ArrayList<Integer> solve(TreeNode A, int b) {
        //find the path from root node to the node b
        ArrayList<Integer> ans = new ArrayList<>();
        //this will store all our ans for function calls
        if(A == null) {
            return ans;
        }
        getPath(A,b, ans);
        return ans;
    }

    private boolean getPath(TreeNode root, int b, ArrayList<Integer> ans) {
        if(root == null) {
            return false;
        }

        ans.add(root.val);
        if(root.val == b) {
            return true;
        }

        if(getPath(root.left, b, ans) || getPath(root.right, b,ans) ) {
            return true;
        }

        ans.remove(root.val);
        return false;
    }


}
