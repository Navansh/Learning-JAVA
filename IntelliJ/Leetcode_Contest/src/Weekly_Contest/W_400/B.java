package Weekly_Contest.W_400;

import java.util.Arrays;

public class B {
    public static void main(String[] args) {

    }

    public int countDays(int days, int[][] meetings) {
        //sort the meeting 2D array on the basis of first index of each 1D array
        //so we'll use Lambda function
        Arrays.sort(meetings, (a,b) -> Integer.compare(a[0], b[0]));
        int ans = 0;
        ans = meetings[0][0] - 1;
        //as meetings day 1 se start ho rhi hai and as ye meetings array sorted
        //bhi hai, toh ye joh difference agar day1 se late chalu ho rhi hai
        //toh ans mein include ho jayega

        int prev_end = meetings[0][1];

        for (int i = 1; i < meetings.length; i++) {
            if(meetings[i][0] <= prev_end) {
                //then these could merge to form a bigger event
            } else {
                //their difference will be added to the ans
                ans += meetings[i][0] - prev_end - 1;
            }
            prev_end = Math.max(prev_end, meetings[i][1]);
            //as hamaara prev end ye show karta hai ki kitni index last
            //tak cover ho chuki hai in total, toh agar pehle ki koi index
            //jyada cover kar chuki hai then ham wohi consider karenge
        }

        //now after all this is over, we need to subtract the prev_end
        //with the max days, maanlo saare cover hi nhi hue ho toh
        ans += days - prev_end;

        return ans;
    }
}
