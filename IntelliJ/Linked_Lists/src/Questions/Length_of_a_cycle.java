package Questions;

public class Length_of_a_cycle {
    public int LengthCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while(fast!=null && fast.next!=null ){
            fast = fast.next.next;
            slow = slow.next;
            if(fast==slow){
                //calculating the length now
                ListNode temp = slow;
                int length = 0;
                do {
                    temp=temp.next;
                    length++;
                }while (temp!=slow);//or temp!=fast
                return length;
            }
        }

        return 0;
        //if cycle is not present return 0

    }
    public static void main(String[] args) {

    }

}
