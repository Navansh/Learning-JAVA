package BS_Questions.Unsorted_Array.Pattern_1;

public class The_Painters_Partition_Problem {
    public static void main(String[] args) {
        //https://www.geeksforgeeks.org/problems/the-painters-partition-problem1535/1
        int[] arr = {5,10,30,20,15};
        System.out.println(minTime(arr,arr.length,3));
    }

    static long minTime(int[] arr,int n,int k){
        //firstly calculate the low and the high values for the problem
        long smallest_time = Integer.MIN_VALUE;
        long max_time = 0;

        for (int i = 0; i < arr.length; i++) {
            smallest_time = Math.max(smallest_time, arr[i]);
            max_time += arr[i];
        }

        //now we do binary search on this
        long low = smallest_time;
        long high = max_time;
        long ans = 0;

        while (low <= high) {
            long mid = low + (high - low) / 2;
            //our mid here represents the time

            //now calculate the time in which work can be done
            long workers_taken = time_Calculator(arr, mid);

            if(workers_taken <= k) {
                ans = mid;
                //we store this as an valid answer

                //which means we are allocating a lot of time
                //hence we reduce that, as given to do in the prob
                //by doing this we increase the no of workers req and we can do that
                //as our goal is to come up with min possible time until workers
                //don't exceed k
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return ans;
    }

    public static long time_Calculator(int[] time_taken_arr, long mid) {
        //time_taken_arr represents the time taken to complete the ith task
        //say given time is mid and we in how many workers can we complete this

        long workers = 0;
        long bucket = 0;

        for (int i = 0; i < time_taken_arr.length; i++) {
            if(time_taken_arr[i] + bucket <= mid) {
                bucket += time_taken_arr[i];
            } else {
                workers++;
                bucket = time_taken_arr[i];
            }
        }

        return workers + 1;
    }
}
