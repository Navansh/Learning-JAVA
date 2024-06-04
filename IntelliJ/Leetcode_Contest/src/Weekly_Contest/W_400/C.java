package Weekly_Contest.W_400;

import BiWeekly_Contest.Contest_131.A;

import java.awt.image.AreaAveragingScaleFilter;
import java.util.ArrayList;
import java.util.List;

public class C {
    public static void main(String[] args) {

    }

    public String clearStars(String s) {
        List<List<Integer>> lx = new ArrayList<>();
        //add 26 arraylists into lx
        for (int i = 0; i < 26; i++) {
            ArrayList<Integer> temp = new ArrayList<>();
            lx.add(temp);
        }

        int n = s.length();
        boolean[] marked = new boolean[n];
        //those all characters we'll end up using to delete '*', we'll mark them as true
        //and in the last while we're forming the output string we'll not include it

        char[] str = s.toCharArray();
        StringBuilder sx = new StringBuilder();

        for (int i = 0; i < str.length; i++) {
            if(str[i] != '*') {
                //then add it to the index arr
                lx.get(str[i] - 'a').add(i);
            } else {
                //we got '*'
                marked[i] = true;
                //now we find the lexicographically smallest character to remove
                //to delete the '*'
                for (int j = 0; j < 26; j++) {
                    if(!lx.get(j).isEmpty()) {
                        //then that character is available
                        //so first get the index of that char
                        List<Integer> temp = lx.get(j);
                        int index = temp.get(temp.size() - 1);
                        marked[index] = true;
                        temp.remove(temp.size() - 1);
                        break;
                        //cz agar hamein pehli baar mein hi mil gya then aage check
                        //karne ki zaroorat hi nhi hai
                    }
                }
            }
        }
        
        //now we form the output string 
        for (int i = 0; i < str.length; i++) {
            if(!marked[i]) {
                sx.append(str[i]);
            }
        }

        return sx.toString();
    }
}
