package Graph_Questions.Articulation_Point;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Bridges_Ques {
    public static void main(String[] args) {
        //https://leetcode.com/problems/critical-connections-in-a-network/description/
    }

    boolean[] vis;
    int[] low;
    int[] discovery;
    int time = 0;
    List<List<Integer>> lx = new ArrayList<>();

    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        //src is 0
        vis = new boolean[n];
        low = new int[n];
        discovery = new int[n];


        bridges(connections, n, 0, -1);
        //initially the parent is -1
        //as we reached this 0 from no where

        return lx;
    }

    public void bridges(List<List<Integer>> graph, int n, int src, int parent) {
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
                if(low[nbr] > discovery[src]) {
                    //then their is bridge between src and nbr
                    List<Integer> temp = new ArrayList<>();
                    temp.add(src);
                    temp.add(nbr);
                    lx.add(temp);
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
