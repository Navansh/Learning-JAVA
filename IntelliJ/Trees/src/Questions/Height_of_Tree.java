package Questions;

public class Height_of_Tree {
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

    static int height(Node node) {
        //this calculation is in terms of edges and not Nodes
        //*******************************************************
        int h = heightCalculator(node);
        if(h == -1) {
            return 0;
        }

        return h;
    }

    private static int heightCalculator(Node node) {
        if(node == null) {
            return -1;
            //cz we're calculating height in terms of edge, if it were in terms of
            //node then we could've returned 0
        }
        int lHeight = heightCalculator(node.left);
        int rHeight = heightCalculator(node.right);

        return Math.max(lHeight, rHeight) + 1;
    }


}
