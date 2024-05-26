package Questions.Views_Problem;

import java.util.LinkedList;
import java.util.Queue;

public class Left_View {
    public static void main(String[] args) {

    }

    class Node {
        int val;
        Node left;
        Node right;

        Node (int n) {
            val = n;
        }
    }

    public void leftView(Node root) {
        //**********MAY NEED TO CREATE A NULL POINTER CHECK FOR ROOT********
        //HERE MIN LENGTH GIVEN IN PROBLEM IS 1, so not doing it here

        //do the level order and print the first node of each level
        Queue<Node> qx = new LinkedList<>();
        if(root == null) {
            return ;
        }
        qx.add(root);

        while (qx.size() > 0) {
            //this while loop condition resets the level
            int n = qx.size();
            for (int i = 0; i < n; i++) {
                //take out the element from the queue
                Node temp = qx.remove();

                //we need to print the first node of each level
                //and first node of each level is at i == 0, so print only in that case
                if(i == 0) {
                    System.out.println(temp.val);
                }

                if(temp.left != null) {
                    qx.add(temp.left);
                }

                if(temp.right != null) {
                    qx.add(temp.right);
                }
            }
        }
    }
}
