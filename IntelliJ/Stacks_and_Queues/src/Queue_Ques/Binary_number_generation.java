package Queue_Ques;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Binary_number_generation {
    public static void main(String[] args) {
        System.out.println(generate(5));
        //https://www.geeksforgeeks.org/problems/generate-binary-numbers-1587115620/1?itm_source=geeksforgeeks
    }

    static ArrayList<String> generate(int N) {
        // Your code here
        ArrayList<String> ans = new ArrayList<>();
        Queue<String> collection = new LinkedList<>();

        collection.add("1");

        for (int i = 0; i < N; i++) {
            String temp = collection.remove();
            ans.add(temp);
            collection.add(temp + "0");
            collection.add(temp + "1");
        }

        return ans;
    }
}
