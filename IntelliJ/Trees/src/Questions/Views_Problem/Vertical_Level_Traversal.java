package Questions.Views_Problem;

import java.util.*;

public class Vertical_Level_Traversal {
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

    public static class Pair{
        Node n;
        int verticalLevel;

        public Pair(Node n, int verticalLevel) {
            this.n = n;
            this.verticalLevel = verticalLevel;
        }
    }

    static ArrayList<Integer> verticalOrder(Node root) {
        //**********MAY NEED TO CREATE A NULL POINTER CHECK FOR ROOT********
        //HERE MIN LENGTH GIVEN IN PROBLEM IS 1, so not doing it here

        //we need to create a hashmap
        HashMap<Integer, ArrayList<Integer>> hx = new HashMap<>();
        Queue<Pair> qx = new LinkedList<>();

        qx.add(new Pair(root, 0));
        while (qx.size() > 0) {
            Pair removed = qx.remove();

            if(hx.containsKey(removed.verticalLevel)) {
                ArrayList<Integer> temp = hx.get(removed.verticalLevel);
                temp.add(removed.n.data);
            } else {
                ArrayList<Integer> level = new ArrayList<>();
                level.add(removed.n.data);
                hx.put(removed.verticalLevel, level);
            }

            if(removed.n.left != null) {
                //add it to the queue
                qx.add(new Pair(removed.n.left, removed.verticalLevel - 1));
            }

            if(removed.n.right != null) {
                //add it to the queue
                qx.add(new Pair(removed.n.right, removed.verticalLevel + 1));
            }
        }

        int minVerticalLevel = Integer.MAX_VALUE;
        int maxVerticalLevel = Integer.MIN_VALUE;

        for(int i : hx.keySet()) {
            minVerticalLevel = Math.min(minVerticalLevel, i);
            maxVerticalLevel = Math.max(maxVerticalLevel, i);
        }

        //now traverse each verticalLevel and add its nodes to final ArrayList
        ArrayList<Integer> ans = new ArrayList<>();

        for (int i = minVerticalLevel; i <= maxVerticalLevel; i++) {
            ArrayList<Integer> temp = hx.get(i);
            ans.addAll(temp);
        }

        return ans;
    }
}
