package Questions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class LC_1207_uniqueOccurrences {
    public static void main(String[] args) {
//        Given an array of integers arr, return true if the number of occurrences of
//        each value in the array is unique or false otherwise.
        int[] arr = {1,2,2,1,1,3};
        System.out.println();
    }

    public static boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        HashSet<Integer> uniqueOccurances = new HashSet<>();


        for (int i = 0; i < arr.length; i++) {
            if(hashMap.containsKey(arr[i])) {
                int val = hashMap.get(arr[i]);
                hashMap.put(arr[i], val + 1 );
            } else {
                hashMap.put(arr[i], 1);
            }
        }

        ArrayList<Integer> arrlist = new ArrayList<>();
        //
        //traverse through the Hashmap and insert the occurances into this arraylist
        for (int val:
                hashMap.keySet()) {
            arrlist.add(hashMap.get(val));
            uniqueOccurances.add(hashMap.get(val));
        }

        return arrlist.size() == uniqueOccurances.size();







    }
}
