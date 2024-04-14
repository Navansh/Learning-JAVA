package Stack_Questions.Unsorted_Array.Pattern_1;

public class LC_1011_Capacity_to_Ship_Packages {
    public static void main(String[] args) {
        int[] weights = {3,2,2,4,1,4};
        System.out.println(days_Calculator(weights,6));
        System.out.println(shipWithinDays(weights,3));
    }

    public static int shipWithinDays(int[] weights, int days) {
        //firstly calculate the low and high for the BS
        int maxVal = Integer.MIN_VALUE;
        int sum = 0;

        for (int weight : weights) {
            maxVal = Math.max(maxVal, weight);
            sum += weight;
        }

        //hence low is
        int low = maxVal;
        int high = sum;
        int ans = 0;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            int req_days = days_Calculator(weights, mid);
            if(req_days <= days) {
                ans = mid;
                //go to left
                high = mid - 1;
            } else {
                //increase capacity as req days are greater than days, so
                //go to right
                low = mid + 1;
            }
        }

        return ans;
    }

    private static int days_Calculator(int[] weights, int mid) {
        //given mid as capacity, find out in how many days will all the weights be
        //fulfilled
        int bucket = 0;
        int days = 0;

        for (int i = 0; i < weights.length; i++) {
            if(weights[i] + bucket <= mid) {
                //add elements to this bucket
                bucket += weights[i];
            } else {
                bucket = weights[i];
                //start the bucket again with this
                days++;
            }
        }

        return days + 1;
        //+1 cz in the last whichever is left won't make days++ for itself in the else condition,
        //hence we add 1 here for that
    }
}
