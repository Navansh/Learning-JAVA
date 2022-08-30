import org.w3c.dom.ls.LSOutput;

public class Prob_1295_arrays_easy_Leetcode
{
    public static void main(String[] args) {
        int[] nums = {555,901,482,1771};
        System.out.println(findNumbers(nums));
        
        
    }

    static int findNumbers(int[] nums)
    {
            int pika =0;

        for (int num : nums) {
            int number = num;

            int digit = 0;
//            while (number > 0) {
//                digit++;
//                number = number / 10;
//            }
            digit = (int) Math.log10(number) + 1 ;
            if (digit % 2 == 0) {
                pika++;
            }
        }
        return pika;
    }

}
