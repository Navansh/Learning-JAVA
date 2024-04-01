import java.util.Scanner;

public class Palindrome_or_not {
    public static void main(String[] args) {
        //
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the string to check");
        String check = sc.next();
        System.out.println(Checker(check));



    }
    public static boolean Checker(String check)
    {
        //first convert string to lower case
        check = check.toLowerCase();
        if (check ==null || check.isEmpty())
        {
            return true;
        }
        //Edge case
//        int start = 0;
//        int end = check.length()-1;
//        System.out.println(check.length());
//        while(start<=end)
//        {
//            if (check.charAt(start)==check.charAt(end))
//            {
//                start++;
//                end--;
//            }
//            else return false;
//        }
//        return true;

        //we can also use a for loop which goes to length of string/2
        for (int i = 0; i <= check.length()/2; i++) {
            char start = check.charAt(i);
            char end = check.charAt(check.length()-1-i);
            //subtracting i is very imp
            if (start!=end)
                return false;

        }
        return true;
        //as the whole for loop is traversed and no where it falsifies the condition
        //Time Complexity - O(n)

    }

}
