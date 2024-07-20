package Graph_Questions.MST;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Kruskals_Algo {
    public static void main(String[] args) {

    }

    static int spanningTree(int V, int E, List<List<int[]>> adj) {
        int[] parent = new int[V];
        int[] rank = new int[V];
        int ans = 0;
        //this will contain all the weights

        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }

        Arrays.fill(rank, 1);

        //now we want to create min spanning tree
        //so we want edges of min weight first
        //hence we do sorting

        List<int[]> edges = new ArrayList<>();
        for (int u = 0; u < V; u++) {
            for (int[] edge : adj.get(u)) {
                int v = edge[0];
                int wt = edge[1];
                edges.add(new int[]{u, v, wt});
            }
        }

        //now apply the comparator on edges
        edges.sort((a, b) -> Integer.compare(a[2], b[2]));
        //we're sorting in increasing order
        
        //now iterate on all the edges
        for (int[] edge:edges) {
            //can run like this
            //or can run through count also
            //till we get (V - 1) eligible edges

            int u = edge[0];
            int v = edge[1];
            int weight = edge[2];

            boolean res = union(u , v, parent, rank);
            //this res is false then it represents that
            //merging didn't happen and they were part of same grp
            //then we can reach this via via someone
            //and hence we don't need to consider this

            if(res) {
                ans += weight;
            }
        }

        return ans;
        //this will contain the weight of V - 1 edges
        //that will be included in our spanning tree

    }

    private static boolean union(int x, int y, int[] parent, int[] rank) {
        int parentOfX = find(x, parent);
        int parentOfY = find(y, parent);

        if(parentOfX == parentOfY) {
            //means they're already merged, and we don't need to
            //merge this
            return false;
        }

        if(rank[parentOfX] > rank[parentOfY]) {
            //merge to the bigger leader
            parent[parentOfY] = parentOfX;
        } else if(rank[parentOfX] < rank[parentOfY]) {
            parent[parentOfX] = parentOfY;
        } else {
            parent[parentOfX] = parentOfY;
            //merge anyways and jisko leader bana rhe uska ++
            rank[parentOfY]++;
            //rank of parentOfY increase ho jaayegi

        }

        return true;
    }

    private static int find(int ele, int[] parent) {
        if(ele == parent[ele]) {
            return ele;
        }

        int temp = find(parent[ele], parent);
        parent[ele] = temp;
        return temp;
    }
}
