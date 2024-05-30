package Questions;

public class Longest_path_across_root {
    public static void main(String[] args) {

    }

    class Node
    {
        int data;
        Node left, right;

        Node(int item) {
            data = item;
            left = right = null;
        }
    }

    int height(Node node) {
        //this calculation is in terms of edges and not Nodes
        //*******************************************************
        int h = heightCalculator(node);
        //here we won't put the condition for returning 0, even if the height
        //calculated == -1, for a null node, as that will be adjusted in our
        //main function
        return h;
    }

    private int heightCalculator(Node node) {
        if(node == null) {
            return -1;
            //cz we're calculating height in terms of edge, if it were in terms of
            //node then we could've returned 0
        }
        int lHeight = heightCalculator(node.left);
        int rHeight = heightCalculator(node.right);


        return Math.max(lHeight, rHeight) + 1;
    }

    int maxPathAcrossRoot(Node root) {
        int lHeight = height(root.left);
        int rHeight = height(root.right);

        return lHeight + rHeight + 2;
    }
}
