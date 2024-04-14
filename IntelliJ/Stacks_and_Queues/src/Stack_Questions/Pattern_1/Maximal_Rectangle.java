package Stack_Questions.Pattern_1;

import java.util.Stack;

public class Maximal_Rectangle {
    public static void main(String[] args) {

    }

    public static int maximalRectangle(char[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        int[] arr = new int[m];
        //this will become our heights array for largest rectangle in histogram function
        //this will kinda act as a prefix Sum but col wise for every row
        int ans = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                //traversing the cell
                if(i == 0) {
                    arr[j] = matrix[i][j] - '0';
                    //converted the '1' to numeric 1
                } else {
                    //now we're creating heights for the following rows
                    if(matrix[i][j] == '1') {
                        arr[j] += 1;
                    } else {
                        //means there is 0 and as we encountered 0, means we
                        //can't create our rectangle here
                        arr[j] = 0;
                    }
                }
            }

            //now this create our height array for the ith row, now call the
            //largest rectangle in histogram function and calculate ans
            ans = Math.max(ans,largestRectangleAreaOptimized(arr));

        }

        return ans;
    }

    public static int largestRectangleAreaOptimized(int[] heights) {
        Stack<Integer> stacker = new Stack<>();
        int ans = 0;

        for (int i = 0; i <= heights.length; i++) {
            //this below condition will only solve for those numbers who have
            //their NSE on Right available otherwise the condition for while
            //wont hit

            //but those ele will still be in stack
            int temp = 0;
            if(i == heights.length) {
                //this will help us create NSE on right for the last ele too
                //(which is currently in the stack )
                //as 0 will always be smaller than that last ele value
                //hence our while loop will run

                //this will also solve for all the indexes that have no
                //nse on right available as it is histogram hence every value
                //will be positive hence 0 will be obviously be smaller than them
                //hence our while loop will run and take that ans too

                temp = 0;
            } else {
                temp = heights[i];
            }

            while (stacker.size() > 0 && temp < heights[stacker.peek()] ) {
                //essentially the condition for calculating the nse on Right side

                //ith index is gonna solve for our top most ele at the stack
                //ele refers to the ele whose index is stored at the stack
                //but that's interchangeable as index can be used to cal value

                //hence the element to be solved is at our top
                int element_to_be_solved = stacker.pop();
                int nseRight = i;
                int x1 = nseRight - 1;
                //as i is the index


                //nseLeft calc we have to catch the edge case of no element in the stack
                int nseLeft = -1;
                //by default case when stack has no element left
                if(!stacker.isEmpty()) {
                    nseLeft = stacker.peek();
                }
                int x2 = nseLeft + 1;

                int area = heights[element_to_be_solved] * ( x1 -x2 + 1);
                ans = Math.max(area, ans);
            }

            stacker.push(i);
        }

        return ans;
    }
}
