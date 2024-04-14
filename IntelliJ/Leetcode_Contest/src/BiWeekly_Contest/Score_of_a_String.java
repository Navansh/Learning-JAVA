package BiWeekly_Contest;

public class Score_of_a_String {
    public static void main(String[] args) {
        String s= "hello";
        System.out.println(scoreOfString(s));
    }

    public static int scoreOfString(String s) {
        //calculate prefix difference then take the total of the array
        char[] arr = s.toCharArray();
        int[] prefixDifference = new int[arr.length];

        for(int i = 0; i < arr.length - 1; i++) {
            int difference = arr[i] - arr[i + 1];
            prefixDifference[i] = Math.abs(difference);
        }

        int sum = 0;
        for (int i = 0; i < prefixDifference.length - 1; i++) {
            sum += prefixDifference[i];
        }

        return sum;

    }
}
