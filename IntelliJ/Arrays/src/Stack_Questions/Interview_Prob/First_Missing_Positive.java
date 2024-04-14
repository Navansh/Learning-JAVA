package Stack_Questions.Interview_Prob;

public class First_Missing_Positive {
    public static void main(String[] args) {

    }

    public int firstMissingPositive(int[] nums) {
        //we have to do 2 processes :
        //1st : put the elements into their correct positions
        //2nd : check which element is not in its correct position and that will be
        //our answer

        //1st :
        int i = 0;
        int n = nums.length;

        while (i < n) {
            if(nums[i] < 1 || nums[i] > n || i == nums[i] - 1) {
                i++;
            } else {
                //put that element into its correct place
                int current_index = i;
                int correct_index = nums[i] - 1;

                if(nums[current_index] == nums[correct_index]) {
                    i++;
                    //move forward as this will result in an infinite loop
                } else {
                    int temp = nums[i];
                    nums[i] = nums[correct_index];
                    nums[correct_index] = temp;
                }
            }
        }

        //2nd Step :

        for(int j = 0; j < nums.length; j++) {
            if(j == nums[j] - 1) {
                continue;
            } else {
                return j + 1;
            }
        }

        return -1;

    }
}
