package Graph_Questions.MST;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Prims_Algo {
    public static void main(String[] args) {

    }

    static class Pair implements Comparable<Pair> {
        int node;
        int weight;

        Pair(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }

        @Override
        public int compareTo(Pair o) {
            return this.weight - o.weight;
        }
    }

    static int spanningTree(int V, int E, List<List<int[]>> adj) {
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>();

        int ans = 0;
        boolean[] vis = new boolean[V];

        List<int[]> edges = new ArrayList<>();
        for (int u = 0; u < V; u++) {
            for (int[] edge : adj.get(u)) {
                int v = edge[0];
                int wt = edge[1];
                edges.add(new int[]{u, v, wt});
            }
        }

        pq.add(new Pair(0 , 0));
        //this is the src we're adding

        while (pq.size() > 0) {
            Pair rem = pq.remove();

            if(!vis[rem.node]) {
                vis[rem.node] = true;
                ans += rem.weight;

                int[] nbrs = edges.get(rem.node);

                for (int i = 0; i < nbrs.length; i++) {
                    if(vis[nbrs[i]]) {
                        continue;
                    } else {
                        pq.add(new Pair(vis[nbrs[i]], ))
                    }
                }
            }
        }





    }
}
