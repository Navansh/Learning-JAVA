package Graph_Questions.DSU;

import java.util.Arrays;
import java.util.HashSet;

public class Number_of_Provinces {
    public static void main(String[] args) {
        //already did using DFS
        //doing by DSU now
        //https://leetcode.com/problems/number-of-provinces/description/
    }

    public int findCircleNumWorking(int[][] isConnected) {
        int[] parent = new int[isConnected.length];
        //initially all the values are just the index values itself
        //signifying that each one of the node is parent of itself

        int[] rank = new int[isConnected.length];
        //this will store the length of chain of leaders

        //initially every rank is 1
        Arrays.fill(rank, 1);


        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < isConnected.length; i++) { // O(n * n * 1)
            for (int j = 0; j < isConnected[i].length; j++) {
                if(isConnected[i][j] == 1) {
                    int u = i;
                    int v = j;

                    union(u,v, parent, rank);
                }
            }
        }

        //now we have the parent array filled
        //so to find the number of disjoint sets
        //we need to check for the condition that
        //a parent is that which points to itself
        //hence : parent[i] == i
        int count = 0;
        for (int i = 0; i < parent.length; i++) {
            //O(V)
            if(parent[i] == i) {
                count++;
            }
        }
        return count;

        //total TX : O(n*n) + O(V)
        // == O(E + V ) where E represents the number of edges
        //and V represents Vertices
    }

    private void union(int x, int y, int[] parent, int[] rank) {
        //as find function is O(1) on avg basis,
        //so this function is O(2 * O(1) ) ~ O(1)

        int parentOfX = find(x, parent);
        int parentOfY = find(y, parent);

        if(parentOfX == parentOfY) {
            //then we don't need to do anything
            //as they're already in same set
            return;
        }

        //here we'll now do Union by rank Optimization
        if(rank[parentOfX] > rank[parentOfY]) {
            //making the leader of longer chain as the new leader
            //hence which has more rank
            parent[parentOfY] = parentOfX;
            //doing this the rank of the leader doesn't increase
        } else if(rank[parentOfX] < rank[parentOfY]) {
            parent[parentOfX] = parentOfY;
            //doing this the rank of the leader doesn't increase
        } else {
            //can make any one of them as the new leader, say this
            parent[parentOfX] = parentOfY;
            //here the rank increases
            //hence the rank of new leader increases by 1
            rank[parentOfY]++;
        }
    }

    private int find(int ele, int[] parent) {
        //O(1) - Avg case TC : cz of the path compression optimization
        //worst Case TC is still O(n) where we find and
        //set the parent for certain number of items
        //to find the leader, the index and the value should
        //match
        if(ele == parent[ele]) {
            return ele;
        }

        int temp = find(parent[ele], parent);
        parent[ele] = temp;
        //this is the path compression optimization
        return temp;
    }

    public int findCircleNum(int[][] isConnected) {
        //****************doesn't work on all test cases
        int[] parent = new int[isConnected.length];
        //initially all the values are just the index values itself
        //signifying that each one of the node is parent of itself

        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }

        //as we further in edges list, we'll make the common parents
        //and then find out the number of parent that exist

        for (int i = 0; i < isConnected.length; i++) {
            for (int j = 0; j < isConnected[i].length; j++) {
                if(isConnected[i][j] == 1) {
                    parent[j] = parent[i];
                    //making the common parent

                }
            }
            //cz u and v are connected
        }

        //now count the different number of parent
        HashSet<Integer> hx = new HashSet<>();

        for (int i = 0; i < parent.length; i++) {
            hx.add(parent[i]);
        }

        return hx.size();
    }
}
