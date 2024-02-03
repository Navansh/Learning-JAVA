import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFS_Traversal {
    public static void main(String[] args) {

    }

    public static void BFSTraversal(int n, int m, int[][] edges) {
        List<List<Integer>> graph = construction(n,m,edges);

        Queue<Integer> q = new LinkedList<>();
        boolean[] vis = new boolean[n];

        //taking the initial node to be 0
        q.add(0);
        vis[0] = true;

        while (q.size() > 0) {
            int remove = q.remove();
            System.out.print(remove + " ");

            //add all unvisited neighbours
            //get all the neighbours for this
            List<Integer> neighbours = graph.get(remove);

            for (int ele : neighbours) {
                if(!vis[ele]) {
                    q.add(ele);
                    vis[ele] = true;
                }
            }

        }

    }

    private static List<List<Integer>> construction(int n, int m, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();
        //this will give us an empty arrayList and we'll have to initialize
        //every List<Integer> that is inside it

        //hence, we do this
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            //actual setting operation begins here
            int u = edges[i][0];
            int v = edges[i][1];

            graph.get(u).add(v);
            graph.get(v).add(u);

            //this is done considering a bidirectional graph
            //so what we're doing is, getting the ith arraylist from the collection of lists
            //and then adding the connected node value ( its number and not its weight ), to it
            //and then doing same for v and then adding u as this is a bidirectional graph
        }
        return graph;
    }
}
