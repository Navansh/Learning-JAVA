package Graph_Questions.MST;

import java.util.Arrays;

public class Redundant_Connection {
    public static void main(String[] args) {
        //https://leetcode.com/problems/redundant-connection/description/
    }

    public int[] findRedundantConnection(int[][] edges) {
        int[] parent = new int[edges.length + 1];
        int[] rank = new int[edges.length + 1];
        //as given in the question that the nodes
        //are from 1 to n

        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }

        Arrays.fill(rank, 1);

        //now iterate on all of the edges
        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];

            boolean res = union(u, v, parent, rank);

            if(res == false) {
                return new int[] {u, v};
            }
        }

        return new int[] {-1, -1};
    }

    public boolean union(int x, int y, int[] parent, int[] rank) {
        int parentX = find(x, parent, rank);
        int parentY = find(y, parent, rank);

        if(parentX == parentY) {
            //cycle formed
            return false;
        }
        if(rank[parentX] > rank[parentY]) {
            parent[parentY] = parentX;
        } else if(rank[parentX] < rank[parentY]) {
            parent[parentX] = parentY;
        } else {
            parent[parentX] = parentY;
            rank[parentY]++;
        }

        return true;
    }

    public int find(int x, int[] parent, int[] rank) {
        if(x == parent[x]) {
            return x;
        }

        int temp = find(parent[x], parent, rank);
        parent[x] = temp;
        //this is the path compression
        return temp;

    }
}
