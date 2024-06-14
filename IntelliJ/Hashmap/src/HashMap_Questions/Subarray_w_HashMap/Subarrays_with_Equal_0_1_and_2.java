package HashMap_Questions.Subarray_w_HashMap;

import java.util.HashMap;

public class Subarrays_with_Equal_0_1_and_2 {
    public static void main(String[] args) {

    }

    long getSubstringWithEqual012(String str) {
        // code here
        HashMap<String, Integer> hx = new HashMap<>();
        //because now we'll be comparing 2 differences,
        //so we'll do that with string
        hx.put("0@0", 1);
        int ans = 0;
        
        int prefixCZero = 0;
        int prefixCountOne = 0;
        int prefixCountTwo = 0;

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if(ch - '0' == 0) {
                //then its zero :
                prefixCZero++;
            }

            if (ch - '1' == 0) {
                prefixCountOne++;
            }

            if(ch - '2' == 0) {
                prefixCountTwo++;
            }

            int diff1 = prefixCZero - prefixCountOne;
            int diff2 = prefixCZero - prefixCountTwo;

            String toLookFor = Integer.toString(diff1) + '@' + Integer.toString(diff2);

            //using "@" is necessary as then 12 and 1, & 1 ,and 21
            //will combine in same way and will give wrong results
            //when we search for them
            if(hx.containsKey(toLookFor)) {
                ans += hx.getOrDefault(toLookFor, 0);
            }

            //now put this in the hashMap to be used for later
            //subarrays as a starting point

            hx.put(toLookFor, hx.getOrDefault(toLookFor, 0) + 1);
        }

        return ans;
    }
}
