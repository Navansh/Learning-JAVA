package Stack_Questions;

import java.util.Stack;

public class LC_84_LargestArHistogram {
    public static void main(String[] args) {

    }

    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int max_Area = 0;

        //stack will contain all the increasing order items
        stack.push(0);

        for (int i = 1; i < heights.length; i++) {
            while(!stack.isEmpty() && heights[i] < heights[stack.peek()]) {
                max_Area = getMax(heights, stack, max_Area, i);
            }

            stack.push(i);
        }

        int i = heights.length;
        while (!stack.isEmpty()) {
            max_Area = getMax(heights, stack, max_Area, i);
        }

        return max_Area;
    }

    private static int getMax(int[] heights, Stack<Integer> stack, int maxArea, int i) {
        int area;
        int popped = stack.pop();
        if(stack.isEmpty()) {
            area = heights[popped] * i;
        } else {
            area = heights[popped] * (i - 1 - stack.peek());
        }

        return Math.max(maxArea, area);
    }

    public int largestRectangleAreaBruteforce(int[] heights) {
        //main Idea :
        //for a particular index, find the left and right boundary for it and
        // then find the enclosing area

        return -1;

    }
}
