public class Reverse_LL {
    //this is how we can reverse a LL
    public static void main(String[] args) {

    }
}
 class LL1 {
    private Node head;
    private Node tail;
    private int size;

    public LL1() {
        this.size = 0;
    }

     private void ReverseLL(LL1.Node node){
        //this is using recursion
         if (node==tail){
             head = tail;
             return;
         }
         ReverseLL(node.next);
         //this will keep hitting until the base condition is met
         //now it has set the tail as the head and we are moving outwards of the recursion calls now
         tail.next = node;
         tail = node;
         tail.next = null;
     }

     private void reverseIterative(){
        if (size<2){
            return;
        }
        Node prev = null;
        Node present = head;
        Node next = present.next;

        while (present!=null){
            present.next = prev;
            prev = present;
            present = next;
            if (next!=null){
                next = next.next;
                //did the check as doing this may give null pointer exception at certain time
            }
        }
        head = prev;
     }

    public void insertLast(int val) {
        if (tail == null) {
            //means the list is empty
            insertFirst(val);
            return;
        }
        Node node = new Node(val);
        tail.next = node;
        tail = node;
        size++;
    }

    public void insert(int val, int index) {
        if (index == 0) {
            insertFirst(val);
            return;
        }
        if (index == size) {
            insertLast(val);
            return;
        }
        Node temp = head;
        for (int i = 1; i < index; i++) {
            //wouldn't start from 0, as that is head itself and we want node to be at
            //1 index before the index passed
            temp = temp.next;
        }
        //now temp is one index before where we have to insert
        //hence,
//        Node n1 = temp.next;
//        Node node = new Node(val);
//        temp.next = node;
//        node.next = n1;
//        or we can directly do
        Node node = new Node(val, temp.next);
        temp.next = node;

    }

    //insert using recursion
    public void insertRec(int value, int index){
        //insert value at index
        head = insertRec(value,index, head);
    }
    private Node insertRec(int val, int index1, Node node){
        if (index1==0){
            Node temp = new Node(val,node);
            size++;
            return temp;
        }
        index1 = index1 -1 ;
        node.next = insertRec(val,index1,node.next);
        return node;
    }

    public Node findNode(int value) {
//        returns the ref pointer to node at that particular index
        Node node = head;
        while (node != null){
            if (node.value==value)
            {
                return node;
            }
            node = node.next;
        }
        return null;
        //if there is no node with the passed value, then return null
    }
    public Node getNode(int index) {
//        returns the ref pointer to node at that particular index
        Node node = head;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node;
    }

    public int deleteLast() {
        if (size <= 1) {
            return deleteFirst();
        }

        Node secondLast = getNode(size - 2);//not size-1 => as we need index
        int value = tail.value;
        tail = secondLast;
        tail.next = null;
        return value;
    }

    public int deleteIndex(int index) {
        if (index == 0) {
            return deleteFirst();
        }
        if (index == size - 1) {
            return deleteLast();
        }

        Node prev = getNode(index - 1);
        int value = (prev.next).value;

        prev.next = prev.next.next;


        return value;
    }

    public int deleteFirst() {
        int value = head.value;
        head = head.next;
        if (head == null) {
            tail = null;
        }
        size--;
        return value;
    }

    public void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.value + "->");
            temp = temp.next;
        }
        System.out.println("END");
    }

    public void insertFirst(int val) {
        Node node = new Node(val);
        node.next = head;
        head = node;

        if (tail == null) {
            //means the linked list is empty
            tail = head;
        }
        size += 1;
    }


    public class Node {
        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
        }

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }

    }


}


