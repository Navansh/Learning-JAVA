package Stack_Questions;

import java.util.Collections;
import java.util.PriorityQueue;

public class Find_Median_from_Data_Stream {
    public static void main(String[] args) {

    }


}

class MedianFinder {
    //this is the maxHeap for leftSide
    PriorityQueue<Integer> left = new PriorityQueue<>(Collections.reverseOrder());

    //This is the minHeap for rightSide
    PriorityQueue<Integer> right = new PriorityQueue<>();
    public MedianFinder() {
        //this is the constructor, for the question we don't need this
    }

    public void addNum(int num) {
        //there will be 2 cases : when we want to add an
        //Odd-th number : meaning there are already equal number of elements
        //present in both the Heaps(can happen only when we've put even number of eleme
        //already in it ) and now we're adding an odd-th number
        if(left.size() == right.size()) {
            //we want to actually add to left ( because we've pre-decided to add
            //an extra ( if happens ) to left side only )
            //we could've wrote logic to add this on the right side, and it would've have
            //also worked

            //hence pass it through right first and then add to left
            right.add(num);
            left.add((right.remove()));
        } else {
            //they already have an uneven ( as in no. of elem, the condition of left elements being
            // less than equal to right still holds true) distribution of elements

            //hence here we've to add to right, which we'll eventually do by passing it first
            //through left
            left.add(num);
            right.add(left.remove());
        }
    }

    public double findMedian() {
        double ans = 0.000;
        if(left.size() == right.size()) {
            ans = (left.peek() + right.peek())/2.0;
            return ans;
        }

        ans = left.peek();
        return ans;
    }
}
