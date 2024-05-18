package Queue_Ques;

import java.util.Stack;

public class Queue_using_Stacks {
    public static void main(String[] args) {

    }

    private class Remove_Efficient {
        //Push -> O(N)
        //Pop -> O(1)

        Stack<Integer> s1 = new Stack<Integer>();
        Stack<Integer> s2 = new Stack<Integer>();

        void push(int x)
        {
            // Move all elements from s1 to s2
            while (!s1.isEmpty())
            {
                s2.push(s1.pop());
                //s1.pop();
            }

            // Push item into s1
            s1.push(x);

            // Push everything back to s1
            while (!s2.isEmpty())
            {
                s1.push(s2.pop());
                //s2.pop();
            }
        }

        // Dequeue an item from the queue
        int pop()
        {
            // if first stack is empty
            if (s1.isEmpty())
            {
                return -1;
            }

            // Return top of s1
            int x = s1.peek();
            s1.pop();
            return x;
        }

    }

    private class Insert_Efficient {
        Stack<Integer> s1 = new Stack<Integer>();
        Stack<Integer> s2 = new Stack<Integer>();

        //Function to push an element in queue by using 2 stacks.
        void Push(int x){
            // Your code here
            s1.push(x);
        }


        //Function to pop an element from queue by using 2 stacks.
        int Pop()
        {
            if(s1.size() == 0){
                return -1;
            }
            // Your code here
            int n = s1.size();
            for(int i=1;i<=n-1;i++){
                s2.push(s1.pop());
            }

            int ans = s1.pop();

            for(int i=1;i<=n-1;i++){
                s1.push(s2.pop());
            }

            return ans;
        }
    }

}


