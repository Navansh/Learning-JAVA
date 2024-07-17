import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderTraversal {
    //two types of Level Order Traversal

    public static void main(String[] args) {

    }

    public void levelOrderWithSeperatePrint(Node root) {
        Queue<Node> queuer = new LinkedList<>();
        queuer.add(root);

        while(queuer.size() > 0) {
            int n = queuer.size();
            //this size tells the number of nodes present at current level on which
            //you are present

            while( n > 0) {
                //this loop is just for segregating b/w diff level
                //we can remove this also if we don't want this functionality

                Node temp = queuer.remove();
                System.out.print(temp.val + " ");

                if(temp.left != null) {
                    queuer.add(temp.left);
                }

                if(temp.right != null) {
                    queuer.add(temp.right);
                }
                n--;
            }
            System.out.println(" ");
        }

        //this another while loop won't increase the TC as it is not increasing the number of
        // iterations happening, those are still the number of nodes times,
        // its just for printing a new line
        // hence, TC Still is : O(N) and SC : O(N)

    }
}

class Node {
    int val;
    Node left;
    Node right;

    Node (int n) {
        val = n;
    }
}

