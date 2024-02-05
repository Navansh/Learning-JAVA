package Questions;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Detect_cycle_in_directed_graph {
    public static void main(String[] args) {

    }

    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        // code here

        //implementation of Topological Sort
        //apply Topological sort but also keep count counter
        //if that count is equal to the no of nodes, then the given graph is not cyclic
        //else it is cyclic

        int n = V;
        //create an indegree array
        int[] indegree = new int[n];

        for(int i = 0; i < n; i++) {
            for(int v : adj.get(i)) {
                indegree[v] += 1;
            }
        }

        //now we have an indegree array
        Queue<Integer> q = new LinkedList<>();

        for(int i = 0; i < indegree.length; i++) {
            if(indegree[i] == 0) {
                q.add(i);
            }
        }

        int count = 0;
        while(!q.isEmpty()) {
            int node = q.poll();

            count++;
            for(int v : adj.get(node)) {
                indegree[v] -= 1;
                if(indegree[v] == 0) {
                    q.add(v);
                }
            }
        }

        if(count == n) {
            return false;
        }

        return true;
    }
}
