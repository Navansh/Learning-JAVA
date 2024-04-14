package Stack_Questions;

/**
 * This is for JAVADoc
 */
//https://leetcode.com/problems/linked-list-cycle-ii/
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
public class Leetcode_142_HeadOfLinkedListCycle {
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
    public ListNode detectCycle(ListNode head) {
        int length = 0;
        //of cycle
        ListNode fast = head;
        ListNode slow = head;

        while(fast!=null && fast.next!=null ){
            fast = fast.next.next;
            slow = slow.next;
            if(fast==slow){
                length = LengthCycle(slow);
                break;
            }
        }

        if (length==0){
            return null;
            //means no cycle is present
        }
        //this means now we have a cycle and we need to find its start
        ListNode first = head;
        ListNode second = head;

        //now we have to move second->length of cycle times ahead
        while (length>0){
            second = second.next;
            length--;
        }
        //keep moving both forward and where they'll meet is the node where the cycle starts
        while (first!=second){
            first = first.next;
            second = second.next;
        }
        return first;//or second as they both are anyways pointing to the same node
    }
}
