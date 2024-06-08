import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Topological_Sort {
    public static void main(String[] args) {

    }

    public static int[] TopologicalSort(List<List<Integer>> graph, int n) {
        //this is done using Kahn's Algo
        //Topological Sort Steps :
        //Find the indegree of every node in the graph
        //start with the node with indegree as 0
        //with every successful additon lower the indegree of neighbouring nodes by 1
        //if they reach 0, add them to the queue and repeat the steps

        int[] indegree = new int[n];

        for(int i=0;i<n;i++){
            for(int v: graph.get(i)){
                indegree[v]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();

        int[] topoAns = new int[n];

        for(int i=0;i<n;i++){
            if(indegree[i]==0){
                q.add(i);
            }
        }


        int i=0;

        while(!q.isEmpty()){

            int node=q.remove();
            topoAns[i++]= node;

            for(int v: graph.get(node)){
                indegree[v]--;
                if(indegree[v]==0){
                    q.add(v);
                }
            }
        }

        return topoAns;


    }
}
