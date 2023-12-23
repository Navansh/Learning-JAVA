package Questions;
//https://leetcode.com/problems/middle-of-the-linked-list/
//class ListNode {
//    int val;
//    ListNode next;
//    ListNode() {}
//    ListNode(int val) { this.val = val; }
//    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
//}

public class Leetcode_876_Middle_of_LL {
    //we'll be using fast and slow ponter approach
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
}
