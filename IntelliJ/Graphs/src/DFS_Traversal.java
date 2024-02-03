import java.util.ArrayList;
import java.util.List;

public class DFS_Traversal {
    public static void main(String[] args) {
        int src = 0;
        boolean[] vis = new boolean[55];
        //assume some length here
//        ArrayList<Integer> ans = dfsOfGraph();



    }

    public static ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        int n = V;
        boolean[] vis = new boolean[n];

        //let's assume the src to be 0
        ArrayList<Integer> lister = new ArrayList<>();
        lister.add(0);
        vis[0] = true;

        dfs(lister, adj, n, 0, vis);

        return lister;
    }

    public static void dfs(ArrayList<Integer> lister, ArrayList<ArrayList<Integer>> adj, int n, int src, boolean[] vis) {

        ArrayList<Integer> nbrs = adj.get(src);

        for(int i = 0; i < nbrs.size(); i++) {
            int nbr = nbrs.get(i);

            if(vis[nbr] == false) {
                //means theis neighbour hasn't been visited before
                lister.add(nbr);
                vis[nbr] = true;
                dfs(lister, adj, n, nbr,vis );
            }
        }
    }

}
