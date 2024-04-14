package Stack_Questions.SubArrays;

public class SumofAllSubarrays {
    public static void main(String[] args) {
//        Approach 1 :
        //Use the prefixSum technique and calculate the overall sum
        //TC : O(N^2)

//        Approach 2 :
        //we can do this in linear time

    }

    public static int sumofAllSubarrays(int[] arr) {
        //here we use the Contribution Technique
        //we calculate the total occurance of each element in the arr
        //and then multiply the element to it and finally take the sum

        int sum = 0;

        for (int i = 0; i < arr.length; i++) {
            int occurance = (i + 1)*(arr.length - i);
            sum += occurance * arr[i];
        }

        return sum;
    }


}
