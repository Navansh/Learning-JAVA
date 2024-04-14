package Stack_Questions;

import java.util.ArrayList;

public class Number_of_Provinces {
    public static void main(String[] args) {
        //same intuition as that of connected component
    }

    static int numProvinces(ArrayList<ArrayList<Integer>> adj, int V) {

        //adjacency matrix to adjacency list

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

        //initialize n ArrayLists
        for(int i=0;i<V;i++){
            graph.add(new ArrayList<>());
        }

        for(int i=0;i<V;i++) {
            for(int j=0;j<adj.get(i).size();j++){
                if(adj.get(i).get(j) == 1){
                    graph.get(i).add(j);
                    graph.get(j).add(i);
                }
            }
        }

        boolean[] vis = new boolean[V];
        int ans = 0;

        //vertex means node
        //so :
        int n = V;


        //now apply dfs for every node, and calculate the ans
        for(int i = 0; i < n ; i++) {
            if(vis[i] == false) {
                vis[i] = true;
                dfs(graph, vis, i);
                ans++;
            }
        }

        return ans;
    }

    static void dfs(ArrayList<ArrayList<Integer>> adj, boolean[] vis, int src) {
        //first get the connected list from the Graph's Common List
        ArrayList<Integer> nbrs = adj.get(src);

        for(int i = 0; i < nbrs.size() ;i++) {
            //get the node from the nbrs list
            int u = nbrs.get(i);
            if(vis[u] == false) {
                vis[u] = true;
                dfs(adj, vis, u);
            }
        }
    }
}
