package Stack_Questions;

//class ListNode {
//    int val;
//    ListNode next;
//    ListNode() {}
//    ListNode(int val) { this.val = val; }
//    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
//}

public class Leetcode_92_Reverse_part_of_LL {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        //here left and right denote the position(starting from 1) of the nodes, from which we want to
        //start and stop reversal
        if (left==right){
            //hence no reversal takes place
            return head;
        }
        //skip the first l-2 nodes, such that we reach (l-1)th node
        ListNode present = head;
        //it is LL's head
        ListNode prev = null;
        for (int i = 0; present!=null && i < left-1; i++) {
            prev = present;
            present = present.next; 
        }
        //hence by the time this loop ends, present will be at left's  position and prev would at present-1
        //hence we store the location of prev
        ListNode last = prev;
        ListNode newEnd = present;

        //now as we have stored the nodes required to stitch the reversed LL after reversing it
        //now just get the 3rd pointer
        ListNode next = present.next;
        //let's reverse now b/w left and right

        for (int i = 0;present!=null &&  i < right-left+1; i++) {
//            right-left+1 -> no of elements b/w left and right
                present.next = prev;
                prev = present;
                present = next;
                if (next!=null){
                    next = next.next;
                    //did the check as doing this may give null pointer exception at certain time
                }
        }

        //case when there is difference between the starting position and the left and right indices
        if (last!=null){
            last.next = prev;
        } else {
            //case when you are reversing from start
            head = prev;
        }

        newEnd.next = present;
        return head;
    }
}
