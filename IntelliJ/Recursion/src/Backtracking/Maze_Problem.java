package Backtracking;

import java.util.ArrayList;

public class Maze_Problem {
    public static void main(String[] args) {
        //this gives in o/p the no of ways we can go from the point a(3,3) to b(0,0) in a 3x3 Maze
//        System.out.println(pathReturn("",3,3));
//        System.out.println(pathReturnDiagonal("",3,3));
        boolean[][] arr = {
                {true,true,true},
                {true,false,true},
                {true,true,true}
        };
        pathwithObstacles("",arr,0,0);
    }
    static int count(int r,int c){
        if (r==1 || c ==1 ){
            return 1;
        }

        int left = count(r-1,c);
        int right = count(r,c-1);

        return (left + right);
    }
    static void path(String processed,int row,int column){
        if (row==1 && column ==1){
            System.out.println(processed);
            return;
        }
        if (row>1){
            path(processed+'D',row-1,column);
        }
        if (column>1){
            path(processed+'R',row,column-1);
        }

    }
    static ArrayList<String> pathReturn(String processed, int row, int column){
        if (row==1 && column ==1 ){
            ArrayList<String> list = new ArrayList<>();
            //this list is created for making individual lists of each answer
            list.add(processed);
            return list;
        }

        ArrayList<String> ans = new ArrayList<>();
        //for creating bucket/collection of lists
        if (row>1){
            ans.addAll(pathReturn(processed+'D',row-1,column));
        }
        if (column>1){
            ans.addAll(pathReturn(processed+'R',row,column-1));
        }
        return ans;
    }
    static ArrayList<String> pathReturnDiagonal(String processed, int row, int column){
        //in this problem we also consider the diagonal movement, so here we consider Vertical(for down),
        //Horizontal(for right), and Diagonal(for diagonal down)
        if (row==1 && column ==1 ){
            ArrayList<String> list = new ArrayList<>();
            //this list is created for making individual lists of each answer
            list.add(processed);
            return list;
        }

        ArrayList<String> ans = new ArrayList<>();
        //for creating bucket/collection of lists
        if (row>1&&column>1){
            ans.addAll(pathReturnDiagonal(processed+'D',row-1,column-1));
        }
        if (row>1){
            ans.addAll(pathReturnDiagonal(processed+'V',row-1,column));
        }
        if (column>1){
            ans.addAll(pathReturnDiagonal(processed+'H',row,column-1));
        }
        return ans;
    }
    static void pathwithObstacles(String processed,boolean[][] maze,int row,int column){
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

        if (row < maze.length -1){
            //again cz we don't have integer passed in, so we just compare it with the length, and we can move Down
            // until it hasn't reached the final block, and it will reached when row is < 2(for a 3x3 matrix)
            // , means at most 1, cz
//            in the inside function call we are passing row + 1, so we know it has moved from 1 to 2(for a 3x3 matrix)
//            , which is its last position
            pathwithObstacles(processed+'D',maze,row+1,column);
        }
        if (column < maze[0].length - 1 ){
            //same explaination as given to row
            pathwithObstacles(processed+'R', maze , row,column+1);
        }

    }
    static void pathwithAll(String processed,boolean[][] maze,int row,int column){

        //this method won't find answer, detailed explanation in Notebook#2





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

    }
}
