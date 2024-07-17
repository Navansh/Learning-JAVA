package Questions.Views_Problem;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Right_View {
    public static void main(String[] args) {

    }
    class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    ArrayList<Integer> rightView(Node root) {
        //**********MAY NEED TO CREATE A NULL POINTER CHECK FOR ROOT********
        //HERE MIN LENGTH GIVEN IN PROBLEM IS 1, so not doing it here

        ArrayList<Integer> arrList = new ArrayList<>();

        if(root == null) {
            return arrList;
        }

        Queue<Node> qx = new LinkedList<>();
        qx.add(root);

        while (qx.size() > 0) {
            //this while loop condition resets the level
            int n = qx.size();
            for (int i = 0; i < n; i++) {
                //take out the element from the queue
                Node temp = qx.remove();

                //we need to print the first node of each level
                //and first node of each level is at i == 0, so print only in that case
                if(i == n - 1) {
                    arrList.add(temp.data);
                }

                if(temp.left != null) {
                    qx.add(temp.left);
                }

                if(temp.right != null) {
                    qx.add(temp.right);
                }
            }
        }

        return arrList;
    }
}
