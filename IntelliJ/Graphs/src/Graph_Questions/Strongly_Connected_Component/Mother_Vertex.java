package Graph_Questions.Strongly_Connected_Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Mother_Vertex {
    public static void main(String[] args) {
        //https://www.geeksforgeeks.org/problems/mother-vertex/1
    }

    public int findMotherVertex(int V, ArrayList<ArrayList<Integer>>adj) {
        //a similar implementation like that of Kosaraju algo
        boolean[] vis = new boolean[V];
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < V; i++) {
            if(vis[i] == false) {
                dfs(adj, vis, st, i);
            }
        }

        //now verify if the top of the stack
        //vertex is the mother vertex
        boolean[] vis2 = new boolean[V];
        Stack<Integer> stacker = new Stack<>();
        dfs(adj, vis2, stacker, st.peek());

        for (int i = 0; i < vis2.length; i++) {
            if(!vis2[i]) {
                return -1;
            }
        }

        return st.peek();

    }

    public void dfs(ArrayList<ArrayList<Integer>> graph, boolean[] vis, Stack<Integer> st, int src) {
        vis[src] = true;
        ArrayList<Integer> nbrs = graph.get(src);

        for(int v : nbrs) {
            if(!vis[v]) {
                dfs(graph, vis, st, v);
            }
        }

        st.push(src);
    }
}
