package LL_Questions.Conversion;

public class Binary_Tree_to_CDLL {
    public static void main(String[] args) {

    }

    class Node{
        int data;
        Node left,right;
        Node(int d){
            data=d;
            left=right=null;
        }
    }

    Node bTreeToClist(Node root) {
        if(root == null) {
            return root;
        }
        Node lHead = bTreeToClist(root.left);
        Node rHead = bTreeToClist((root.right));

        if(lHead == null && rHead == null) {
            //then just form the CDLL and return it
            root.left = root;
            root.right = root;

            return root;
        } else if(lHead == null && rHead != null) {
            //so just make the root CDLL and concatenate w/ the rest of the rightward
            //part that is already a CDLL
            root.left = root;
            root.right = root;

            concatenateCDLL(root, rHead);
            return root;
        } else if(lHead != null && rHead == null) {
            //make the root a CDLL
            root.left = root;
            root.right = root;

            //now concatenate it with the left part
            concatenateCDLL(lHead, root);
            return lHead;
        } else {
            //now both left and right are not Null
            root.left = root;
            root.right = root;

            concatenateCDLL(lHead, root);
            //now its result will give a merged CDLL whose head is lHead
            concatenateCDLL(lHead, rHead);
            //so now concatenate the lHead (the left part) with the right part

            return lHead;
        }
    }

    private void concatenateCDLL(Node head1, Node head2) {
        //given 2 CDLL, concatenate them
        Node tail1 = head1.left;
        Node tail2 = head2.left;

        tail1.right = head2;
        head2.left = tail1;
        tail2.right = head1;
        head1.left = tail2;
    }
}
