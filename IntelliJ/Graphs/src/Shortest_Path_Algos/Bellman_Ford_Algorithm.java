package Shortest_Path_Algos;

import java.util.ArrayList;
import java.util.Arrays;

public class Bellman_Ford_Algorithm {
    public static void main(String[] args) {
        //https://www.geeksforgeeks.org/problems/distance-from-the-source-bellman-ford-algorithm/1?utm_source=geeksforgeeks
    }

    static int[] bellman_ford(int V, ArrayList<ArrayList<Integer>> edges, int S) {
        int n = V;
        //bellman ford is one of the few algos which can be implemented
        //without explicitly constructing the graph

        int[] ans = new int[n];
        int[] ansForNegativeWeightCycle = new int[1];
        ansForNegativeWeightCycle[0] = -1;
        //this is added cz question says that there can be negative weight cycles present


        Arrays.fill(ans, 100000000);
        //ques told to do this, otherwise we could also use
        //Integer.MAX_VALUE

        //arraylist consists of u, v and weight
        ans[S] = 0;
        //src to src shortest path is 0

        for (int i = 0; i < n - 1; i++) {
            //no of iterations = n - 1,
            //as we're starting from 0 toh i < n - 1 kar rhe
            //0 -> n - 2 = n - 1 iterations
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

        //if for the Vth iteration this runs then there is a
        //negative weight cycle present
        boolean flag = false;
        for(ArrayList<Integer> arx : edges) {
            int u = arx.get(0);
            int v = arx.get(1);
            int weight = arx.get(2);

            if(ans[u] != 100000000 && ans[u] + weight < ans[v]) {
                flag = true;
                return ansForNegativeWeightCycle;
            }
        }
        return ans;
    }
}
