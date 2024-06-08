package LL_Questions;

public class Clone_LL_with_Random_Pointer {
    public static void main(String[] args) {

    }

    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public Node copyRandomList(Node head) {
        //1st step : Insertion
        //add the new nodes to the current LL
        if(head == null) {
            return head;
        }
        Node t1 = head;
        while (t1!=null) {
            Node temp = new Node(t1.val);
            temp.next = t1.next;
            t1.next = temp;
            t1 = t1.next.next;
        }

        //Step 2 : setting the random pointer for the newly created nodes
        t1 = head;

        while (t1!= null) {
            if(t1.random != null) {
                t1.next.random = t1.random.next;
            }
            t1 = t1.next.next;
        }

        //Step3 : Segregate the old and new LL
        t1 = head;
        Node t2 = t1.next;
        Node head2 = t2;
        while (t1!=null) {
            t1.next = t2.next;
            if(t2.next !=null) {
                t2.next = t2.next.next;
            }

            t1 = t1.next;
            t2 = t2.next;
        }

        return head2;





    }
}
