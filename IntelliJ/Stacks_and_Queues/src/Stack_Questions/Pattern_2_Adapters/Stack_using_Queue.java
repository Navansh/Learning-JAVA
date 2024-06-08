package Stack_Questions.Pattern_2_Adapters;

import java.util.LinkedList;
import java.util.Queue;

public class Stack_using_Queue {
    public static void main(String[] args) {

    }

    class MyStack {
        Queue<Integer> q = new LinkedList<>();
        public MyStack() {
        }
        public void push(int x) {
            q.add(x);
        }
        public int pop() {
            int n = q.size();
            for(int i=1;i<=n-1;i++){
                q.add(q.remove());
            }


            return q.remove();
        }
        public int top() {
            int n = q.size();
            for(int i=1;i<=n-1;i++){
                q.add(q.remove());
            }


            int ans = q.peek();
            q.add(q.remove());
            return ans;
        }
        public boolean empty() {
            return q.size() == 0;
        }
    }

}
