package Graph_Questions.Cycle_Detection;

import java.util.ArrayList;
import java.util.Arrays;

public class Negative_Weight_Cycle_Detection {
    public static void main(String[] args) {
        //we Can detect it using Bellman ford algo
        //https://www.geeksforgeeks.org/problems/negative-weight-cycle3504/1?utm_source=geeksforgeeks
    }

    static int[] bellman_ford(int V, ArrayList<ArrayList<Integer>> edges, int S) {
        int n = V;
        //bellman ford is one of the few algos which can be implemented
        //without explicitly constructing the graph

        //wrong code given in the doc, not being submitted on GFG


        int[] ans = new int[n];

        Arrays.fill(ans, 100000000);
        //ques told to do this, otherwise we could also use
        //Integer.MAX_VALUE

        //arraylist consists of u, v and weight
        ans[S] = 0;
        //src to src shortest path is 0

        for (int i = 0; i < n - 1; i++) {
            //no of iterations = n - 1,
            //as we're starting from 0 toh i < n - 1 kar rhe

            //for each iteration we visit all the edges
            for(ArrayList<Integer> arx : edges) {
                int u = arx.get(0);
                int v = arx.get(1);
                int weight = arx.get(2);

                if(ans[u] != 100000000 && ans[u] + weight < ans[v]) {
                    ans[v] = ans[u] + weight;
                }
            }
        }

        boolean flag = false;
        for(ArrayList<Integer> arx : edges) {
            int u = arx.get(0);
            int v = arx.get(1);
            int weight = arx.get(2);

            if(ans[u] != 100000000 && ans[u] + weight < ans[v]) {
                flag = true;
                break;
            }
        }

        if(flag == true) {
            System.out.println("Negative Weight Cycle Present");
        }
        return ans;
    }

}
