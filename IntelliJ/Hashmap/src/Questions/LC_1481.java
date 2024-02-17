package Questions;

import java.util.HashMap;
import java.util.HashSet;

public class LC_1481 {
    public static void main(String[] args) {

    }

    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        //place the elements in a HashMap

        HashMap<Integer, Integer> hx = new HashMap<>();

        for(int i = 0; i < arr.length; i++) {
            if(hx.containsKey(arr[i])) {
                int temp = hx.get(arr[i]);
                hx.put(arr[i], temp + 1);
            } else {
                hx.put(arr[i], 1);
            }
        }

        return -1;
        //


    }
}
