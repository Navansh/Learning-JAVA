package Graph_Questions.Articulation_Point;

import java.util.ArrayList;
import java.util.List;

public class Articulation_Point {
    public static void main(String[] args) {

    }


    boolean[] vis;
    int[] low;
    int[] discovery;
    int time = 0;
    ArrayList<Integer> lx = new ArrayList<>();
    boolean[] ans;

    public ArrayList<Integer> articulationPoints(int V,ArrayList<ArrayList<Integer>> adj) {
        vis = new boolean[V];
        low = new int[V];
        discovery = new int[V];
        ans = new boolean[V];


        bridges(adj, V, 0, -1);
        //initially the parent is -1
        //as we reached this 0 from no where

        for (int i = 0; i < ans.length; i++) {
            if(ans[i]) {
                lx.add(i);
            }
        }

        return lx;
    }

    public void bridges(ArrayList<ArrayList<Integer>> graph, int n, int src, int parent) {
        discovery[src] = time;
        //also during this only, we assign the low
        low[src] = time;
        //this will be updated in the future
        //as the lowest discovery point will be the node itself
        //or someone before it
        time++;

        List<Integer> nbrs = graph.get(src);

        for(int nbr : nbrs) {
            if(nbr == parent) {
                continue;
                //as this is the path that got you here
                //is useless and we don't want to process that part
            } else if(vis[nbr] == false) {
                //now the other nbrs will fall into 2 categories
                //if its not parent and also not visited

                //so mark this visited and go to this
                vis[nbr] = true;
                bridges(graph, n, nbr, src);
                //what this function helps create is the low array
                low[src] = Math.min(low[src], low[nbr]);
                //this means if my nbr can visit that, I can visit that too
                //so update the src low point
                if(low[nbr] >= discovery[src]) {
                    //then the src is an articulation point
                    ans[src] = true;
                }
            } else {
                //vis[nbr] = true waala case
                //no need to do dfs

                //means this number is part of the path that we took
                //and we cannot cross this path
                //hence we just identify the discovery of that node

                low[src] = Math.min(low[src], discovery[nbr]);
                //hence we just update the low, means the lowest
                //point the src can go to
                //either its the lowest of src or either it is
                //the lowest discovery of the nbr
            }
        }
    }
}
