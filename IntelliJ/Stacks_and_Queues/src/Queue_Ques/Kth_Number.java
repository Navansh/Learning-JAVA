package Queue_Ques;

import java.util.LinkedList;
import java.util.Queue;

public class Kth_Number {
    public static void main(String[] args) {
        //Given K, Print the Kth Number in the increasing series of number using digits 1 and 2 only.

    }

    public static String kth(int k){
        Queue<String> q = new LinkedList<>();
        q.add("1");
        q.add("2");

        String ans = "";
        for(int i=0;i<k;i++){
            String temp = q.remove();
            ans = temp;
            q.add(temp+"1");
            q.add(temp+"2");
        }

        return ans;
    }

    public static String palindromeKthNumber(int k) {
        Queue<String> q = new LinkedList<>();

        q.add("11");
        q.add("22");

        String ans = "";

        for(int i=1;i<=k;i++){
            String temp = q.remove();
            ans = temp;
            String left = temp.substring(0,temp.length()/2);
            String right = temp.substring(temp.length()/2,temp.length());

            q.add(left+"11"+right);
            q.add(left+"22"+right);
            //adding in between will create even palindromes directly and
            //will create in sorted order

            //unlike adding in end, which will create in unsorted order

        }

        return ans;

    }



}
