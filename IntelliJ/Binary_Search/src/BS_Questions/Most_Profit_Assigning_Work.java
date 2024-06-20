package BS_Questions;

import java.util.ArrayList;
import java.util.Arrays;

public class Most_Profit_Assigning_Work {
    public static void main(String[] args) {

    }

    class Pair {
        int difficulty;
        int profit;

        public Pair(int difficulty, int profit) {
            this.difficulty = difficulty;
            this.profit = profit;
        }
    }

    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        //we'll use Binary search and sort of prefixMax, to find out
        //TC: O(nlogn) sol
        //the ceiling difficulty level and associated max profit
        //till that difficulty level/index

        int n = difficulty.length;
        //and profit array have the same size
        int m = worker.length;

        Pair[] px = new Pair[difficulty.length];

        for (int i = 0; i < difficulty.length; i++) {
            px[i] = new Pair(difficulty[i], profit[i]);
        }

        //now sort on the basis of difficulty
        Arrays.sort(px, (p1, p2) -> Integer.compare(p1.difficulty, p2.difficulty));

        //now px is sorted according to min difficulty first
        
        //now we do pre-processing to find the max profit 
        //till a certain index

        for (int i = 1; i < px.length; i++) {
            px[i].profit = Math.max(px[i - 1].profit, px[i].profit);
        }

        //now we sort of have a prefixMax for profit also setup

        //now we apply Binary search
        int totalProfit = 0;

        for (int i = 0; i < m; i++) {
            //m - worker.length
            int workerLevel = worker[i];
            //now find equal difficulty or lower difficulty in the array
            //using BS

            int l = 0;
            int r = px.length - 1;
            int maxProfit = 0;

            while (l <= r) {
                int mid = l + (r-l)/2;
                if(px[mid].difficulty > workerLevel) {
                    //move left
                    r = mid - 1;
                } else if(px[mid].difficulty <= workerLevel) {
                    //one of the answers
                    //no alag equal ka a case, as that may
                    //sometimes not hit
                    //and worker ko less difficulty waala hi kaam
                    //karna pade
                    maxProfit = Math.max(maxProfit, px[mid].profit);
                    //now move right
                    l = mid + 1;
                }
            }

            totalProfit += maxProfit;

        }

        return totalProfit;
    }

    public int maxProfitAssignmentOptimized(int[] difficulty, int[] profit, int[] worker) {
        //O(NLogN+MLogM)
        int n = difficulty.length;
        //and profit array have the same size
        int m = worker.length;

        Pair[] px = new Pair[difficulty.length];

        for (int i = 0; i < difficulty.length; i++) {
            px[i] = new Pair(difficulty[i], profit[i]);
        }

        //now sort on the basis of difficulty
        Arrays.sort(px, (p1, p2) -> Integer.compare(p1.difficulty, p2.difficulty));

        //now px is sorted according to min difficulty first

        //now sort the worker array also
        Arrays.sort(worker);
        //O(nlogn)

        int totalProfit = 0;
        int j = 0;
        //for px array iteration

        //the concept is that now as the worker are sorted
        //and if the worker is able to pick up jth task
        //from the px array
        //then next worker which has capacity of taking
        //higher or equal difficulty level task
        //must be able to pickup atleast jth difficulty
        //task from the px array

        //we still maintain the maxProfit
        int maxProfit = 0;

        //O(m + n)
        //as har i ke liye poora iteration nhi ho rha, so
        //not multiplied
        //as j badh gya toh usko reset nhi kar rhe dubaara se
        for (int i = 0; i < m; i++) {
            while (j < n && worker[i] >= px[j].difficulty) {
                //then he can do astleast this work
                maxProfit = Math.max(maxProfit, px[j].profit);
                //array ko point karne ke liye j pointer use kar rhe
                j++;
            }

            //when we'll exit we should have maxProfit
            totalProfit += maxProfit;
        }


        return totalProfit;
    }
}
