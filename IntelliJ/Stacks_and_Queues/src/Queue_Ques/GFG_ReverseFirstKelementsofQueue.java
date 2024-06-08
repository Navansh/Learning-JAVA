package Queue_Ques;

import java.util.*;

public class GFG_ReverseFirstKelementsofQueue {
    public static void main(String[] args) {
        Queue<Integer> queuer = new LinkedList<>();
    }

    public static Queue<Integer> modifyQueue(Queue<Integer> q, int k) {
        //first take out the k elements from the queue and put them into a stack
        Stack<Integer> stacker = new Stack<>();

        for(int i = 0; i < k; i++) {
            stacker.push(q.remove());
        }

        //put that element again into the OG Queue
        for(int i = 0; i < k; i++) {
            q.add(stacker.pop());
        }

        //now remove the first n - k elements from the queue and put them again
        //in the queue

        for(int i = 0; i < q.size() - k; i++) {
            q.add(q.remove());
        }

        return q;
    }
}
