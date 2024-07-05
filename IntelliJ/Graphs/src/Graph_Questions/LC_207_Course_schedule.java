package Graph_Questions;

import java.util.*;

public class LC_207_Course_schedule {
    public static void main(String[] args) {

    }

    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        //firstly we'll create an indegree array
        HashMap<Integer,ArrayList<Integer>> hmap = new HashMap<>();
        //here we'll store all the relations between the nodes

        int[] indegree = new int[numCourses];

        for(int i = 0; i < prerequisites.length; i++) {
            indegree[prerequisites[i][0]]++;

            if(!hmap.containsKey(prerequisites[i][1])){
                hmap.put(prerequisites[i][1] , new ArrayList<Integer>());
            }

            //add the connection to the ArrayList
            hmap.get(prerequisites[i][1]).add(prerequisites[i][0]);

        }

        Queue<Integer> q = new LinkedList<>();

        for(int i = 0; i < indegree.length; i++) {
            if(indegree[i] == 0) {
                q.add(i);
            }
        }

        int count = 0;
        while(q.size() > 0 ){
            int node = q.remove();

            count++;

            if(hmap.containsKey(node)) {
                for(int r : hmap.get(node)) {
                    //now we are in the arraylist of the b(ith)
                    indegree[r]--;
                    if(indegree[r] == 0) {
                        q.add(r);
                    }
                }
            }

        }

        return count == numCourses;
    }
}
