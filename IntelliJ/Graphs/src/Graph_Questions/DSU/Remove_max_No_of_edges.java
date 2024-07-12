package Graph_Questions.DSU;

import java.util.Arrays;
import java.util.HashSet;

public class Remove_max_No_of_edges {
    public static void main(String[] args) {
        //https://leetcode.com/problems/remove-max-number-of-edges-to-keep-graph-fully-traversable/description/

        //doesn't submit on LC
    }


    public int maxNumEdgesToRemove(int n, int[][] edges) {
        //now we want to work on the type 3 edge first
        //so we sort the array to get that first
        Arrays.sort(edges, (a, b) -> Integer.compare(b[0], a[0]));
        //'a' and 'b' here represent the rows, and a[0] and b[0]
        //represent the first col, which represents the type

        //writing b[0] first gives us decreasing order
        //meaning type 3 first
        //or can say ( b[0] - a[0] )

        int[] parentAlice = new int[n + 1];
        //as the nodes are numbered from 1
        int[] parentBob = new int[n + 1];

        int[] rankAlice = new int[n + 1];
        int[] rankBob = new int[n + 1];

        //initialize the parent array
        for (int i = 0; i <= parentAlice.length; i++) {
            parentAlice[i] = i;
            parentBob[i] = i;
        }

        Arrays.fill(rankAlice, 1);
        Arrays.fill(rankBob, 1);

        int count = 0;
        int countA = 1;
        int countB = 1;
        //this is required at the last to check
        //if the graph was intiallu fully traversable by both
        //Alice and bob

        for (int i = 0; i < edges.length; i++) {
            int type = edges[i][0];
            int u = edges[i][1];
            int v = edges[i][2];

            if(type == 3) {
                //this can merge for both Alice and bob
                boolean mergeA = union(u, v, parentAlice, rankAlice);
                boolean mergeB = union(u, v, parentBob, rankBob);

                if(mergeA == false && mergeB == false) {
                    //meaning their parent was already same
                    //meaning this edge was useless
                    count++;
                }
                if(mergeA == true) {
                    countA++;
                    //then we've added one more node in the set A
                }
                if(mergeB == true) {
                    countB++;
                    //then we've added one more node in the set B
                }
            } else if(type == 2) {
                //meaning only Bob can traverse this
                boolean mergeB = union(u, v, parentBob, rankBob);

                if(mergeB == false) {
                    //then their parent was already same
                    count++;
                } else {
                    countB++;
                    //then we've added one more node in the set B
                }
            } else {
                boolean mergeA = union(u, v, parentAlice, rankAlice);

                if(mergeA == false) {
                    //then their parent was already same
                    count++;
                } else {
                    countA++;
                    //then we've added one more node in the set A
                }
            }
        }

        //now we've got count of no of edges to remove
        //but we check also, ki initially toh graph
        //fully traversable thaa naa
        if(countA != n || countB != n) {
            return -1;
            //meaning the graph was'nt fully traversable
            //initially toh ismein se kuch remove ho hi nhi sakta
        }

        return count;
    }

    private boolean union(int x, int y, int[] parent, int[] rank) {
        int parentOfX = find(x, parent);
        int parentOfY = find(y, parent);

        if(parentOfX == parentOfY) {
            //means they're already merged, and we don't need to
            //merge this
            return false;
        }

        if(rank[parentOfX] > rank[parentOfY]) {
            //merge to the bigger leader
            parent[parentOfY] = parentOfX;
        } else if(rank[parentOfX] < rank[parentOfY]) {
            parent[parentOfX] = parentOfY;
        } else {
            parent[parentOfX] = parentOfY;
            //merge anyways and jisko leader bana rhe uska ++
            parent[parentOfY]++;
        }

        return true;
    }

    private int find(int ele, int[] parent) {
        if(ele == parent[ele]) {
            return ele;
        }

        int temp = find(parent[ele], parent);
        parent[ele] = temp;
        return temp;
    }
}
