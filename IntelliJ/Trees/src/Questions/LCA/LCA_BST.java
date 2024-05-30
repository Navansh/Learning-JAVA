package Questions.LCA;

public class LCA_BST {
    public static void main(String[] args) {

    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public TreeNode lowestCommonAncestorOptimized(TreeNode root, TreeNode p, TreeNode q) {
        while (root != null) {
            if(p.val < root.val && q.val < root.val) {
                root = root.left;
            } else if(p.val > root.val && q.val > root.val) {
                root = root.right;
            } else {
                //whenever they will diverge that node is our answer
                //aka the LCA
                return root;
            }
        }

        return null;
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //the same code as for BT, hence no optimization done for BST
        if(root == null) {
            return null;
        }

        if(root.val == p.val || root.val == q.val) {
            return root;
        }
        TreeNode l = lowestCommonAncestor(root.left, p, q);
        TreeNode r = lowestCommonAncestor(root.right, p, q);

        if(l!= null && r!= null) {
            //we found the LCA
            return root;
        }

        if(l != null) {
            //this by default means r == null
            //as both non null case is covered above
            return l;
        }

        if(r != null) {
            //this by default means l == null
            //as both non null case is covered above
            return r;
        }

        //and if both null
        return null;
    }
}
