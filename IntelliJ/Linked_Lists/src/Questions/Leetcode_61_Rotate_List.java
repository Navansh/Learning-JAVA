package Questions;

public class Leetcode_61_Rotate_List {
    public ListNode rotateRight(ListNode head, int k) {
        if (head==null|| head.next ==null||k<=0){
            return head;
        }

        //first thing to do : find the last node
        ListNode last = head;
        int length = 1;
        while (last.next!=null){
            last = last.next;
            length++;
        }

        last.next = head;
        int rotations = k % length; //****IMP*****
        int skips = length - rotations;
        //if we skip these many, then we will land at new last
        ListNode newLast = head;
        //starts from head and then we iterate it to bring it to newLast node
        for (int i = 0; i < skips - 1; i++) {
            //cz we are already starting from head, so we need to iterate-> [0 to skips - 2 times]
            //so that we can reach our newLast node
            newLast = newLast.next;
        }
        //hence,
        head = newLast.next;
        newLast.next = null;

        return head;
        //leetcode requires us to return head, that's why we do here
        //otherwise even if we had void return type an LL calls it, then also it will work
        //as we will(through this function) change the original LL
    }
}
