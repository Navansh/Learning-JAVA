package Recursion;

public class L779 {
    public static void main(String[] args) {
//        String nthRow = helper("", "0",3);
        //this won't fetch the result as it will go exponentially

        System.out.println(helperTwo("", "0", 30));
    }
    public int kthGrammar(int n, int k) {
        String next_row = "";
        String curr_row = "0";
        String nthRow = helper(next_row, curr_row, n);
        return 1;
    }

    public static String helper(String next_row, String curr_row, int n){
        if(n == 1){
            return curr_row;
        }
        String unprocessed = curr_row;
        StringBuilder processed = new StringBuilder();

        while(unprocessed.length() > 0){
            if(unprocessed.charAt(0) == '0'){
                processed.append("01");
            } else {
                processed.append("10");
            }
            unprocessed = unprocessed.substring(1);
        }
        int nextt = n - 1;

        return helper("", processed.toString(),nextt);

    }
    public static String flipper(String binaryNumber) {

        StringBuilder flippedNumber = new StringBuilder();

        for (int i = 0; i < binaryNumber.length(); i++) {
            char bit = binaryNumber.charAt(i);
            if (bit == '0') {
                flippedNumber.append('1');
            } else if (bit == '1') {
                flippedNumber.append('0');
            } else {
                // Handle any other characters if needed
                flippedNumber.append(bit);
            }
        }

        return flippedNumber.toString();
    }

    public static String flipperTwo(String binaryNumber) {

        int length = binaryNumber.length();

        double mask = (1 << length) - 1; // Create a mask with all 1s based on the input length

        double originalNumber = Double.parseDouble(binaryNumber + '0');
        double flippedNumber = originalNumber ^ mask;

        return Integer.toBinaryString(flippedNumber);
    }

    public static String flipperThree(String binaryNumber){
        int length = binaryNumber.length();

        // Create a mask with all 1s based on the input length
        String maskString = "1".repeat(length);
        int mask = Integer.parseInt(maskString);

        int flippedNumber = Integer.parseInt(binaryNumber) ^ mask;

        return Integer.toBinaryString(flippedNumber);
    }

    public static String helperTwo(String next_row, String curr_row, int n){
        if(n == 1){
            return curr_row;
        }
        String unprocessed = curr_row;
        String flippedNumber = flipperThree(unprocessed);
        String processed = unprocessed + flippedNumber;

        int nextt = n - 1;

        return helperTwo("", processed,nextt);

    }
}


