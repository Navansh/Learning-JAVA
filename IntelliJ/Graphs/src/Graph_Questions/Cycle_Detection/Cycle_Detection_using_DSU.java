package Graph_Questions.Cycle_Detection;

public class Cycle_Detection_using_DSU {
    public static void main(String[] args) {

    }

    public boolean detectCycle(int[][] edges, int N) {
        int n = N;
        int[] parent = new int[n];
        int[] rank = new int[n];

        //if during merging we find out that the edge's nodes
        //have the same parent i.e. that are already in the same
        //set and still we have this edge
        //means we have a cycle if we include this edge

        //without using this edge, somehow this edge's nodes
        //are connected, so if we connect them via this path as well
        //then cycle will form

        return true;


    }
}
