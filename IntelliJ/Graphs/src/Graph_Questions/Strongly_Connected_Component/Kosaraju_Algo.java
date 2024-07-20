package Graph_Questions.Strongly_Connected_Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Kosaraju_Algo {
    public static void main(String[] args) {
        //https://www.geeksforgeeks.org/problems/strongly-connected-components-kosarajus-algo/1?utm_source=geeksforgeeks
    }

    public int kosaraju(int V, ArrayList<ArrayList<Integer>> adj) {
        int count = 0;
        boolean[] vis = new boolean[V];
        Stack<Integer> stacker = new Stack<>();

        //we do dfs till everything is visited
        //and store the vertex in stack while coming back
        for (int i = 0; i < V; i++) {
            if(!vis[i]) {
                dfs(adj, vis, stacker, i);
            }
        }

        //Step 2 :
        //Create a new graph with reverse edges
        ArrayList<ArrayList<Integer>> graph2 = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            ArrayList<Integer> temp = new ArrayList<>();
            graph2.add(temp);
        }

        for (int i = 0; i < V; i++) {
            for(int nbr : adj.get(i)) {
                graph2.get(nbr).add(i);
                //to form the opposite vertices we're doing
                //this
                //otherwise would've done
                //graph2.get(i).add(nbr);
            }
            /*
            ArrayList<Integer> nbrs = adj.get(i);
            int u = i;
            for (int j = 0; j < nbrs.size(); j++) {
                int v = nbrs.get(j);
                ArrayList<Integer> getto = graph2.get(j);
                getto.add(u);
            }
             */
        }

        //Step 3 :
        //do dfs in the order of stack that we created
        //create new  vis and dummy stack as we don't need stack
        //for this as we just need to count how many times we're able to do dfs

        boolean[] vis2 = new boolean[V];
        Stack<Integer> dummy = new Stack<>();
        while (!stacker.isEmpty()) {
            int rem = stacker.pop();
            if(!vis2[rem]) {
                dfs(graph2, vis2, dummy, rem);
                count++;
            }
        }

        return count;
    }

    public static void dfs(ArrayList<ArrayList<Integer>> adj, boolean[] vis, Stack<Integer> stacker, int src) {
        ArrayList<Integer> nbrs = adj.get(src);
        vis[src] = true;

        for (int nbr : nbrs) {
            if (!vis[nbr]) {
                //means theis neighbour hasn't been visited before
                dfs(adj, vis, stacker, nbr);
            }
        }

        stacker.push(src);
    }



}
