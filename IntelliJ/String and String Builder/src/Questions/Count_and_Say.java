package Questions;

public class Count_and_Say {
    public static void main(String[] args) {
        //https://leetcode.com/problems/count-and-say/description/
        System.out.println(countAndSay(9));
    }

    public static String countAndSay(int n) {
        //get the n - 1th string and count and say it
        if(n == 1) {
            return "1";
        }

        //get the n - 1th string
        String toSay = countAndSay(n - 1);
        StringBuilder ans = new StringBuilder();


        for (int i = 0; i < toSay.length();i++ ) {
            int counter = 0;
            while (i + 1 <= toSay.length() - 1 && toSay.charAt(i) == toSay.charAt(i + 1)) {
                counter++;
                i++;
            }
            ans.append(counter + 1);
            ans.append(toSay.charAt(i));

        }

        return ans.toString();
    }


}
