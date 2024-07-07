package Shortest_Path_Algos;

public class Floyd_Warshall_Algorithm {
    public static void main(String[] args) {
        //https://www.geeksforgeeks.org/problems/implementing-floyd-warshall2042/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=implementing-floyd-warshall
    }

    public void shortest_distance(int[][] matrix) {
        //given adjacency matrix
        //Matrix[i][j] denotes the weight of the edge from i to j.
        // If Matrix[i][j]=-1, it means there is no edge from i to j.

        //hence we need to edit this matrix only and return this

        int n = matrix.length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(matrix[i][j] == -1) {
                    matrix[i][j] = (int) 1e9;
                    //according to ques this edge doesn't
                    //exist and as we're using negative cost
                    //to represent negative cycle
                    //we change this to the max value
                    //we'll undo this change in the last
                }
                if(i == j) {
                    //node to node shortest path is 0
                    matrix[i][j] = 0;
                }
            }
        }

        for (int via = 0; via < n; via++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    //going through 'via'
                    long sum = matrix[i][via] + matrix[via][j];
                    matrix[i][j] = (int) Math.min(matrix[i][j], sum);
                }
            }
        }

        //negative cycle detection :
        for (int i = 0; i < n; i++) {
            if(matrix[i][i] < 0) {
                System.out.println("Negative Cycle Detected");
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(matrix[i][j] == (int) 1e9) {
                    matrix[i][j] = -1;
                }
            }
        }

    }

}
