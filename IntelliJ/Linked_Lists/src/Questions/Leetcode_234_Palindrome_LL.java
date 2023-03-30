package Questions;
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
public class Leetcode_234_Palindrome_LL {
    public boolean isPalindrome(ListNode head) {
        ListNode mid = middleNode(head);
        //now we are reversing the second half
        ListNode headSecond = reverseList(mid);
        ListNode reReverseHead = headSecond;
        //will be required when we rereverse
    }
    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast!=null &&fast.next !=null){
            //for even or odd number of nodes in a LL, adding both the conditions
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
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
