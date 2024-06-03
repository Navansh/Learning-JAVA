package Questions;

public class Invert_a_BT {
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

    public TreeNode invertTree(TreeNode root) {
        TreeNode head1 = root;
        if(root == null) {
            return head1;
        }
        TreeNode left = root.left;
        root.left = invertTree(root.right);
        root.right = invertTree(root.left);

        return head1;
    }


}
