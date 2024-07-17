package Questions;

public class Shortest_Path_from_Node_to_Another_Node_in_BST {

    public class TreeNode { int val;
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
    public static void main(String[] args) {
        //https://leetcode.com/problems/step-by-step-directions-from-a-binary-tree-node-to-another/description/?envType=daily-question&envId=2024-07-16
        //LCA Solution Due
    }

    public String getDirections(TreeNode root, int startValue, int destValue) {
        //convert this to a graph
        //and then apply BFS

        StringBuilder rootToSrc = new StringBuilder();
        StringBuilder rootToDST = new StringBuilder();

        findPath(root, startValue, rootToSrc);
        findPath(root, destValue, rootToDST);

        int l = 0;
        while(l < rootToSrc.length() && l < rootToDST.length() && rootToSrc.charAt(l) == rootToDST.charAt(l)) {
            l++;
        }

        StringBuilder res = new StringBuilder();
        //ADD U
        for (int i = 0; i < rootToSrc.length(); i++) {
            res.append('U');
        }

        for (int i = 0; i < rootToDST.length(); i++) {
            res.append(rootToDST.charAt(i));
        }

        return res.toString();
    }

    private boolean findPath(TreeNode root, int target, StringBuilder path) {
        if(root == null) {
            return false;
        }

        if(root.val == target) {
            return true;
        }

        path.append('L');
        if(findPath(root.left, target, path)) {
            return true;
        }

        path.deleteCharAt(path.length() - 1);

        path.append('R');
        if(findPath(root.right, target, path)) {
            return true;
        }
        path.deleteCharAt(path.length() - 1);


        return false;
    }
}
