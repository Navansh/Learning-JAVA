package Graph_Questions.DSU;

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

        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < isConnected.length; i++) {
            for (int j = 0; j < isConnected[i].length; j++) {
                if(isConnected[i][j] == 1) {
                    int u = i;
                    int v = j;

                    union(u,v, parent);
                }
            }
        }

        //now we have the parent array filled
        //so to find the number of disjoint sets
        //we need to check for the condition that
        //a parent is that that points to itself
        int count = 0;
        for (int i = 0; i < parent.length; i++) {
            if(parent[i] == i) {
                count++;
            }
        }
        return count;
    }

    private void union(int x, int y, int[] parent) {
        int parentOfX = find(x, parent);
        int parentOfY = find(y, parent);

        parent[parentOfX] = parentOfY;
    }

    private int find(int x, int[] parent) {
        //to find the leader, the index and the value should
        //match
        if(x == parent[x]) {
            return x;
        }

        int temp = find(parent[x], parent);
        return temp;
    }

    public int findCircleNum(int[][] isConnected) {
        //doesn't work on all test cases
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
