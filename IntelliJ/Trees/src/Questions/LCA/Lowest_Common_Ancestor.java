package Questions.LCA;

public class Lowest_Common_Ancestor {
    public static void main(String[] args) {

    }

    class Node
    {
        int data;
        Node left, right;

        Node(int item)
        {
            data = item;
            left = right = null;
        }
    }

    Node lca(Node root, int n1,int n2) {
        if(root == null) {
            return null;
        }

        if(root.data == n1 || root.data == n2) {
            return root;
        }
        Node l = lca(root.left, n1, n2);
        Node r = lca(root.right, n1, n2);

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
