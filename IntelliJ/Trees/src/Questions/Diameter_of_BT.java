package Questions;

public class Diameter_of_BT {
    public static void main(String[] args) {
        //https://www.geeksforgeeks.org/problems/diameter-of-binary-tree/1?itm_source=geeksforgeeks
    }

    class Node {
        int data;
        Node left;
        Node right;
        Node(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }
    int maxHeight = Integer.MIN_VALUE;


    int diameter(Node root) {
        heightCalculator(root);
        return maxHeight;
        //if in terms of nodes, then add 1, hence maxHeight + 1
    }

    private int heightCalculator(Node root) {
        if(root == null) {
            return -1;
        }

        int lHeight = heightCalculator(root.left);
        int rHeight = heightCalculator(root.right);

        maxHeight = Math.max(maxHeight, lHeight + rHeight + 2);
        //this : lHeight + rHeight + 2, is the max length of path going
        //via this node
        return Math.max(lHeight, rHeight) + 1;
        //but we'll return height for each node, which is lHeight + rHeight + 1

    }

}
