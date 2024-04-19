package Stack_Questions.Pattern_2_Adapters;

import java.util.Stack;

public class LC_232 {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();

    }
}

class QueueUsingStack {
    //we are making Insert Efficient
    private Stack<Integer> first;
    private Stack<Integer> second;
    //constructor


    public QueueUsingStack() {
        first = new Stack<>();
        second = new Stack<>();
    }

    public void push(int x) {
        //just push directly in the first stack
        first.push(x);
    }

    public int pop() throws Exception {
        //cannot pop is first is empty
        if(first.isEmpty()) {
            throw new Exception("Cannot pop");
        }

        //empty first into second
        while(!first.isEmpty()) {
            second.push(first.pop());
        }
        //remove the item
        int removed_item = second.pop();

        //empty second into first
        while(!second.isEmpty()) {
            first.push(second.pop());
        }
        return removed_item;
    }

    public boolean empty() {
        return first.isEmpty();
    }

    public int peek() throws Exception{
        //returns the element at the front of the queue
        //transfer into second, then peek
        if(first.isEmpty()) {
            throw new Exception("Cannot peek");
        }

        //empty first into second
        while(!first.isEmpty()) {
            second.push(first.pop());
        }

        int peek_item = second.peek();
        while(!second.isEmpty()) {
            first.push(second.pop());
        }
        return peek_item;
    }
}

class QueueUsingStackRemoveEfficient {
    //this is remove efficient, meaning removal takes O(1) time

    private Stack<Integer> A;
    private Stack<Integer> B;

    public QueueUsingStackRemoveEfficient() {
        A = new Stack<>();
        B = new Stack<>();
    }

    public void push(int x) {
        //while pushing first move the items in A to B
        while(!A.isEmpty()) {
            B.push(A.pop());
        }

        A.push(x);
        //now move the items back to A from B
        while(!B.isEmpty()) {
            A.push(B.pop());
        }
    }

    public int pop() throws Exception {
        if(A.isEmpty()) {
            throw new Exception("Cannot pop from empty Queue");
        }

        int popped_item = A.pop();
        return popped_item;
    }

    public int peek() throws Exception {
        if(A.isEmpty()) {
            throw new Exception("Cannot pop from empty Queue");
        }

        return A.peek();
    }

    public boolean isEmpty() {
        return A.isEmpty();
    }
}
