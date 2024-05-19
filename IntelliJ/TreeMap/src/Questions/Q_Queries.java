package Questions;

import java.util.TreeSet;

public class Q_Queries {
    static TreeSet<Integer> treesx = new TreeSet<>();

    public static void main(String[] args) {

    }
}

class Solution {
    int[] arr;
    TreeSet<Integer> treeSx;

    public Solution(int n) {
        arr = new int[n];
        treeSx = new TreeSet<>();
    }

    public void query1(int i) {
     //i represents the ith Index
     //whichever index's value is 0, we store that in Treeset, as that
     //will be changed to 1 after this function(next line) executes

        if(arr[i] == 0) {
            treeSx.add(i);
            arr[i] = 1 - arr[i];
        } else {
            treeSx.remove(i);
            arr[i] = 1 - arr[i];
        }
    }
    public int query2(int i) {
        //calculate the left and right nearest for the given index
        int leftNearest = treeSx.floor(i);
        int rightNearest = treeSx.ceiling(i);

        int leftDistance = i - leftNearest;
        int rightDistance = rightNearest - i;

        if(leftDistance <= rightDistance) {
         return leftNearest;
         //as we to return the index
        }

        return rightNearest;
    }
 }
