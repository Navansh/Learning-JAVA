package Questions;

import java.util.LinkedList;
import java.util.Queue;

class Pair {
    int i;
    int j;
    int t;

    public Pair(int i, int j, int t) {
        this.i = i;
        this.j = j;
        this.t = t;
    }
}

public class Rotting_Oranges {
    public static void main(String[] args) {
        int[][] grid = {
                {1},
                {2}};
        System.out.println(orangesRotting(grid));
    }

    public static int orangesRotting(int[][] grid) {
        Queue<Pair> q = new LinkedList<>();
        
        //find the initally rotten oranges and add them to the queue
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if(grid[i][j] == 2) {
                    //means its rotten, add it to the queue
                    Pair cell = new Pair(i,j,0);
                    q.add(cell);
                }
            }
        }

        //here our actual bfs concept starts
        int ansTime = 0;
        while(q.size() > 0) {
            Pair removed = q.remove();
            int current_row = removed.i;
            int current_col = removed.j;
            int current_time = removed.t;
            ansTime = current_time;

            //now we know for a removed cell we always need to check
            //Top, bottom, left and right

            //checking if top has a good orange, if yes then rot it
            if(current_row - 1 >= 0 && grid[current_row - 1][current_col] == 1) {
                //add it to queue and mark it as 2
                q.add(new Pair(current_row - 1, current_col, current_time + 1));
                grid[current_row - 1][current_col] = 2;
            }

            //for the left side
            if(current_col - 1 >= 0 && grid[current_row][current_col - 1] == 1) {
                //add it to queue and mark it as 2
                q.add(new Pair(current_row, current_col - 1, current_time + 1));
                grid[current_row][current_col - 1] = 2;
            }

            //for the right
            if(current_col + 1 < grid[current_row].length && grid[current_row][current_col + 1] == 1) {
                //add it to queue and mark it as 2
                q.add(new Pair(current_row, current_col + 1, current_time + 1));
                grid[current_row][current_col + 1] = 2;
            }

            //for the bottom
            if(current_row + 1 < grid.length && grid[current_row + 1][current_col] == 1) {
                //add it to queue and mark it as 2
                q.add(new Pair(current_row + 1, current_col, current_time + 1));
                grid[current_row + 1][current_col] = 2;
            }
        }

        //check if ye sab karne ke baad koi 1( fresh orange ) bachaa hai kya
        for (int[] ints : grid) {
            for (int anInt : ints) {
                if (anInt == 1) {
                    //means its rotten, add it to the queue
                    return -1;
                }
            }
        }

        return ansTime;
        //not ansTime + 1, as jab last Pair( ele) remove hoga, toh uske baad kuch add
        //nhi hoga to the grid ( as in koi condition satisfy hi nhi kar rha hogaa
        // add hone waali)
    }
}
