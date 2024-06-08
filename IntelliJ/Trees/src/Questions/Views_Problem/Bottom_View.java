package Questions.Views_Problem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class Bottom_View {
    public static void main(String[] args) {

    }

    class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data = data;
            left=null;
            right=null;
        }
    }

    public static class Pair{
        Node n;
        int verticalLevel;

        public Pair(Node n, int verticalLevel) {
            this.n = n;
            this.verticalLevel = verticalLevel;
        }
    }

    //**********CONFLICT CASE***********
    //here in this problem in case of conflict that is, if a node is
    //on same vertical level and same horizontal level and both the nodes
    //are visible from the bottom view, then we only add the rightmost node
    //hence the default condition for Level Order Traversal
    // but say if they want leftmost node to be added then
    //do the level Order traversal from right to left node
    //****************************************************

    public ArrayList <Integer> bottomView(Node root) {
        //**********MAY NEED TO CREATE A NULL POINTER CHECK FOR ROOT********
        //HERE MIN LENGTH GIVEN IN PROBLEM IS 1, so not doing it here

        Queue<Pair> qx = new LinkedList<>();
        HashMap<Integer, Integer> hx = new HashMap<>();

        Pair rooter = new Pair(root, 0);
        qx.add(rooter);

        while (qx.size() > 0) {
            //take out the node from the queue
            Pair temp = qx.remove();

            hx.put(temp.verticalLevel, temp.n.data);
            //we want to find the last node of a particular verticalLevel
            //hence for everyNode we put to it to our hashMap, it if
            //the verticalLevel exists then it will overwrite our current topNode
            //otherwise add a Node for a new verticalLevel

            //we know its a new node downwards as we are doing level Order Traversal
            //hence we go one level down everytime


            if(temp.n.left != null) {
                qx.add(new Pair(temp.n.left, temp.verticalLevel - 1));
                //as we're moving left so our verticalLevel will decrease by 1
                //as that from the parent level
            }

            if(temp.n.right != null) {
                qx.add(new Pair(temp.n.right, temp.verticalLevel + 1));
                //as we're moving right so our verticalLevel will increase by 1
                //as that from the parent level
            }
        }

        //iterate and find the min and max Value of the verticalLevels from the
        //keySet in the Hashmap
        int minVerticalLevel = Integer.MAX_VALUE;
        int maxVerticalLevel = Integer.MIN_VALUE;

        for(int i : hx.keySet()) {
            minVerticalLevel = Math.min(minVerticalLevel, i);
            maxVerticalLevel = Math.max(maxVerticalLevel, i);
        }

        //now we'll iterate between these and add it to the ArrayList
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = minVerticalLevel; i <= maxVerticalLevel; i++) {
            ans.add(hx.get(i));
        }

        return ans;
    }
}
