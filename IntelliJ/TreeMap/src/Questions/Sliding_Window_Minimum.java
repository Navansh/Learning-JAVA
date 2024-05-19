package Questions;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

public class Sliding_Window_Minimum {
    public static void main(String[] args) {
        //https://codedrills.io/drills/queue/problems/sliding-window-minimum
    }

    public ArrayList<Integer> getMinimums(ArrayList<Integer> nums, int k) {
        Deque<Integer> dq = new LinkedList<>();
        ArrayList<Integer> ans = new ArrayList<>();

        if(k>nums.size()) return ans;
        //these are number of subarrays so possible

        //solve for the first k elements firstly
        //hence forming the 1st window
        //but in dq we add only the req elements
        for (int i = 0; i < k; i++) {
            while (dq.size() > 0 && dq.getLast() > nums.get(i)) {
                //when the last condition happens only then we remove
                //then that last element can never be the ans so remove it
                //from dq
                dq.removeLast();
            }

            dq.addLast(nums.get(i));
        }

        //add the ans for the first window
        //as uske baad ki saari windows ke liye hum next loop run karenge
        ans.add(dq.getFirst());

        //now we've processed from 0 to (k - 1)th index
        //now we'll start with the window from index k

        for (int i = k; i < nums.size(); i++) {

            //here also check to remove the element which was previously present
            //as max in the queue and is now out of our window(hence not max now)
            //so our window here if from ((i - k + 1) to to i)


            while (dq.size() > 0 && dq.getLast() > nums.get(i)) {
                //when the last condition happens only then we remove
                //then that last element can never be the ans so remove it
                //from dq
                dq.removeLast();
            }

            dq.addLast(nums.get(i));

            if(dq.getFirst() == nums.get(i - k)) {
                dq.removeFirst();
            }
            //if this is not the case, then that value has already been removed using
            //the above condition

            ans.add(dq.getFirst());
        }

        return ans;
    }
}
