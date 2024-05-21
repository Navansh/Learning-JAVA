package LL_Questions;

public class GFG_Reverse_Alternate_K_Grp {
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

        while (present!=null){
            //(while condition changed)
            //hence we store the location of prev
            ListNode last = prev;
            ListNode newEnd = present;

            //now as we have stored the nodes required to stitch the reversed LL after reversing it
            //now just get the 3rd pointer
            ListNode next = present.next;
            //let's reverse now till k

            //but first we need to check if there are k elements available for us or not


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
            //skip the k nodes ( different here )
            for (int i = 0; present!=null && i < k; i++) {
                prev = present;
                present = present.next;
            }
        }
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
