package LL_Questions;

public class Intersection_of_2_LLs {
    public static void main(String[] args) {

    }

    class Node {
        int data;
        Node next;
        Node(int d)  { data = d;  next = null; }
    }

    int intersectPoint(Node head1, Node head2) {
        //firstly find the length of both the LLs
        int lengthLL1 = 0;
        int lengthLL2 = 0;

        Node LL1 = head1;
        Node LL2 = head2;

        while (LL1!= null) {
            lengthLL1++;
            LL1 = LL1.next;
        }

        while (LL2!= null) {
            lengthLL2++;
            LL2 = LL2.next;
        }

        //find the difference and the bigger LL
        if(lengthLL1 > lengthLL2) {
            //move the LL1 difference times ahead and they will meet at the common point
            return findCommon(head1, head2, lengthLL1 - lengthLL2);
        }

        return findCommon(head2, head1, lengthLL2 - lengthLL1);
    }

    private int findCommon(Node biggerLL, Node smallerLL, int difference) {
        //move the biggerLL difference jitna ahead
        while (difference!= 0) {
            biggerLL = biggerLL.next;
            difference--;
        }

        //now start moving them ahead one by one
        while (biggerLL != smallerLL) {
            biggerLL = biggerLL.next;
            smallerLL = smallerLL.next;
        }

        if(biggerLL == null) {
            return -1;
            //meaning they both didn't intersect
        }

        return biggerLL.data;
    }
}
