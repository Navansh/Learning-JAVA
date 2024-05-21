package LL_Questions;

public class Leetcode_143_Reorder_List {
    public static void main(String[] args) {


    }

    static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static void insertFirst(int val, ListNode head) {
        ListNode node = new ListNode(val);
        node.next = head;
        head = node;
    }
    public static void reorderList(ListNode head) {
        if (head==null || head.next == null){
            return;
        }

        ListNode mid = middleNode(head);
        ListNode headFirst = head;
        ListNode headSecond = reverseList(mid);

        //rearrange the LL now
        while (headFirst!=null&&headSecond!=null) {
            ListNode temp = headFirst.next;
            headFirst.next = headSecond;
            headFirst = temp;
            //hence we have our headFirst restored to the second place as if it was our OG(non reordered) LL
            //now we'll restore our headSecond to the next of headSecond as if it was our OG(non reordered) LL
            temp = headSecond.next;
            headSecond.next = headFirst;
            headSecond = temp;
        }
        if (headFirst!=null){
            headFirst.next = null;
            //and by this we complete our reordered LL

        }

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
