package Questions_and_Concepts_of_Recursions;

public class Leetcode_1342_No_of_Steps {
    public static void main(String[] args) {

    }
    public int numberOfSteps(int num) {
        return helper(num,0);
    }

    public int helper(int num, int steps) {
        if (num==0)
        {
            return steps;
        }
        if (num%2==0)
        {
            return helper(num/2,steps+1);
        }
        return helper(num-1,steps+1);
    }
}
