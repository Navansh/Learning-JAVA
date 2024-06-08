package Maths;

import java.util.ArrayList;

public class Factors
{
    public static void main(String[] args) {
        FactorCalc2(20);
    }

    static void FactorCalc(int n)
    {             //O(sqrt(n))
        for (int i = 1; i < Math.sqrt(n); i++) {
            if (n%i==0)
            {
                //but there may be case when both i and n/i will be same like 6 & 6 for 36
                if (i == n/i)
                {
                    System.out.print(i+" ");
                }
                else {
                    System.out.print(i + " " + n / i+" ");
                }
                //as if one factor is i then other factor would n/i
                //hence in single iteration we are able to find 2 factors
            }
        }
        //but the output from this is not in sorted manner
    }
    static void FactorCalc2(int n)
    {
        //but the output from this is in sorted manner
        //hence we store the n/i wale factors in a separate arraylist as they appear
        //descending sorted

        //hence the time and space complexity will be now O(sqrt(n)) as now we are storing some elements in a different
        // array
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 1; i < Math.sqrt(n); i++) {
            if (n%i==0)
            {
                //but there may be case when both i and n/i will be same like 6 & 6 for 36
                if (i == n/i)
                {
                    System.out.print(i+" ");
                }
                else {
                    System.out.print(i+" ");
                    list.add(n/i);
                }
                //as if one factor is i then other factor would n/i
                //hence in single iteration we are able to find 2 factors

                //now just print the Arraylist from last or reverse order
            }
        }
        for (int j = list.size() - 1; j >= 0 ; j--) {
            System.out.print(list.get(j) + " ");
        }
    }
}
