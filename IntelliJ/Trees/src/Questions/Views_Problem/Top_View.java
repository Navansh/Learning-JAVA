package Questions.Views_Problem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class Top_View {
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

    static ArrayList<Integer> topView(Node root) {
        //**********MAY NEED TO CREATE A NULL POINTER CHECK FOR ROOT********
        //HERE MIN LENGTH GIVEN IN PROBLEM IS 1, so not doing it here

        Queue<Pair> qx = new LinkedList<>();
        HashMap<Integer, Integer> hx = new HashMap<>();

        Pair rooter = new Pair(root, 0);
        qx.add(rooter);

        while (qx.size() > 0) {
            //take out the node from the queue
            Pair temp = qx.remove();
            if(!hx.containsKey(temp.verticalLevel)) {
                //means the hashMap doesn't contain this level
                //add this to the HashMap
                hx.put(temp.verticalLevel, temp.n.data);
            }
            //if the hx, has this key then,
            // this level's first Node has already been captured

            //these following steps are common for both the cases
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

        //now e'll iterate between these and add it to the ArrayList
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = minVerticalLevel; i <= maxVerticalLevel; i++) {
            ans.add(hx.get(i));
        }

        return ans;
    }
}
