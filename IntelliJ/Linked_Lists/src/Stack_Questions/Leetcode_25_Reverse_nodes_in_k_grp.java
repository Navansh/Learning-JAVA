package Stack_Questions;

public class Leetcode_25_Reverse_nodes_in_k_grp {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (k==1){
            head = reverseList(head);
            return head;
        }
        if (k<1||head==null){
            return head;
        }

        ListNode present = head;
        //it is LL's head
        ListNode prev = null;

        while (true){
            //hence we store the location of prev
            ListNode last = prev;
            ListNode newEnd = present;

            //now as we have stored the nodes required to stitch the reversed LL after reversing it
            //now just get the 3rd pointer
            ListNode next = present.next;
            //let's reverse now till k

            //but first we need to check if there are k elements available for us to reverse or not
            //if not then we keep them intact
            ListNode temp = present;
            for (int i = 0; i < k; i++) {
                temp = temp.next;
            }
            if (temp==null){
                return head;
            }

            for (int i = 0;present!=null &&  i < k; i++) {
//            right-left+1 -> no of elements b/w left and right
                present.next = prev;
                prev = present;
                present = next;
                if (next!=null){
                    next = next.next;
                    //did the check as doing this may give null pointer exception at certain time
                }
            }

            if (last!=null){
                last.next = prev;
            } else {
                head = prev;
            }

            newEnd.next = present;
            if (present==null){
                break;
            }
            //for the next part, the prev = new ENd
            prev = newEnd;
        }
        return head;

    }

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

        if (last!=null){
            last.next = prev;
        } else {
            head = prev;
        }

        newEnd.next = present;
        return head;
    }
    public ListNode reverseList(ListNode head) {
        if(head==null){
            return head;
        }

        ListNode prev = null;
        ListNode present = head;
        ListNode next1 = present.next;

        while (present!=null){
            present.next = prev;
            prev = present;
            present = next1;
            if (next1!=null){
                next1 = next1.next;
                //did the check as doing this may give null pointer exception at certain time
            }
        }
        head = prev;
        return head;
    }

}
