package Shortest_Path_Algos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Dijkstras_Algorithm {
    public static void main(String[] args) {
        //https://www.geeksforgeeks.org/problems/implementing-dijkstra-set-1-adjacency-matrix/1?utm_source=geeksforgeeks
    }

    static class Pair implements Comparable<Pair> {
        int vertex;
        int weight;
        //weight so far is also stored using this

        Pair(int vertex, int weight) {
            this.vertex = vertex;
            this.weight = weight;
        }

        @Override
        public int compareTo(Pair o) {
            return this.weight - o.weight;
            //will return the smaller first
        }
    }

    static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S) {
        int n = V;
        //no of nodes = n

        PriorityQueue<Pair> pq = new PriorityQueue<>();
        //TC : we cannot have more than edges (number)
        //in the PQ
        int[] ans = new int[n];
        //initializing this with +infinite

        Arrays.fill(ans, Integer.MAX_VALUE);
        //to signify that this value has been filled previously
        //modified or not

        pq.add(new Pair(S, 0));
        //src to src shortest path is 0
        //hence this weight represents weight so far

        while (!pq.isEmpty()) {
            Pair removed = pq.remove();
            if(ans[removed.vertex] != Integer.MAX_VALUE) {
                continue;
                //then this is already set to its lowest value
            } else {
                //this condition will run for the first time
                //we are updating this value for this node
                //and won't run after that
                ans[removed.vertex] = removed.weight;

                //now that we've updated for this vertex
                //go to all of its neighbours

                ArrayList<ArrayList<Integer>> nbrs = adj.get(removed.vertex);
                for(ArrayList<Integer> arx : nbrs) {
                    int vertex = arx.get(0);
                    int weight = arx.get(1);

                    if(ans[vertex] != Integer.MAX_VALUE) {
                        //means it has been filled value previously
                        //and we don't need to modify this
                        continue;
                    } else {
                        pq.add(new Pair(vertex, removed.weight + weight));
                    }
                }
            }
        }

        return ans;
    }
}
