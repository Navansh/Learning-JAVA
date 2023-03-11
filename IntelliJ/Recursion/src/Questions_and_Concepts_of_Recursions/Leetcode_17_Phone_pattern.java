package Questions_and_Concepts_of_Recursions;

public class Leetcode_17_Phone_pattern {
    public static void main(String[] args) {
        Pad("","12");
    }
    static void Pad(String processed, String unprocessed){
        if (unprocessed.isEmpty())
        {
            System.out.println(processed);
            return;
        }

        int digit = unprocessed.charAt(0) -'0';
        //this will convert '2' to 2

        for (int i = (digit - 1)*3 ; i < (digit*3); i++) {
            char ch = (char)('a' + i);
            Pad(processed+ch,unprocessed.substring(1));
        }

    }
}
