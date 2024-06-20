package BS_Questions;

public class Median_of_2_Sorted_Arrays {
    public static void main(String[] args) {
        //https://leetcode.com/problems/median-of-two-sorted-arrays/

    }

    public static double findMedianSortedArrays(int[] a, int[] b) {
        int n1 = a.length;
        int n2 = b.length;

        //by default we have made the algo assuming that n1 < n2, if that's not
        //this helps in definitively find the index m2 for b
        //otherwise for normal case we'll have to write many conditions



        //the case then
        if(n1 > n2) {
            return findMedianSortedArrays(b,a);
        }

        int lo = 0;
        int hi = a.length;
        //not a.length - 1, as we ham mid ke ek pehle element ko hi include karte hai
        //and also by default we've assumed that length position par infinite value hai
        //and -1 index par -ve infinite

        int total_elements = n1 + n2;

        while (lo <= hi) {
            int mid1 = lo + (hi - lo)/ 2;
            int mid2 = (total_elements + 1) / 2 - mid1;
            //this will give correct m2 when total_elements are even
            //and will give one extra on left side when total_elements are odd

            //now we'll calculate all the stuff that is required for us
            //to make the decision

            int a_mid_value = mid1 == a.length ? Integer.MAX_VALUE : a[mid1];
            //if mid1 goes to 0 we don't have problem

            int a_mid_minus_one_value = mid1 == 0 ? Integer.MIN_VALUE : a[mid1 - 1];

            int b_mid_value = mid2 == b.length ? Integer.MAX_VALUE : b[mid2];

            int b_mid_minus_one_value = mid2 == 0 ? Integer.MIN_VALUE : b[mid2 - 1];

            if(a_mid_minus_one_value <= b_mid_value && b_mid_minus_one_value <= a_mid_value) {
                //hence we've found an appropriate partition
                //note that we use 2 pointers (mid1 and mid2 ) for odd length combined arr also
                if(total_elements % 2 == 0) {
                    double left_max = Math.max(a_mid_minus_one_value, b_mid_minus_one_value);
                    double right_min = Math.min(a_mid_value, b_mid_value);

                    return (left_max + right_min) / 2;
                } else {
                    //this is the odd total length case
                    //and as we already have more ele on left hand side
                    //hence we just return left max
                    return Math.max(a_mid_minus_one_value, b_mid_minus_one_value);
                } 
            } else if (a_mid_minus_one_value > b_mid_value) {
                //means this condition became true
                //which made us drop from the above if statement

                hi = mid1 - 1;
                //as a's value is bigger so lower mid value
                //this will also inturn decrease the contribution of a's elements
                //for this side (smaller than side )
            } else if (b_mid_minus_one_value > a_mid_value) {
                lo = mid1 + 1;
            }

        }

        return 0.0;

    }

}
