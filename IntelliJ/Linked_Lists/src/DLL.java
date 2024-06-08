public class DLL {
    private Node head;
    //by default the ref var of an object points to null
    public void insertFirst(int value){
        Node node = new Node(value);
        node.next = head;
        node.prev = null;

        if (head!=null) {
            head.prev = node;
        }
        head = node;
    }

    public Node delete(Node head, Node d) {
        //here we are given a node ( not head or tail )
        //which we need to delete and return its value


        //find the Node - 1 node
        //and find the Node + 1 node
        Node dm1 = d.prev;
        Node dp1 = d.next;

        dm1.next = dp1;
        dp1.prev = dm1;

        d.next = null;
        d.prev = null;

        return d;
    }
    public void display(){
        Node node = head;
        while (node != null){
            System.out.print(node.value + "-> ");
            node = node.next;
        }
        System.out.println("END");
    }
    public void displayReverse(){
        Node node = head;
        Node last = null;
        while (node != null){
            last = node;
            node = node.next;
        }

        while (last!=null){
            System.out.print(last.value + "-> ");
            last = last.prev;
        }
        System.out.println("START");
    }
    public void insertLast(int value){
        Node node = new Node(value);
        //hence
        node.next = null;
        Node temp = head;
        //this temp must be traversed till the last node
        //first, dealing with an edge case
        if (head==null){
            node.prev = null;
            head = node;
            return;
        }
        while (temp.next!=null){
            temp = temp.next;
        }
        temp.next = node;
        node.prev = temp;

    }
    public void insertBeforeTail(Node head, Node tail, Node n1) {
        //insert Node n1 before tail
        Node beforeTail = tail.prev;
        beforeTail.next = n1;
        n1.next = tail;
        n1.prev = tail.prev;
        tail.prev = n1;
    }
    public void insertAfter(int after, int value){
        //int value -> value of node that we want to insert after 'p' node
        Node p = findNode(after);
        if (p==null){
            //means we weren't able to find a node with the passed value
            System.out.println("Node doesn't exist");
            return;
        }
        Node node = new Node(value);
        node.next = p.next;
        p.next = node;
        node.prev = p;
        if (node.next!=null){
            node.next.prev= node;
        }

    }

    private Node findNode(int value) {
        Node node = head;
        while(node!=null){
            if (node.value == value){
                return node ;
            }
            node = node.next;
        }
        return null;
    }

    private class Node {
        int value;
        Node next;
        Node prev;

        public Node(int value) {
            this.value = value;
        }

        public Node(int value, Node next, Node prev) {
            this.value = value;
            this.next = next;
            this.prev = prev;
        }

    }

}
