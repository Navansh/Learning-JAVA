package Stack_Questions;

import java.util.Stack;

public class LC_155_Min_Stack {
    public static void main(String[] args) {

    }


}

class MinStack {

    Stack<Integer> stacker;
    Stack<Integer> min_Stack;

    public MinStack() {
        stacker = new Stack<>();
        min_Stack = new Stack<>();
    }

    public void push(int val) {
        //whenever pushing ele to the mainStack also update the min ele for min_Stack
        stacker.push(val);
        if(min_Stack.isEmpty()) {
            min_Stack.push(val);
        } else {
            min_Stack.push(Math.min(stacker.peek(), min_Stack.peek()));
        }
    }

    public void pop() {
        //pop from both
        stacker.pop();
        min_Stack.pop();
    }

    public int top() {
        return stacker.peek();
    }

    public int getMin() {
        return min_Stack.peek();
    }
}
