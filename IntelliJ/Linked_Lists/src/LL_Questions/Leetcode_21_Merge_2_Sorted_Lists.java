package LL_Questions;
//class ListNode1 {
//    int val;
//    ListNode1 next;
//    ListNode1() {}
//    ListNode1(int val) { this.val = val; }
//    ListNode1(int val, ListNode1 next) { this.val = val; this.next = next; }
//
//}
//
public class Leetcode_21_Merge_2_Sorted_Lists {

    //https://www.geeksforgeeks.org/problems/merge-two-sorted-linked-lists/1?itm_source=geeksforgeeks
    class Node {
        int data;
        Node next;
        Node(int d) {data = d; next = null; }
    }

    Node sortedMerge(Node head1, Node head2) {
        //first compare the head so that we can assign that to the ans var
        Node ans = null;
        //this will always point to the end of our joint LL
        //represents the head of the sorted LL
        if(head1 == null) {
            return head2;
        } else if(head2 == null) {
            return head1;
        }

        Node headOfJoint = null;
        //this represents the head of the Joint LL


        if(head1.data < head2.data) {
            ans = head1;
            headOfJoint = ans;
            head1 = head1.next;
        } else {
            ans = head2;
            headOfJoint = ans;
            head2 = head2.next;
        }


        while(head1 != null && head2!=null){
            //if anyone of them is null, then that list is empty(initially or became empty
            //(because of head moving forwards) due to our traversal
            if (head1.data<= head2.data){
                ans.next = (head1);
                ans = ans.next;
                //cz we have to always point to the last node of the ans list
                head1 = head1.next;
            }else {
                ans.next = (head2);
                ans = ans.next;
                head2 = head2.next;
            }
        }

        //now seeing if either one of them has become null, so that we can just copy the elements from the other LL
        //to our answer LL


        while (head1!=null){
            ans.next = (head1);
            ans = ans.next;
            //cz we have to always point to the last node of the ans list
            head1 = head1.next;
        }
        while (head2!=null){
            ans.next = (head2);
            ans = ans.next;
            head2 = head2.next;
        }
        return headOfJoint;
    }
//    public static ListNode1 mergeTwoLists(ListNode1 list1,ListNode1 list2){
//        ListNode1 headLL1 = list1;
//        ListNode1 headLL2 = list2;
//
//        ListNode1 ans = new ListNode1();
//        while(headLL1 != null && headLL2!=null){
//            //if anyone of them is null, then that list is empty(initially or became empty
//            (because of head moving forwards) due to our traversal
//            if (headLL1.val<= headLL2.val){
//                ans.insertLast(headLL1.val);
//                headLL1 = headLL1.next;
//            }else {
//                ans.insertLast(headLL2.val);
//                headLL2 = headLL2.next;
//            }
//        }
//
//        //now seeing if either one of them has become null, so that we can just copy the elements from the other LL
//        //to our answer LL
//
//        return ans;
//        while (headLL1!=null){
//            ans.insertLast(headLL1.val);
//            headLL1 = headLL1.next;
//        }
//        while (headLL2!=null){
//            ans.insertLast(headLL2.val);
//            headLL2 = headLL2.next;
//        }
//
//
//
//    }
}
