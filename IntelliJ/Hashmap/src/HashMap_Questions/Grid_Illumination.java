package HashMap_Questions;

import java.util.HashMap;
import java.util.PriorityQueue;

public class Grid_Illumination {
    public static void main(String[] args) {
        //https://leetcode.com/problems/grid-illumination/
    }

    public int[] gridIllumination(int n, int[][] lamps, int[][] queries) {
        //return 1 if the query waala cell was illuminated and
        //0 if it was not illuminated

        //create 4 hashmaps to store the location of impacted areas
        //row wise
        HashMap<Integer, Integer> rowX = new HashMap<>();
        //colWise
        HashMap<Integer, Integer> colX = new HashMap<>();
        //diagonal top-left -> Bottom right
        HashMap<Integer, Integer> diaTL = new HashMap<>();
        //diagonal top- right - bottom left
        HashMap<Integer, Integer> diaTR = new HashMap<>();

        //now as the matrix length is in range of 2 * 10^4
        //hence n * n matrix may give MLE error, hence
        //we create a hashmap for storing all of the lamps
        //positions also
        HashMap<Integer, Integer> lPos = new HashMap<>();

        for (int i = 0; i < lamps.length; i++) {
            //position of the ith lamp
            int rowNo = lamps[i][0];
            int colNo = lamps[i][1];

            //now add these to HashMaps
            rowX.put(rowNo, rowX.getOrDefault(rowNo, 0) + 1);
            //meaning agar pehle se hoga toh freq badha do, otherwise 1 kardo
            colX.put(colNo, colX.getOrDefault(colNo, 0) + 1);

            //put in diagonals waale
            diaTL.put(rowNo - colNo, diaTL.getOrDefault(rowNo - colNo, 0) + 1);
            diaTR.put(rowNo + colNo, diaTR.getOrDefault(rowNo + colNo, 0) + 1);

            //store the cell itself, but in linear manner
            int linearIndex = rowNo * n + colNo;
            lPos.put(linearIndex, lPos.getOrDefault(linearIndex, 0) + 1);
            //maybe a position has 2 lamps
        }
        
        int[] ans = new int[queries.length];

        int[][] directions = {
                {-1, -1}, {-1, 0}, {-1, 1},
                {0,-1}, {0, 0}, {0, 1},
                {1, -1}, {1, 0}, {1, 1}
        };
        //this will be used to remove lamps in and around query

        for (int i = 0; i < queries.length; i++) {
            //now check if any of our hashmaps contain
            //the cell in their impacted region
            int rowNo = queries[i][0];
            int colNo = queries[i][1];

            if(rowX.getOrDefault(rowNo, 0) > 0 || colX.getOrDefault(colNo, 0) > 0 || diaTL.getOrDefault(rowNo - colNo, 0) > 0 || diaTR.getOrDefault(rowNo + colNo, 0) > 0 ) {
                //if any one these hashmaps impacts the cell above, then the answer is true
                ans[i] = 1;
            } else {
                ans[i] = 0;
            }

            //now we'll remove all the lamps in and around the query
            //lamps are removed even if the query ans is false or 0
            //as according to ques
            for (int j = 0; j < directions.length; j++) {
                int x = rowNo + directions[j][0];
                int y = colNo + directions[j][1];
                //jo bhi query solve kar rhe uske aas paas ke
                //saare connected cells ka address hai ye

                //hence check if they are out of bound
                if(x >= 0 && x < n && y >= 0 && y < n && lPos.containsKey(x*n + y)) {
                    //check if the given coordinate is in bound or not
                    //and secondly if it has lamp(s) or not
                    //as then only ye cell useful hai
                    //then remove all the lamp(s) at this cell
                    int times = lPos.get(x*n + y);
                    //x * n + y is the linear position for the 2d cell
                    //we first get how many lamps are present at that cell
                    //now do the reverse steps as we did while putting

                    //now remove the impact of the lamp placed at x and y
                    //and then remove all the lamps present at that index
                    rowX.put(x, rowX.getOrDefault(x, 0) - times);
                    colX.put(y, colX.getOrDefault(y, 0) - times);

                    diaTL.put(x - y, diaTL.getOrDefault(x - y, 0) - times);
                    diaTR.put(x + y, diaTR.getOrDefault(x + y, 0) - times);

                    int linearIndex = x * n + y;
                    lPos.remove(x * n + y);
                }
            }

        }

        return ans;

    }


}
