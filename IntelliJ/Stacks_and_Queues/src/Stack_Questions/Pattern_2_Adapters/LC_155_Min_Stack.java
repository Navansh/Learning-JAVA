package Stack_Questions.Pattern_2_Adapters;

import java.util.Stack;

public class LC_155_Min_Stack {
    public static void main(String[] args) {
        MinStackOptimized mst = new MinStackOptimized();
        mst.push(-2);
        mst.push(0);
        mst.push(-1);
        System.out.println(mst.getMin());
        System.out.println(mst.top());
        mst.pop();
        System.out.println(mst.getMin());

    }


}

class MinStackOptimized {

    Stack<Long> stacker;
    //using Long as in LC there are some test cases which are just at the edge of
    //integer limit, hence adding or subtracting from them will result in overflow

    //here we won't use the min_stack and just by using a single variable still
    //achieve a min stack
    long min_ele;

    public MinStackOptimized() {
        stacker = new Stack<>();
        min_ele = Integer.MAX_VALUE;
    }

    public void push(int val) {
        if(stacker.isEmpty()) {
            //update the min ele and then push
            min_ele = val;
            stacker.push(0L);
            return;
        }

        long diff = val - min_ele;
        stacker.push(diff);
        //using this when the val is smaller than min_ele we will push
        //-ve values in the stack

        if(val < min_ele) {
            //then update the min ele
            min_ele = val;
        }

    }

    public void pop() {
        //here we'll handle the 2 cases of positive and negative number at top
        if(stacker.peek() >= 0) {
            //then just return the sum
            Long popped_ele = (stacker.pop());
            //no need to change the min ele
            //just return the sum
//            return (int) (popped_ele + min_ele);
            //here in the PS no need to return
            return;
        }

        //if its negative then min value would change
        Long popped_ele = stacker.pop();
        Long toreturn = min_ele;
        min_ele =  min_ele - popped_ele;

    }

    public int top() {
        if(stacker.peek() >= 0) {
            return (int) (stacker.peek() + min_ele);
        }

        return (int) min_ele;
    }

    public int getMin() {
        return (int) min_ele;
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
