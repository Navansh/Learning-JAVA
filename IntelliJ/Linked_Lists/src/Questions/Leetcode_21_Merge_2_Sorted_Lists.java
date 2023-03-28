package Questions;
class ListNode1 {
    int val;
    ListNode1 next;
    ListNode1() {}
    ListNode1(int val) { this.val = val; }
    ListNode1(int val, ListNode1 next) { this.val = val; this.next = next; }
}

public class Leetcode_21_Merge_2_Sorted_Lists {
    public static ListNode1 mergeTwoLists(ListNode1 list1,ListNode1 list2){
        ListNode1 headLL1 = list1;
        ListNode1 headLL2 = list2;

        ListNode1 ans = new ListNode1();
        while(headLL1 != null && headLL2!=null){
            //if anyone of them is null, then that list is empty(initially or became empty(because of head
            // moving forwards) due to our traversal
            if (headLL1.val<= headLL2.val){
                ans.insertLast(headLL1.val);
                headLL1 = headLL1.next;
            }else {
                ans.insertLast(headLL2.val);
                headLL2 = headLL2.next;
            }
        }

        //now seeing if either one of them has become null, so that we can just copy the elements from the other LL
        //to our answer LL

        return ans;
        while (headLL1!=null){
            ans.insertLast(headLL1.val);
            headLL1 = headLL1.next;
        }
        while (headLL2!=null){
            ans.insertLast(headLL2.val);
            headLL2 = headLL2.next;
        }



    }
}
