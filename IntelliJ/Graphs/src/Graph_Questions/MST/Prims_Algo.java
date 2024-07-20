package Graph_Questions.MST;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class Prims_Algo {
    public static void main(String[] args) {

    }

    static class Pair implements Comparable<Pair> {
        int vertex;
        int weight;

        Pair(int node, int weight) {
            this.vertex = node;
            this.weight = weight;
        }

        @Override
        public int compareTo(Pair o) {
            return this.weight - o.weight;
        }
    }

    static int spanningTree(int V, int E, List<List<int[]>> adj) {
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>();

        boolean[] vis = new boolean[V];
        //cyclicity is removed using this vis array


        pq.add(new Pair(0,0));
        //this is the src we're adding

        int finalCost = 0;

        while (!pq.isEmpty()) {
            Pair curr = pq.poll();
            //if unable to remove poll gives null exception
            //whereas remove gives exception

            if(vis[curr.vertex]) {
                continue;
                //as we don't want to form any cycle
            }

            vis[curr.vertex] = true;
            finalCost+= curr.weight;

            for (int[] nbr : adj.get(curr.vertex)) {
                int dest = nbr[0];
                int wt = nbr[1];
                if(!vis[dest]) {
                    pq.add(new Pair(dest, wt));
                }
            }

        }

        return finalCost;
    }
}
