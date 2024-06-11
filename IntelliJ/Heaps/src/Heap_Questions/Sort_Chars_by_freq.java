package Heap_Questions;

import java.util.*;

public class Sort_Chars_by_freq {
    public static void main(String[] args) {
//https://leetcode.com/problems/sort-characters-by-frequency/
        System.out.println(frequencySort("tree"));
    }

    public static String frequencySort(String s) {

        //This is not a correct solution, check LC solution for more info****
        //**********************************************************************





        HashMap<Integer, Integer> hx = new HashMap<>();

        for(char ch : s.toCharArray()) {
            int temp = ch + '0';
            if(hx.containsKey(temp)) {
                int freq = hx.get(temp);
                hx.put(temp, freq + 1);
            } else {
                hx.put(temp, 1);
            }
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        //this is a max Priority Queue

        //add all the elements of our Hashmap into this
        StringBuilder str = new StringBuilder();
        for (int val :
                hx.keySet()) {
            pq.add(hx.get(val));
        }

        //now for every freq, remove it get the corresponding element from it and add
        for(int i = 0; i < pq.size(); i++) {
            //get the key of the peeked element in the pq from hashmap
            int peeked_ele = pq.peek();

        }
        for (Map.Entry<Integer, Integer> entry : hx.entrySet()) {
//            if (Objects.equals(entry.getValue(), pq.peek())) {
//                int foundKey = entry.getKey();
//                //add this key to the stringbuilder as a chart
//                str.append((char) foundKey);
//            }
            System.out.println(pq.peek());
        }

        return str.toString();
    }
}
