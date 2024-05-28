package Questions.BST;

public class Inorder_Successor_in_BST {
    public static void main(String[] args) {
//https://www.geeksforgeeks.org/problems/inorder-successor-in-bst/1?itm_source=geeksforgeeks&itm_medium=article&itm_campaign=bottom_sticky_on_article
    }

    class Node{
        int data;
        Node left,right;
        Node(int d){
            data=d;
            left=right=null;
        }
    }

    public Node inorderSuccessor(Node root,Node x){
        Node temp = null;

        while (root != null) {
            if(root.data > x.data) {
                //jump left
                //and store this as this might be
                temp = root;
                root = root.left;
            } else if (root.data < x.data) {
                //move right
                root = root.right;
            } else {
                //if these both are not the case, then you found the node with the
                //the given value x
                break;
            }
        }

        //will only break when it find the node with the value x
        //as its given that such node exists

        //now check, if the right of the given root is null
        if(root.right == null) {
            //return the temp node
            return temp;
        }

        //otherwise we need to find the leftmost node of that node's right subtree
        //hence jump right and start moving left
        Node rootRight = root.right;

        while (rootRight.left != null) {
            rootRight = rootRight.left;
        }

        return rootRight;
    }
}
