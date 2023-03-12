package Backtracking;

import java.util.Arrays;

public class Maze_All_Paths {
    public static void main(String[] args) {
        boolean[][] arr = {
                {true,true,true},
                {true,true,true},
                {true,true,true}
        };
        int[][] path = new int[arr.length][arr[0].length];

//        pathwithAll("",arr,0,0);
        pathwithAllPrint("",arr,0,0,path,1);
        //initially step starts with 1
    }
    static void pathwithAll(String processed,boolean[][] maze,int row,int column){

        //this method is slightly different from other method disc prviously, as there we started from 3,3 and target
        // was (0,0), but here we start from (0,0) and target is (3,3) and hence we move (row + 1) and (col + 1)
        if (row == maze.length -1 && column == maze[0].length - 1 ){
            //because as this is a boolean matrix so we can't just simply put r ==1 and c==1, so we just compare it
            //to the co-ordinates of the last cell in the matrix
            System.out.println(processed);
            return;
        }
        //for obstacle
        if (!maze[row][column]){
            //means when it is false(which is the obstacle), so by (!) it becomes true, hence we just return from there
            return;
        }

        //hence after it has passed the above condition, I am considering this block in my path, so I set it as false
        //means visited
        maze[row][column] = false;


        if (row < maze.length -1){
            //again cz we don't have integer passed in, so we just compare it with the length, and we can move Down
            // until it hasn't reached the final block, and it will reached when row is < 2(for a 3x3 matrix)
            // , means at most 1, cz
//            in the inside function call we are passing row + 1, so we know it has moved from 1 to 2(for a 3x3 matrix)
//            , which is its last position
            pathwithAll(processed+'D',maze,row+1,column);
        }
        if (column < maze[0].length - 1 ){
            //same explaination as given to row
            pathwithAll(processed+'R', maze , row,column+1);
        }
        if (row>0){
            //same explaination as given to row
            pathwithAll(processed+'U', maze , row-1,column);
        }
        if (column>0){
            //same explaination as given to row
            pathwithAll(processed+'L', maze , row,column-1);
        }

        //this line will execute at the returning of this function call
        //so before the function gets removed also remove the changes that were made in this function call
        maze[row][column] = true ;

    }
    static void pathwithAllPrint(String processed,boolean[][] maze,int row,int column,int[][] path, int step){

        //this method is slightly different from other method disc prviously, as there we started from 3,3 and target
        // was (0,0), but here we start from (0,0) and target is (3,3) and hence we move (row + 1) and (col + 1)
        if (row == maze.length -1 && column == maze[0].length - 1 ){
            //and because we want to print the path so when we reach this condition(ie ans condition), print the array
            //of the steps that the function took to reach here
            path[row][column] = step;
            //as this last step is also a step
            for (int[] arr:path) {
                System.out.println(Arrays.toString(arr));
            }
            System.out.println(processed);
            System.out.println();
            return;
        }
        //for obstacle
        if (!maze[row][column]){
            //means when it is false(which is the obstacle), so by (!) it becomes true, hence we just return from there
            return;
        }

        //hence after it has passed the above condition, I am considering this block in my path, so I set it as false
        //means visited
        maze[row][column] = false;
        path[row][column] = step;
        //path is currently the step at which you are right now

        if (row < maze.length -1){
            //again cz we don't have integer passed in, so we just compare it with the length, and we can move Down
            // until it hasn't reached the final block, and it will reached when row is < 2(for a 3x3 matrix)
            // , means at most 1, cz
//            in the inside function call we are passing row + 1, so we know it has moved from 1 to 2(for a 3x3 matrix)
//            , which is its last position
            pathwithAllPrint(processed+'D',maze,row+1,column,path,step+1);
            //with every function call the step is increasing
        }
        if (column < maze[0].length - 1 ){
            //same explaination as given to row
            pathwithAllPrint(processed+'R', maze , row,column+1,path,step+1);
            //with every function call the step is increasing

        }
        if (row>0){
            //same explaination as given to row
            pathwithAllPrint(processed+'U', maze , row-1,column,path,step+1);
            //with every function call the step is increasing

        }
        if (column>0){
            //same explaination as given to row
            pathwithAllPrint(processed+'L', maze , row,column-1,path,step+1);
            //with every function call the step is increasing

        }

        //this line will execute at the returning of this function call
        //so before the function gets removed also remove the changes that were made in this function call
        maze[row][column] = true ;
//        and when we backtrack we put it in its original value that is 0
        path[row][column] = 0;
    }
}
